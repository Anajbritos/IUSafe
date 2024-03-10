package io.ana.julia.iusafe.usecases;

import io.ana.julia.iusafe.data.InsuranceRepository;
import io.ana.julia.iusafe.data.dto.InsuranceDTO;
import io.ana.julia.iusafe.data.entity.InsuranceEntity;
import io.ana.julia.iusafe.data.mapper.InsuranceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class FindAllInsuranceUseCaseImpl implements FindAllInsuranceUseCase {

    private final InsuranceRepository insuranceRepository;
    private final InsuranceMapper insuranceMapper;

    @Autowired
    public FindAllInsuranceUseCaseImpl(
            InsuranceRepository insuranceRepository,
            InsuranceMapper insuranceMapper) {
        this.insuranceRepository = insuranceRepository;
        this.insuranceMapper = insuranceMapper;
    }

    @Override
    public List<InsuranceDTO> execute() {
        return insuranceRepository
                .findAll()
                .stream()
                .map((Function<InsuranceEntity, InsuranceDTO>)
                        insuranceEntity -> insuranceMapper.toDTO(insuranceEntity))
                .collect(Collectors.toList());
    }
}
