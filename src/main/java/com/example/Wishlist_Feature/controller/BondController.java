package com.example.Wishlist_Feature.controller;

import com.example.Wishlist_Feature.constants.PaginationConstants;
import com.example.Wishlist_Feature.model.Bond;
import com.example.Wishlist_Feature.repository.BondRepository;
import com.example.Wishlist_Feature.service.BondService;
import com.example.Wishlist_Feature.utils.SortUtil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/bonds")
public class BondController {

    private static final Logger log = LoggerFactory.getLogger(BondController.class);
    private final BondService bondService;

    public BondController(BondService bondService) {
        this.bondService = bondService;
    }

    @GetMapping
    public ResponseEntity<?> getAllBonds(
            @RequestParam(required = false) String rating,
            @RequestParam(required = false) Double minYield,
            @RequestParam(required = false) String frequency,
            @RequestParam(required = false) @Size(min = 3, max = 50)String brand,
            @RequestParam(defaultValue = PaginationConstants.DEFAULT_PAGE) @Min(0) int page,
            @RequestParam(defaultValue = PaginationConstants.DEFAULT_LIMIT) @Positive @Max(PaginationConstants.MAX_LIMIT) int limit,
            @RequestParam(required = false) String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        return ResponseEntity.ok(bondService.getFilteredBonds(rating, minYield, frequency, brand, page, limit, sortBy, direction));
    }

    @PostMapping("/batch")
    public ResponseEntity<?> saveAllBonds(@Valid @RequestBody List<Bond> bonds) {
        try {
            List<Bond> savedBonds = bondService.saveAllBonds(bonds);
            log.info("Successfully saved {} bonds.", savedBonds.size());
            return ResponseEntity.ok(savedBonds);
        } catch (IllegalArgumentException e) {
            log.warn("Batch save rejected: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IllegalStateException e) {
            log.error("Batch save rejected: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            log.error("Database error during batch save: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving bonds: " + e.getMessage());
        }
    }
}