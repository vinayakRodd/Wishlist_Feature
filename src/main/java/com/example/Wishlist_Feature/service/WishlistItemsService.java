package com.example.Wishlist_Feature.service;

import com.example.Wishlist_Feature.model.Bond;
import com.example.Wishlist_Feature.model.Wishlist_Items;
import com.example.Wishlist_Feature.model.WishlistBondId;
import com.example.Wishlist_Feature.repository.BondRepository;
import com.example.Wishlist_Feature.repository.WishlistItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishlistItemsService {
    private final WishlistItemsRepository wishlistItemsRepo;
    private final BondRepository bondRepo;


    @Transactional
    public Wishlist_Items addBondToWishlist(Integer wishlistId, String isin) {
        if (wishlistItemsRepo.countByIdWishlistId(wishlistId) >= 10) {
            throw new IllegalStateException("Maximum limit of 10 bonds per wishlist reached.");
        }
        WishlistBondId bondId = new WishlistBondId(wishlistId, isin);
        if (wishlistItemsRepo.existsById(bondId)) {
            throw new IllegalArgumentException("Bond already exists in this wishlist.");
        }
        Wishlist_Items item = new Wishlist_Items();
        item.setId(bondId);
        return wishlistItemsRepo.save(item);
    }

    public List<Bond> getBondsInWishlist(Integer wishlistId) {
        List<Wishlist_Items> items = wishlistItemsRepo.findByIdWishlistId(wishlistId);

        List<String> isinList = items.stream()
                .map(item -> item.getId().getIsin())
                .collect(Collectors.toList());

        return bondRepo.findByIsinIn(isinList);
    }

    @Transactional
    public void deleteBondFromWishlist(Integer wishlistId, String isin) {
        wishlistItemsRepo.deleteById(new WishlistBondId(wishlistId, isin));
    }
}