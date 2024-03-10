package io.ana.julia.iusafe.utils;

import io.ana.julia.iusafe.data.dto.InsuranceDTO;
import org.junit.jupiter.api.Assertions;

public class AssertionsUtils {

    public static void assertInsurance(InsuranceDTO first, InsuranceDTO last) {
        Assertions.assertEquals(first.getId(), last.getId());
        Assertions.assertEquals(first.getValue(), last.getValue());
        Assertions.assertEquals(first.getDescription(), last.getDescription());
        Assertions.assertEquals(first.getInsuranceTypeDTO(), last.getInsuranceTypeDTO());
        Assertions.assertEquals(first.getCoverageDescription(), last.getCoverageDescription());
        Assertions.assertEquals(first.getCoverageValue(), last.getCoverageValue());

    }
}
