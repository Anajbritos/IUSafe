package io.ana.julia.iusafe.usecases;

import io.ana.julia.iusafe.data.InsuranceRepository;
import io.ana.julia.iusafe.data.dto.InsuranceDTO;
import io.ana.julia.iusafe.data.mapper.InsuranceMapper;
import io.ana.julia.iusafe.usecases.FindAllInsuranceUseCaseImpl;
import io.ana.julia.iusafe.utils.AssertionsUtils;
import io.ana.julia.iusafe.utils.DataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindAllInsuranceUseCaseTest {

    private InsuranceRepository insuranceRepository;
    private InsuranceMapper insuranceMapper;
    private FindAllInsuranceUseCaseImpl findAllInsuranceUseCase;

    @BeforeEach
    void setup(){
        insuranceRepository = Mockito.mock(InsuranceRepository.class);
        insuranceMapper = Mockito.mock(InsuranceMapper.class);
        findAllInsuranceUseCase = new FindAllInsuranceUseCaseImpl(insuranceRepository, insuranceMapper);
    }

    @Test
    public void testFindAllInsurances() {
        when(insuranceRepository.findAll()).thenReturn(
                List.of(DataFactory.makeInsuranceEntity(),
                        DataFactory.makeInsuranceEntity()
                )
        );
        when(insuranceMapper.toDTO(any())).thenReturn(DataFactory.makeInsuranceDTO());

        List<InsuranceDTO> insuranceDTOS = findAllInsuranceUseCase.execute();

        Assertions.assertEquals(insuranceDTOS.size(), 2);
        InsuranceDTO insuranceDTOFirst = insuranceDTOS.get(0);
        AssertionsUtils.assertInsurance(insuranceDTOFirst,DataFactory.makeInsuranceDTO());

        verify(insuranceRepository).findAll();
        verify(insuranceMapper, times(2)).toDTO(any());
    }

    @Test
    public void testFindAllInsuranceEmpty() {
        when(insuranceRepository.findAll()).thenReturn(
                List.of()
        );

        List<InsuranceDTO> insuranceDTOS = findAllInsuranceUseCase.execute();

        Assertions.assertEquals(insuranceDTOS.size(), 0);

        verify(insuranceRepository).findAll();
        verify(insuranceMapper, never()).toDTO(any());
    }
}
