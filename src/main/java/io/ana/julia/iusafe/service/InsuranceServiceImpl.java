package io.ana.julia.iusafe.service;

import io.ana.julia.iusafe.data.dto.InsuranceDTO;
import io.ana.julia.iusafe.usecases.CreateInsuranceUseCase;
import io.ana.julia.iusafe.usecases.DeleteInsuranceUseCase;
import io.ana.julia.iusafe.usecases.FindAllInsuranceUseCase;
import io.ana.julia.iusafe.usecases.UpdateInsuranceUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    private final CreateInsuranceUseCase createInsuranceUseCase;
    private final UpdateInsuranceUseCase updateInsuranceUseCase;
    private final DeleteInsuranceUseCase deleteInsuranceUseCase;
    private final FindAllInsuranceUseCase findAllInsuranceUseCase;

    public InsuranceServiceImpl(CreateInsuranceUseCase createInsuranceUseCase, UpdateInsuranceUseCase updateInsuranceUseCase, DeleteInsuranceUseCase deleteInsuranceUseCase, FindAllInsuranceUseCase findAllInsuranceUseCase) {
        this.createInsuranceUseCase = createInsuranceUseCase;
        this.updateInsuranceUseCase = updateInsuranceUseCase;
        this.deleteInsuranceUseCase = deleteInsuranceUseCase;
        this.findAllInsuranceUseCase = findAllInsuranceUseCase;
    }

    @Override
    public InsuranceDTO createInsurance(InsuranceDTO insuranceDTO) {
        return createInsuranceUseCase.execute(insuranceDTO);
    }

    @Override
    public InsuranceDTO updateInsurance(InsuranceDTO insuranceDTO) {
        return updateInsuranceUseCase.execute(insuranceDTO);
    }

    @Override
    public void deleteInsurance(Long id) {
        deleteInsuranceUseCase.execute(id);
    }

    @Override
    public List<InsuranceDTO> findAllInsurances() {
        return findAllInsuranceUseCase.execute();
    }
}
