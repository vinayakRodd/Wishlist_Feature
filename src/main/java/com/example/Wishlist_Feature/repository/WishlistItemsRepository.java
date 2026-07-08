package com.example.Wishlist_Feature.repository;

import com.example.Wishlist_Feature.model.Wishlist_Items;
import com.example.Wishlist_Feature.model.WishlistBondId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WishlistItemsRepository extends JpaRepository<Wishlist_Items, WishlistBondId> {
    // Navigate into the embedded 'id' property
    List<Wishlist_Items> findByIdWishlistId(Integer wishlistId);
    long countByIdWishlistId(Integer wishlistId);
}