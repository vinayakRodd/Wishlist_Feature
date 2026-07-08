package com.example.Wishlist_Feature.controller;

import com.example.Wishlist_Feature.model.Bond;
import com.example.Wishlist_Feature.model.Wishlist_Items;
import com.example.Wishlist_Feature.service.WishlistItemsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/wishlist-items")
public class WishlistItemsController {

    private final WishlistItemsService service;

    public WishlistItemsController(WishlistItemsService service) { this.service = service; }

    @PostMapping("/{wishlistId}/{isin}")
    public ResponseEntity<Wishlist_Items> addBond(@PathVariable Integer wishlistId, @PathVariable String isin) {
        return ResponseEntity.ok(service.addBondToWishlist(wishlistId, isin));
    }

    @GetMapping("/{wishlistId}")
    public ResponseEntity<List<Bond>> getBonds(@PathVariable Integer wishlistId) {
        return ResponseEntity.ok(service.getBondsInWishlist(wishlistId));
    }

    @DeleteMapping("/{wishlistId}/{isin}")
    public ResponseEntity<Void> deleteBond(@PathVariable Integer wishlistId, @PathVariable String isin) {
        service.deleteBondFromWishlist(wishlistId, isin);
        return ResponseEntity.noContent().build();
    }
}