package io.ana.julia.iusafe.usecases;

import io.ana.julia.iusafe.data.dto.InsuranceDTO;

public interface CreateInsuranceUseCase {

    public InsuranceDTO execute(InsuranceDTO insuranceDTO);
}
