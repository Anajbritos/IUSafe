package io.ana.julia.iusafe.service;

import io.ana.julia.iusafe.data.dto.InsuranceDTO;

import java.util.List;

public interface InsuranceService {

    public InsuranceDTO createInsurance(InsuranceDTO insuranceDTO);

    public InsuranceDTO updateInsurance(InsuranceDTO insuranceDTO);

    public void deleteInsurance(Long id);

    public List<InsuranceDTO> findAllInsurances();
}
