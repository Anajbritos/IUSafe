package io.ana.julia.iusafe.usecases;

import io.ana.julia.iusafe.data.dto.InsuranceDTO;

import java.util.List;

public interface FindAllInsuranceUseCase {

    public List<InsuranceDTO> execute();

}
