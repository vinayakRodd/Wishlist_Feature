package com.example.Wishlist_Feature.service;

import com.example.Wishlist_Feature.model.Wishlist;
import com.example.Wishlist_Feature.repository.WishlistRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class WishlistService {

    private final WishlistRepository repo;

    public WishlistService(WishlistRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Wishlist create(Wishlist w) {

        if (w.getWishlistName() == null || w.getWishlistName().trim().isEmpty()) {
            throw new IllegalArgumentException("Wishlist name cannot be empty.");
        }

        if (w.getWishlistName().trim().length() > 21) {
            throw new IllegalArgumentException("Wishlist name cannot exceed 20 characters.");
        }

        if (repo.count() >= 5) {
            throw new IllegalStateException("Maximum limit of 5 wishlists reached.");
        }

        try {
            return repo.save(w);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new IllegalArgumentException("A wishlist with the name '" + w.getWishlistName() + "' already exists.");
        }
    }

    public List<Wishlist> getAll() {
        return repo.findAll();
    }

    @Transactional
    public Wishlist updateWishlist(Integer id, Map<String, Object> updates) {
        Wishlist existingWishlist = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Wishlist not found with id: " + id));

        updates.forEach((key, value) -> {
            // Prevent tampering with the primary key
            if (!key.equals("wishlistId")) {
                Field field = ReflectionUtils.findField(Wishlist.class, key);
                if (field != null) {
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, existingWishlist, value);
                }
            }
        });

        return repo.save(existingWishlist);
    }

    @Transactional
    public void delete(Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Wishlist not found with id: " + id);
        }
    }
}