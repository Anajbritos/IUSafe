package io.ana.julia.iusafe.data.mapper;

import io.ana.julia.iusafe.data.dto.InsuranceDTO;
import io.ana.julia.iusafe.data.dto.InsuranceTypeDTO;
import io.ana.julia.iusafe.data.entity.InsuranceEntity;
import io.ana.julia.iusafe.data.entity.InsuranceTypeEntity;
import io.ana.julia.iusafe.utils.DataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.math.BigDecimal;

public class InsuranceMapperTest {

    private final InsuranceMapper insuranceMapper = new InsuranceMapper();
    @Test
    public void shouldConvertInsuranceDTOIntoInsuranceEntity(){
        InsuranceDTO insuranceDTO = DataFactory.makeInsuranceDTO();
        InsuranceEntity insuranceEntity = insuranceMapper.toEntity(insuranceDTO);
        Assertions.assertEquals(insuranceEntity.getId(), insuranceDTO.getId());
        Assertions.assertEquals(insuranceEntity.getDescription(), insuranceDTO.getDescription());
        Assertions.assertEquals(insuranceEntity.getValue(), insuranceDTO.getValue());
        Assertions.assertEquals(insuranceEntity.getCoverageValue(), insuranceDTO.getCoverageValue());
        Assertions.assertEquals(insuranceEntity.getInsuranceType(), InsuranceTypeEntity.CARD);
        Assertions.assertEquals(insuranceEntity.getCoverageDescription(), insuranceDTO.getCoverageDescription());
    }

    @Test
    public void shouldConvertInsuranceEntityIntoInsuranceDTO(){
        InsuranceEntity insuranceEntity = DataFactory.makeInsuranceEntity();
        InsuranceDTO insuranceDTO = insuranceMapper.toDTO(insuranceEntity);
        Assertions.assertEquals(insuranceDTO.getId(), insuranceEntity.getId());
        Assertions.assertEquals(insuranceDTO.getDescription(), insuranceEntity.getDescription());
        Assertions.assertEquals(insuranceDTO.getValue(), insuranceEntity.getValue());
        Assertions.assertEquals(insuranceDTO.getCoverageValue(), insuranceEntity.getCoverageValue());
        Assertions.assertEquals(insuranceDTO.getInsuranceTypeDTO(), InsuranceTypeDTO.CARD);
        Assertions.assertEquals(insuranceDTO.getCoverageDescription(), insuranceEntity.getCoverageDescription());
    }

    @Test
    public void shouldConvertEntityInsuranceTypeToInsuranceDTOType(){
        InsuranceTypeDTO insuranceTypeDTO  = insuranceMapper.toTypeDTO(InsuranceTypeEntity.CARD);
        Assertions.assertEquals(insuranceTypeDTO, InsuranceTypeDTO.CARD);
    }

    @Test
    public void shouldConvertDTOInsuranceTypeToInsuranceEntityType() {
        InsuranceTypeEntity insuranceTypeEntity = insuranceMapper.toTypeEntity(InsuranceTypeDTO.CARD);
        Assertions.assertEquals(insuranceTypeEntity, InsuranceTypeEntity.CARD);
    }
}
