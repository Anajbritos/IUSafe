package io.ana.julia.iusafe.usecases;

import io.ana.julia.iusafe.data.dto.InsuranceDTO;

public interface UpdateInsuranceUseCase {

    public InsuranceDTO execute(InsuranceDTO insuranceDTO);
}
