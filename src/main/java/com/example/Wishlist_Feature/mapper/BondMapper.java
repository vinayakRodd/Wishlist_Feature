package com.example.Wishlist_Feature.mapper;

import com.example.Wishlist_Feature.dto.BondScannerDto;
import com.example.Wishlist_Feature.model.Bond;
import org.springframework.stereotype.Component;

@Component
public class BondMapper {

    public BondScannerDto toDto(Bond bond) {
        if (bond == null) return null;

        return BondScannerDto.builder()
                .isin(bond.getIsin())
                .issuerId(bond.getIssuerId())
                .issuerName(bond.getBrandName())
                .minInvestmentAmount(bond.getMinInvestment())
                .minUnit(bond.getMinUnit())
                .yield(bond.getYieldPct())
                .state(bond.getStatus())
                .raisedUnit(bond.getRaisedUnit())
                .raisedAmount(bond.getRaisedAmount())
                .dealSubType(bond.getDealSubType())
                .dealSubTypeName(bond.getDealSubTypeName())
                .styling(bond.getStyling())
                .stylingType(bond.getStylingType())
                .platforms(bond.getPlatforms())
                .isSoldout(bond.getIsSoldout())
                .tags(bond.getTags())
                .maturityDate(bond.getMaturityDate())
                .ratings(bond.getCreditRating())
                .issuerLogoUrl(bond.getIssuerLogoUrl())
                .payoutFrequency(bond.getPayoutFrequency())
                .principalAtMaturity(bond.getPrincipalAtMaturity())
                .weight(bond.getWeight())
                .totalInvestedISIN(bond.getTotalInvestedIsin())
                .createdAt(bond.getCreatedAt())
                .updatedAt(bond.getUpdatedAt())
                .build();
    }
}