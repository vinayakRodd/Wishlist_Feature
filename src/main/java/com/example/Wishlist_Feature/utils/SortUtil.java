
package com.example.Wishlist_Feature.utils;

import com.example.Wishlist_Feature.model.Bond;
import org.springframework.data.domain.*;
import java.util.*;

public class SortUtil {

    private static final Map<String, String> FIELD_MAPPING = Map.of(
            "yield", "yieldPct",
            "investment", "minInvestment",
            "maturity", "maturityDate",
            "name", "bondName",
            "coupon_rate", "couponRate",
            "face_value", "faceValue",
            "brand", "brandName",
            "brand_name", "brandName",
            "brand_Name", "brandName",
            "brandname", "brandName"
    );

    private static final Map<String, Integer> RATING_RANKS = Map.ofEntries(
            Map.entry("Sovereign", 1), Map.entry("AAA", 2), Map.entry("AA+", 3),
            Map.entry("AA", 4), Map.entry("AA-", 5), Map.entry("A+", 6),
            Map.entry("A", 7), Map.entry("A-", 8), Map.entry("BBB+", 9),
            Map.entry("BBB", 10), Map.entry("BBB-", 11), Map.entry("BB+", 12),
            Map.entry("BB", 13), Map.entry("BB-", 14), Map.entry("B+", 15),
            Map.entry("B", 16), Map.entry("B-", 17)
    );

    private static final Map<String, Integer> FREQUENCY_RANKS = Map.of(
            "Monthly", 1, "Quarterly", 2, "Semi-Annually", 3, "Annually", 4
    );

    public static String getActualFieldName(String input) {
        return FIELD_MAPPING.getOrDefault(input, input);
    }

    public static Comparator<Bond> getComparatorForField(String field, String direction) {
        Comparator<Bond> comp;
        switch (field) {
            case "yieldPct": comp = Comparator.comparing(Bond::getYieldPct, Comparator.nullsLast(Comparator.naturalOrder())); break;
            case "minInvestment": comp = Comparator.comparing(Bond::getMinInvestment, Comparator.nullsLast(Comparator.naturalOrder())); break;
            case "bondName": comp = Comparator.comparing(Bond::getBondName, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)); break;
            case "couponRate": comp = Comparator.comparing(Bond::getCouponRate, Comparator.nullsLast(Comparator.naturalOrder())); break;
            case "faceValue": comp = Comparator.comparing(Bond::getFaceValue, Comparator.nullsLast(Comparator.naturalOrder())); break;
            case "maturityDate": comp = Comparator.comparing(Bond::getMaturityDate, Comparator.nullsLast(Comparator.naturalOrder())); break;
            default: comp = Comparator.comparing(Bond::getCreatedAt, Comparator.nullsLast(Comparator.naturalOrder()));
        }
        return "desc".equalsIgnoreCase(direction) ? comp.reversed() : comp;
    }

    public static void sortBondsByRating(List<Bond> bonds, String direction) {
        Comparator<Bond> comp = Comparator.comparingInt(b -> RATING_RANKS.getOrDefault(b.getCreditRating(), 99));
        bonds.sort("desc".equalsIgnoreCase(direction) ? comp.reversed() : comp);
    }

    public static void sortBondsByFrequency(List<Bond> bonds, String direction) {
        Comparator<Bond> comp = Comparator.comparingInt(b -> FREQUENCY_RANKS.getOrDefault(b.getPayoutFrequency(), 99));
        bonds.sort("desc".equalsIgnoreCase(direction) ? comp.reversed() : comp);
    }

    public static <T> Page<T> paginateList(List<T> list, Pageable pageable) {
        int start = (int) Math.min((long) pageable.getOffset(), list.size());
        int end = (int) Math.min(start + pageable.getPageSize(), list.size());
        return new PageImpl<>(list.subList(start, end), pageable, list.size());
    }
}