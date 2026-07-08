package com.example.Wishlist_Feature.repository;

import com.example.Wishlist_Feature.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
    long count(); // Standard JpaRepository method
    boolean existsByWishlistName(String name);
}