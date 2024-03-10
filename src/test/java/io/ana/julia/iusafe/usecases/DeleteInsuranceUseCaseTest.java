package io.ana.julia.iusafe.usecases;

import io.ana.julia.iusafe.data.InsuranceRepository;
import io.ana.julia.iusafe.data.dto.InsuranceDTO;
import io.ana.julia.iusafe.data.mapper.InsuranceMapper;
import io.ana.julia.iusafe.usecases.DeleteInsuranceUseCaseImpl;
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
public class DeleteInsuranceUseCaseTest {

    private InsuranceRepository insuranceRepository;
    private InsuranceMapper insuranceMapper;
    private DeleteInsuranceUseCaseImpl deleteInsuranceUseCase;

    @BeforeEach
    public void setup() {
        insuranceRepository = Mockito.mock(InsuranceRepository.class);
        insuranceMapper = Mockito.mock(InsuranceMapper.class);
        deleteInsuranceUseCase = new DeleteInsuranceUseCaseImpl(insuranceMapper, insuranceRepository);
    }

    @Test
    public void testDeleteByIdSucess() {
        when(insuranceRepository.findById(any())).thenReturn(Optional.of(DataFactory.makeInsuranceEntity()));
        when(insuranceMapper.toDTO(any())).thenReturn(DataFactory.makeInsuranceDTO());
        InsuranceDTO insuranceDTO = deleteInsuranceUseCase.getInsuranceById(any());

        Assertions.assertEquals(insuranceDTO.getId(), DataFactory.makeInsuranceDTO().getId());

        verify(insuranceRepository).findById(any());
        verify(insuranceMapper).toDTO(any());
    }

    @Test
    public void testDeleteByIdFailure() {
        when(insuranceRepository.findById(any())).thenReturn(Optional.empty());

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> deleteInsuranceUseCase.getInsuranceById(DataFactory.makeInsuranceDTO().getId()));

        verify(insuranceRepository).findById(any());
    }

    @Test
    public void testDeleteInsuranceOnSuccess() {
        when(insuranceRepository.findById(any())).thenReturn(Optional.of(DataFactory.makeInsuranceEntity()));
        doNothing().when(insuranceRepository).delete(any());

        deleteInsuranceUseCase.execute(DataFactory.makeInsuranceEntity().getId());

        verify(insuranceRepository).findById(any());
        verify(insuranceRepository).delete(any());
    }

    @Test
    public void testDeleteInsuranceOnFailure() {
        when(insuranceRepository.findById(any())).thenReturn(Optional.empty());

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> deleteInsuranceUseCase.execute(DataFactory.makeInsuranceDTO().getId()));

        verify(insuranceRepository).findById(any());
        verify(insuranceRepository, never()).delete(any());
    }
}
