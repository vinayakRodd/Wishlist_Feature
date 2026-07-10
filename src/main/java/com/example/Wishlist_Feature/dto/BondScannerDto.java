package com.example.Wishlist_Feature.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder // Using Builder allows for clean object creation
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
}