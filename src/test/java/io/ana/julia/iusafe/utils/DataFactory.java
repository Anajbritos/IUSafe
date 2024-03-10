package io.ana.julia.iusafe.utils;

import io.ana.julia.iusafe.data.dto.InsuranceDTO;
import io.ana.julia.iusafe.data.dto.InsuranceTypeDTO;
import io.ana.julia.iusafe.data.entity.InsuranceEntity;
import io.ana.julia.iusafe.data.entity.InsuranceTypeEntity;

import java.math.BigDecimal;

public final class DataFactory {

    public static InsuranceDTO makeInsuranceDTO() {
        return new InsuranceDTO(
                1L,
                "Seguro Mais Cartao Protegido",
                new BigDecimal("150.0"),
                new BigDecimal("50000.0"),
                InsuranceTypeDTO.CARD,
                "Cobrimos perda, roubo e furto de cartão");
    }

    public static InsuranceEntity makeInsuranceEntity() {
        return new InsuranceEntity(
                1L,
                "Seguro Mais Cartao Protegido",
                new BigDecimal("150.0"),
                new BigDecimal("50000.0"),
                InsuranceTypeEntity.CARD,
                "Cobrimos perda, roubo e furto de cartão");
    }
}
