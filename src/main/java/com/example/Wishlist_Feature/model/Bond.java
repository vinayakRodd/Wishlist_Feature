package com.example.Wishlist_Feature.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
@Entity
@Table(name = "bonds")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bond {

    @Id
    @JsonProperty("isin")
    private String isin;

    @Column(name = "issuer_id")
    @JsonProperty("issuerId")
    private String issuerId;

    @Column(name = "bond_name")
    @JsonProperty("issuerName")
    private String bondName;

    @Column(name = "min_investment")
    @JsonProperty("minInvestmentAmount")
    private BigDecimal minInvestment;

    @Column(name = "min_units")
    @JsonProperty("minUnits")
    private Integer minUnit;

    @Column(name = "max_units")
    @JsonProperty("maxUnits")
    private Integer maxUnit;

    @Column(name = "yield_pct")
    @JsonProperty("yield")
    private BigDecimal yieldPct;

    @Column(name = "coupon_rate")
    @JsonProperty("couponRate")
    private BigDecimal couponRate;

    @Column(name = "coupon_type")
    @JsonProperty("couponType")
    private String couponType;

    @Column(name = "payout_frequency")
    @JsonProperty("payoutFrequency")
    private String payoutFrequency;

    @Column(name = "face_value")
    @JsonProperty("faceValue")
    private BigDecimal faceValue;

    @Column(name = "nature")
    @JsonProperty("nature")
    private String nature;

    @Column(name = "seniority")
    @JsonProperty("seniority")
    private String seniority;

    @Column(name = "mode_of_issue")
    @JsonProperty("modeOfIssue")
    private String modeOfIssue;

    @Column(name = "yield_type")
    @JsonProperty("yieldType")
    private String yieldType;

    @Column(name = "security_cover")
    @JsonProperty("securityCover")
    private BigDecimal securityCover;

    @Column(name = "debenture_trustee")
    @JsonProperty("debentureTrustee")
    private String debentureTrustee;

    @Column(name = "issue_date")
    @JsonProperty("issueDate")
    private LocalDate issueDate;

    @Column(name = "maturity_date")
    @JsonProperty("maturityDate")
    private OffsetDateTime maturityDate;

    @Column(name = "credit_rating")
    @JsonProperty("ratings")
    private String creditRating;

    @Column(name = "rating_agency")
    @JsonProperty("ratingAgency")
    private String ratingAgency;

    @Column(name = "rating_date")
    @JsonProperty("ratingDate")
    private LocalDate ratingDate;

    @Column(name = "total_interest")
    @JsonProperty("totalInterest")
    private BigDecimal totalInterest;

    @Column(name = "total_principal")
    @JsonProperty("totalPrincipal")
    private BigDecimal totalPrincipal;

    @Column(name = "total_payout")
    @JsonProperty("totalPayout")
    private BigDecimal totalPayout;

    @Column(name = "interest_frequency")
    @JsonProperty("interestFrequency")
    private String interestFrequency;

    @Column(name = "principal_frequency")
    @JsonProperty("principalFrequency")
    private String principalFrequency;

    @Column(name = "yield_bucket")
    @JsonProperty("yieldBucket")
    private String yieldBucket;

    @Column(name = "risk_bucket")
    @JsonProperty("riskBucket")
    private String riskBucket;

    @Column(name = "status")
    @JsonProperty("status")
    private String status;

    @Column(name = "created_at")
    @JsonProperty("createdAt")
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    @JsonProperty("updatedAt")
    private OffsetDateTime updatedAt;

    @Column(name = "raised_unit")
    @JsonProperty("raisedUnit")
    private BigDecimal raisedUnit;

    @Column(name = "raised_amount")
    @JsonProperty("raisedAmount")
    private BigDecimal raisedAmount;

    @Column(name = "deal_sub_type")
    @JsonProperty("dealSubType")
    private String dealSubType;

    @Column(name = "deal_sub_type_name")
    @JsonProperty("dealSubTypeName")
    private String dealSubTypeName;

    @Column(name = "styling")
    @JsonProperty("styling")
    private String styling;

    @Column(name = "styling_type")
    @JsonProperty("stylingType")
    private String stylingType;

    @Column(name = "platforms")
    @JsonProperty("platforms")
    private String platforms;

    @Column(name = "is_soldout")
    @JsonProperty("isSoldout")
    private Boolean isSoldout;

    @Column(columnDefinition = "TEXT")
    @JsonProperty("tags")
    private String tags;

    @Column(name = "issuer_logo_url")
    @JsonProperty("issuerLogoUrl")
    private String issuerLogoUrl;

    @Column(name = "principal_at_maturity")
    @JsonProperty("principalAtMaturity")
    private BigDecimal principalAtMaturity;

    @Column(name = "weight")
    @JsonProperty("weight")
    private BigDecimal weight;

    @Column(name = "total_invested_isin")
    @JsonProperty("totalInvestedISIN")
    private BigDecimal totalInvestedIsin;

    @Column(name = "brand_name")
    @JsonProperty("brandName")
    private String brandName;
}