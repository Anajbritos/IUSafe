package io.ana.julia.iusafe.data.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "insurance")
public class InsuranceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "value")
    private BigDecimal value;
    @Column(name = "coverage_value")
    private BigDecimal coverageValue;
    @Column(name = "insurance_type")
    @Enumerated(EnumType.STRING)
    private InsuranceTypeEntity insuranceTypeEntity;
    @Column(name = "coverage_description")
    private String coverageDescription;

    public InsuranceEntity() {
    }

    public InsuranceEntity(
            Long id,
            String description,
            BigDecimal value,
            BigDecimal coverageValue,
            InsuranceTypeEntity insuranceTypeEntity,
            String coverageDescription) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.coverageValue = coverageValue;
        this.insuranceTypeEntity = insuranceTypeEntity;
        this.coverageDescription = coverageDescription;
    }

    public InsuranceEntity(
            String description,
            BigDecimal value,
            BigDecimal coverageValue,
            InsuranceTypeEntity insuranceTypeEntity,
            String coverageDescription) {
        this.description = description;
        this.value = value;
        this.coverageValue = coverageValue;
        this.insuranceTypeEntity = insuranceTypeEntity;
        this.coverageDescription = coverageDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getCoverageValue() {
        return coverageValue;
    }

    public void setCoverageValue(BigDecimal coverageValue) {
        this.coverageValue = coverageValue;
    }

    public InsuranceTypeEntity getInsuranceType() {
        return insuranceTypeEntity;
    }

    public void setInsuranceType(InsuranceTypeEntity insuranceTypeEntity) {
        this.insuranceTypeEntity = insuranceTypeEntity;
    }

    public String getCoverageDescription() {
        return coverageDescription;
    }

    public void setCoverageDescription(String coverageDescription) {
        this.coverageDescription = coverageDescription;
    }
}
