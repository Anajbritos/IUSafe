package io.ana.julia.iusafe.data.dto;

import io.ana.julia.iusafe.data.entity.InsuranceTypeEntity;

import java.math.BigDecimal;

public class InsuranceDTO {

    private Long id;
    private String description;
    private BigDecimal value;
    private BigDecimal coverageValue;
    private InsuranceTypeDTO insuranceTypeDTO;
    private String coverageDescription;

    public InsuranceDTO(
            Long id,
            String description,
            BigDecimal value,
            BigDecimal coverageValue,
            InsuranceTypeDTO insuranceTypeDTO,
            String coverageDescription) {
        this.id = id;
        this.description = description;
        this.value =  value;
        this.coverageValue =  coverageValue;
        this.insuranceTypeDTO =  insuranceTypeDTO;
        this.coverageDescription =  coverageDescription;
    }

    public Long getId() {
        return this.id;
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

    public InsuranceTypeDTO getInsuranceTypeDTO() {
        return insuranceTypeDTO;
    }

    public void setInsuranceTypeDTO(InsuranceTypeDTO insuranceTypeDTO) {
        this.insuranceTypeDTO = insuranceTypeDTO;
    }

    public String getCoverageDescription() {
        return coverageDescription;
    }

    public void setCoverageDescription(String coverageDescription) {
        this.coverageDescription = coverageDescription;
    }
}
