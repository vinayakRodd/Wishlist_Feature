package com.example.Wishlist_Feature.repository;

import com.example.Wishlist_Feature.model.Bond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BondRepository extends JpaRepository<Bond, String>, JpaSpecificationExecutor<Bond> {

    // Spring Data JPA automatically implements this as:
    // SELECT * FROM bond WHERE isin IN (:isins)
    List<Bond> findByIsinIn(List<String> isins);
}