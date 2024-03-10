package io.ana.julia.iusafe.usecases;

import io.ana.julia.iusafe.data.InsuranceRepository;
import io.ana.julia.iusafe.data.dto.InsuranceDTO;
import io.ana.julia.iusafe.data.entity.InsuranceEntity;
import io.ana.julia.iusafe.data.mapper.InsuranceMapper;
import io.ana.julia.iusafe.usecases.UpdateInsuranceUseCaseImpl;
import io.ana.julia.iusafe.utils.AssertionsUtils;
import io.ana.julia.iusafe.utils.DataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UpdateInsuranceUseCaseTest {

    private InsuranceRepository insuranceRepository;
    private InsuranceMapper insuranceMapper;
    private UpdateInsuranceUseCaseImpl updateInsuranceUseCase;

    @BeforeEach
    void setup() {
        insuranceRepository = Mockito.mock(InsuranceRepository.class);
        insuranceMapper = Mockito.mock(InsuranceMapper.class);
        updateInsuranceUseCase = new UpdateInsuranceUseCaseImpl(insuranceRepository, insuranceMapper);
    }

    @Test
    public void testFindByIdSucess() {
        when(insuranceRepository.findById(any())).thenReturn(Optional.of(DataFactory.makeInsuranceEntity()));
        updateInsuranceUseCase.validateExistsInsuranceById(DataFactory.makeInsuranceEntity().getId());

        verify(insuranceRepository).findById(any());
    }

    @Test
    public void testFindByIdFailure() {
        when(insuranceRepository.findById(any())).thenReturn(Optional.empty());

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> updateInsuranceUseCase.validateExistsInsuranceById(
                        DataFactory.makeInsuranceEntity().getId()));
        verify(insuranceRepository).findById(any());
    }

    @Test
    public void testUpdateInsuranceOnSuccess() {
        when(insuranceRepository.findById(any())).thenReturn(Optional.of(DataFactory.makeInsuranceEntity()));
        when(insuranceRepository.save(any())).thenReturn(DataFactory.makeInsuranceEntity());
        when(insuranceMapper.toDTO(any())).thenReturn(DataFactory.makeInsuranceDTO());
        InsuranceDTO insuranceDTO = updateInsuranceUseCase.execute(DataFactory.makeInsuranceDTO());

        AssertionsUtils.assertInsurance(insuranceDTO,DataFactory.makeInsuranceDTO());

        verify(insuranceRepository).findById(any());
        verify(insuranceRepository).save(any());
        verify(insuranceMapper).toDTO(any());
    }

    @Test
    public void testUpdateInsuranceOnFailure() {
        when(insuranceRepository.findById(any())).thenReturn(Optional.empty());

        Assertions.assertThrows(IllegalArgumentException.class, () -> updateInsuranceUseCase.execute(DataFactory.makeInsuranceDTO()));

        verify(insuranceRepository).findById(any());
        verify(insuranceRepository, never()).save(any());
        verify(insuranceMapper, never()).toDTO(any());
    }

}
