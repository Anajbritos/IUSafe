package io.ana.julia.iusafe.usecases;

import io.ana.julia.iusafe.data.InsuranceRepository;
import io.ana.julia.iusafe.data.dto.InsuranceDTO;
import io.ana.julia.iusafe.data.entity.InsuranceEntity;
import io.ana.julia.iusafe.data.mapper.InsuranceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeleteInsuranceUseCaseImpl implements DeleteInsuranceUseCase {

    private final InsuranceMapper insuranceMapper;
    private final InsuranceRepository insuranceRepository;

    @Autowired
    public DeleteInsuranceUseCaseImpl(InsuranceMapper insuranceMapper, InsuranceRepository insuranceRepository) {
        this.insuranceMapper = insuranceMapper;
        this.insuranceRepository = insuranceRepository;
    }

    public InsuranceDTO getInsuranceById(Long id) {
       Optional<InsuranceEntity> insurance = insuranceRepository.findById(id);
       if (insurance.isPresent()) {
           return insuranceMapper.toDTO(insurance.get());
       } else {
           throw new IllegalArgumentException("Seguro não encontrado!");
       }
    }

    @Override
    public void execute(Long id) {
        InsuranceDTO insurance = getInsuranceById(id);
        insuranceRepository.delete(insuranceMapper.toEntity(insurance));
    }
}
