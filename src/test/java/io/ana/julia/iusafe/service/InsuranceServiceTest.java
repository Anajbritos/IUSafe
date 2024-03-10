package io.ana.julia.iusafe.service;

import io.ana.julia.iusafe.data.dto.InsuranceDTO;
import io.ana.julia.iusafe.usecases.CreateInsuranceUseCase;
import io.ana.julia.iusafe.usecases.DeleteInsuranceUseCase;
import io.ana.julia.iusafe.usecases.FindAllInsuranceUseCase;
import io.ana.julia.iusafe.usecases.UpdateInsuranceUseCase;
import io.ana.julia.iusafe.utils.AssertionsUtils;
import io.ana.julia.iusafe.utils.DataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class InsuranceServiceTest {

    private CreateInsuranceUseCase createInsuranceUseCase;
    private UpdateInsuranceUseCase updateInsuranceUseCase;
    private DeleteInsuranceUseCase deleteInsuranceUseCase;
    private FindAllInsuranceUseCase findAllInsuranceUseCase;
    private InsuranceServiceImpl insuranceService;

    @BeforeEach
    void setup() {
        createInsuranceUseCase = Mockito.mock(CreateInsuranceUseCase.class);
        updateInsuranceUseCase = Mockito.mock(UpdateInsuranceUseCase.class);
        deleteInsuranceUseCase = Mockito.mock(DeleteInsuranceUseCase.class);
        findAllInsuranceUseCase = Mockito.mock(FindAllInsuranceUseCase.class);
        insuranceService = new InsuranceServiceImpl(
                createInsuranceUseCase,
                updateInsuranceUseCase,
                deleteInsuranceUseCase,
                findAllInsuranceUseCase
        );
    }

    @Test
    public void testCreateInsurance() {
        when(createInsuranceUseCase.execute(any())).thenReturn(DataFactory.makeInsuranceDTO());
        InsuranceDTO insuranceDTO = insuranceService.createInsurance(DataFactory.makeInsuranceDTO());

        AssertionsUtils.assertInsurance(insuranceDTO,DataFactory.makeInsuranceDTO());

        verify(createInsuranceUseCase).execute(any());
    }

    @Test
    public void testUpdateInsurance() {
        when(updateInsuranceUseCase.execute(any())).thenReturn(DataFactory.makeInsuranceDTO());
        InsuranceDTO insuranceDTO = insuranceService.updateInsurance(DataFactory.makeInsuranceDTO());

        AssertionsUtils.assertInsurance(insuranceDTO,DataFactory.makeInsuranceDTO());

        verify(updateInsuranceUseCase).execute(any());
    }

    @Test
    public void testDeleteInsuranceUseCase() {
        doNothing().when(deleteInsuranceUseCase).execute(any());

        insuranceService.deleteInsurance(DataFactory.makeInsuranceDTO().getId());

        verify(deleteInsuranceUseCase).execute(any());
    }

    @Test
    public void testFindAllInsuranceUseCase() {
        when(findAllInsuranceUseCase.execute()).thenReturn(
                List.of(
                        DataFactory.makeInsuranceDTO(),
                        DataFactory.makeInsuranceDTO()
                )
        );
        List<InsuranceDTO> insuranceDTO = insuranceService.findAllInsurances();
        InsuranceDTO insuranceDTOFirst = insuranceDTO.get(0);


        verify(findAllInsuranceUseCase).execute();
    }
}
