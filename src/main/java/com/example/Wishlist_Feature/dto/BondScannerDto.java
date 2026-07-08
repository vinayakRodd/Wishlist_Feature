package com.example.Wishlist_Feature.dto;

import com.example.Wishlist_Feature.model.Bond;
import lombok.Data;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class BondScannerDto {

    private String isin;
    private String issuerId;
    private String issuerName;
    private BigDecimal minInvestmentAmount;
    private Integer minUnit;
    private BigDecimal yield;
    private String state;
    private BigDecimal raisedUnit;
    private BigDecimal raisedAmount;
    private String dealSubType;
    private String dealSubTypeName;
    private String styling;
    private String stylingType;
    private String platforms;
    private Boolean isSoldout;
    private String tags;
    private OffsetDateTime maturityDate;
    private String ratings;
    private String issuerLogoUrl;
    private String payoutFrequency;
    private BigDecimal principalAtMaturity;
    private BigDecimal weight;
    private BigDecimal totalInvestedISIN;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    // This method handles the mapping logic inside the DTO
    public static BondScannerDto fromEntity(Bond bond) {
        BondScannerDto dto = new BondScannerDto();
        dto.setIsin(bond.getIsin());
        dto.setIssuerId(bond.getIssuerId());
        dto.setIssuerName(bond.getBrandName());
        dto.setMinInvestmentAmount(bond.getMinInvestment());
        dto.setMinUnit(bond.getMinUnit());
        dto.setYield(bond.getYieldPct());
        dto.setState(bond.getStatus());
        dto.setRaisedUnit(bond.getRaisedUnit());
        dto.setRaisedAmount(bond.getRaisedAmount());
        dto.setDealSubType(bond.getDealSubType());
        dto.setDealSubTypeName(bond.getDealSubTypeName());
        dto.setStyling(bond.getStyling());
        dto.setStylingType(bond.getStylingType());
        dto.setPlatforms(bond.getPlatforms());
        dto.setIsSoldout(bond.getIsSoldout());
        dto.setTags(bond.getTags());
        dto.setMaturityDate(bond.getMaturityDate());
        dto.setRatings(bond.getCreditRating());
        dto.setIssuerLogoUrl(bond.getIssuerLogoUrl());
        dto.setPayoutFrequency(bond.getPayoutFrequency());
        dto.setPrincipalAtMaturity(bond.getPrincipalAtMaturity());
        dto.setWeight(bond.getWeight());
        dto.setTotalInvestedISIN(bond.getTotalInvestedIsin());
        dto.setCreatedAt(bond.getCreatedAt());
        dto.setUpdatedAt(bond.getUpdatedAt());
        return dto;
    }
}