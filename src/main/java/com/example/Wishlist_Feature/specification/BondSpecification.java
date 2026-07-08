package com.example.Wishlist_Feature.specification;

import com.example.Wishlist_Feature.model.Bond;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class BondSpecification {
        public static Specification<Bond> withFilters(String rating, Double minYield, String frequency, String brand) {
            return (root, query, cb) -> {
                Predicate p = cb.conjunction();
                if (rating != null) p = cb.and(p, cb.equal(root.get("creditRating"), rating));
                if (minYield != null) p = cb.and(p, cb.greaterThanOrEqualTo(root.get("yieldPct"), minYield));
                if (frequency != null) p = cb.and(p, cb.equal(root.get("payoutFrequency"), frequency));
                if (brand != null) {
                    // This targets your GIN Trigram index for fuzzy search
                    p = cb.and(p, cb.like(cb.lower(root.get("brandName")), "%" + brand.toLowerCase() + "%"));
                }
                return p;
            };
        }

}