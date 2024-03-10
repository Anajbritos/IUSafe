package io.ana.julia.iusafe.data.mapper;

import io.ana.julia.iusafe.data.dto.InsuranceDTO;
import io.ana.julia.iusafe.data.dto.InsuranceTypeDTO;
import io.ana.julia.iusafe.data.entity.InsuranceEntity;
import io.ana.julia.iusafe.data.entity.InsuranceTypeEntity;
import org.springframework.stereotype.Component;

@Component
public class InsuranceMapper {

    public InsuranceEntity toEntity(InsuranceDTO insuranceDTO){
         return new InsuranceEntity(
                 insuranceDTO.getId(),
                 insuranceDTO.getDescription(),
                 insuranceDTO.getValue(),
                 insuranceDTO.getCoverageValue(),
                 toTypeEntity(insuranceDTO.getInsuranceTypeDTO()),
                 insuranceDTO.getCoverageDescription()
         );
    }

    public InsuranceTypeEntity toTypeEntity(InsuranceTypeDTO insuranceTypeDTO) {
        return switch (insuranceTypeDTO) {
            case CARD -> InsuranceTypeEntity.CARD;
            case AUTO -> InsuranceTypeEntity.AUTO;
            case RESIDENTIAL -> InsuranceTypeEntity.RESIDENTIAL;
            case TRAVEL -> InsuranceTypeEntity.TRAVEL;
            case CELLPHONE -> InsuranceTypeEntity.CELLPHONE;
            case PET -> InsuranceTypeEntity.PET;
            default -> throw new IllegalArgumentException("Tipo de seguro inválido");
        };
    }

    public InsuranceDTO toDTO(InsuranceEntity insuranceEntity) {
        return new InsuranceDTO(
                insuranceEntity.getId(),
                insuranceEntity.getDescription(),
                insuranceEntity.getValue(),
                insuranceEntity.getCoverageValue(),
                toTypeDTO(insuranceEntity.getInsuranceType()),
                insuranceEntity.getCoverageDescription()
        );
    }

    public InsuranceTypeDTO toTypeDTO(InsuranceTypeEntity insuranceTypeEntity) {
        return switch (insuranceTypeEntity) {
            case CARD -> InsuranceTypeDTO.CARD;
            case AUTO -> InsuranceTypeDTO.AUTO;
            case RESIDENTIAL -> InsuranceTypeDTO.RESIDENTIAL;
            case TRAVEL -> InsuranceTypeDTO.TRAVEL;
            case CELLPHONE -> InsuranceTypeDTO.CELLPHONE;
            case PET -> InsuranceTypeDTO.PET;
            default -> throw new IllegalArgumentException("Tipo de seguro inválido");
        };
    }
}
