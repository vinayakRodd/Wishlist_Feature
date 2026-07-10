package com.example.Wishlist_Feature.service;

import com.example.Wishlist_Feature.dto.BondScannerDto;
import com.example.Wishlist_Feature.mapper.BondMapper;
import com.example.Wishlist_Feature.model.Bond;
import com.example.Wishlist_Feature.repository.BondRepository;
import com.example.Wishlist_Feature.specification.BondSpecification;
import com.example.Wishlist_Feature.utils.SortUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class BondService {

    private final BondRepository bondRepository;
    private final BondMapper bondMapper;

    public Page<BondScannerDto> getFilteredBonds(String rating, Double minYield, String frequency, String brand,
                                                 int page, int limit, String sortBy, String direction) {

        // 1. Build Query
        Specification<Bond> spec = BondSpecification.withFilters(rating, minYield, frequency, brand);

        // 2. Database-level sorting
        Sort sort = Sort.unsorted();
        if (sortBy != null && !sortBy.isEmpty()) {
            String field = SortUtil.getActualFieldName(sortBy);
            Sort.Direction dir = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
            sort = Sort.by(dir, field);
        }

        // 3. Database fetch (Filtering, Sorting, and Pagination happen in SQL!)
        return bondRepository.findAll(spec, PageRequest.of(page, limit, sort)).map(bondMapper::toDto); // This handles the whole page automatically
    }

    public List<Bond> saveAllBonds(List<Bond> bonds) {
        // Business Rule: Empty check
        if (bonds == null || bonds.isEmpty()) {
            throw new IllegalArgumentException("Bond list cannot be null or empty.");
        }

        // Business Rule: Duplicate check
        long uniqueCount = bonds.stream().map(Bond::getIsin).distinct().count();
        if (uniqueCount != bonds.size()) {
            throw new IllegalStateException("Duplicate ISINs found in request.");
        }

        // Data Operation
        return bondRepository.saveAll(bonds);
    }
}