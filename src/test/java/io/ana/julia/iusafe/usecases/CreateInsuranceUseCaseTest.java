package io.ana.julia.iusafe.usecases;

import io.ana.julia.iusafe.data.InsuranceRepository;
import io.ana.julia.iusafe.data.dto.InsuranceDTO;
import io.ana.julia.iusafe.data.mapper.InsuranceMapper;
import io.ana.julia.iusafe.usecases.CreateInsuranceUseCaseImpl;
import io.ana.julia.iusafe.utils.AssertionsUtils;
import io.ana.julia.iusafe.utils.DataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateInsuranceUseCaseTest {
    private InsuranceRepository insuranceRepository;
    private InsuranceMapper insuranceMapper;
    private CreateInsuranceUseCaseImpl createInsuranceUseCase;

    @BeforeEach
    void setup() {
        insuranceRepository = Mockito.mock(InsuranceRepository.class);
        insuranceMapper = Mockito.mock(InsuranceMapper.class);
        createInsuranceUseCase = new CreateInsuranceUseCaseImpl(insuranceRepository, insuranceMapper);
    }

    @Test
    public void testCreateInsuranceOnSuccess() {
        when(insuranceRepository.save(any())).thenReturn(DataFactory.makeInsuranceEntity());
        when(insuranceMapper.toDTO(any())).thenReturn(DataFactory.makeInsuranceDTO());
        InsuranceDTO insuranceDTO = createInsuranceUseCase.execute(DataFactory.makeInsuranceDTO());

        AssertionsUtils.assertInsurance(insuranceDTO,DataFactory.makeInsuranceDTO());

        verify(insuranceRepository).save(any());
        verify(insuranceMapper).toDTO(any());
    }
}
