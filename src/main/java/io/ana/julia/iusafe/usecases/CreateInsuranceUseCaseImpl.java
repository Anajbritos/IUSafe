package io.ana.julia.iusafe.usecases;

import io.ana.julia.iusafe.data.InsuranceRepository;
import io.ana.julia.iusafe.data.dto.InsuranceDTO;
import io.ana.julia.iusafe.data.entity.InsuranceEntity;
import io.ana.julia.iusafe.data.mapper.InsuranceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateInsuranceUseCaseImpl implements CreateInsuranceUseCase {

    private final InsuranceRepository insuranceRepository;
    private final InsuranceMapper insuranceMapper;

    @Autowired
    public CreateInsuranceUseCaseImpl(InsuranceRepository insuranceRepository, InsuranceMapper insuranceMapper) {
        this.insuranceRepository = insuranceRepository;
        this.insuranceMapper = insuranceMapper;
    }
    @Override
    public InsuranceDTO execute(InsuranceDTO insuranceDTO) {
       InsuranceEntity insuranceEntity = insuranceRepository.save(insuranceMapper.toEntity(insuranceDTO));
       return insuranceMapper.toDTO(insuranceEntity);
    }
}
