package com.example.Wishlist_Feature.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class WishlistBondId implements Serializable {
    private Integer wishlistId;
    private String isin;
}