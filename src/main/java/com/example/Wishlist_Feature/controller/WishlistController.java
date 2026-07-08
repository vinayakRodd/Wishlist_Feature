package com.example.Wishlist_Feature.controller;

import com.example.Wishlist_Feature.model.Wishlist;
import com.example.Wishlist_Feature.service.WishlistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/wishlists")
public class WishlistController {

    private final WishlistService service;

    public WishlistController(WishlistService service) {
        this.service = service;
    }

    @PostMapping
    public Wishlist create(@RequestBody Wishlist w) {
        return service.create(w);
    }

    @GetMapping
    public List<Wishlist> getAll() {
        return service.getAll();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Wishlist> updateWishlist(
            @PathVariable Integer id,
            @RequestBody Map<String, Object> updates) {

        // Pass the entire map to the service
        Wishlist updatedWishlist = service.updateWishlist(id, updates);
        return ResponseEntity.ok(updatedWishlist);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}