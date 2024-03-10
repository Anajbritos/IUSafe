package io.ana.julia.iusafe.usecases;

import io.ana.julia.iusafe.data.InsuranceRepository;
import io.ana.julia.iusafe.data.dto.InsuranceDTO;
import io.ana.julia.iusafe.data.entity.InsuranceEntity;
import io.ana.julia.iusafe.data.mapper.InsuranceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateInsuranceUseCaseImpl implements UpdateInsuranceUseCase {
    InsuranceRepository insuranceRepository;
    InsuranceMapper insuranceMapper;

    @Autowired
    public UpdateInsuranceUseCaseImpl(InsuranceRepository insuranceRepository, InsuranceMapper insuranceMapper) {
        this.insuranceRepository = insuranceRepository;
        this.insuranceMapper = insuranceMapper;
    }

    public void validateExistsInsuranceById(Long id) {
        Optional<InsuranceEntity> insurance = insuranceRepository.findById(id);
        if (insurance.isEmpty()) {
            throw new IllegalArgumentException("Seguro não encontrado!");
        }
    }

    @Override
    public InsuranceDTO execute(InsuranceDTO insuranceDTO) {
        validateExistsInsuranceById(insuranceDTO.getId());
        InsuranceEntity insuranceEntity = insuranceRepository.save(insuranceMapper.toEntity(insuranceDTO));
        return insuranceMapper.toDTO(insuranceEntity);
    }
}
