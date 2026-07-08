package com.example.Wishlist_Feature.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "wishlist_items")
public class Wishlist_Items {

    @EmbeddedId
    private WishlistBondId id; // This contains wishlist_id and isin

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}