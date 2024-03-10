package io.ana.julia.iusafe.controller;

import io.ana.julia.iusafe.data.dto.InsuranceDTO;
import io.ana.julia.iusafe.service.InsuranceService;
import io.ana.julia.iusafe.utils.AssertionsUtils;
import io.ana.julia.iusafe.utils.DataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InsuranceControllerTest {

    private InsuranceService insuranceService;
    private InsuranceController insuranceController;

    @BeforeEach
    public void setup (){
        insuranceService = Mockito.mock(InsuranceService.class);
        insuranceController = new InsuranceController(insuranceService);
    }

    @Test
    public void testCreateInsurance(){
        when(insuranceService.createInsurance(any())).thenReturn(DataFactory.makeInsuranceDTO());
        ResponseEntity<InsuranceDTO> insuranceResponse =
                insuranceController.createInsurance(DataFactory.makeInsuranceDTO());

        Assertions.assertNotNull(insuranceResponse);
        Assertions.assertNotNull(insuranceResponse.getBody());

        Assertions.assertEquals(insuranceResponse.getStatusCode(), HttpStatus.CREATED);
        AssertionsUtils.assertInsurance(insuranceResponse.getBody(), DataFactory.makeInsuranceDTO());
        Assertions.assertEquals(insuranceResponse.getBody().getClass(), InsuranceDTO.class);

        verify(insuranceService).createInsurance(any());
    }

    @Test
    public void testUpdateInsurance(){
        when(insuranceService.updateInsurance(any())).thenReturn(DataFactory.makeInsuranceDTO());
        ResponseEntity<InsuranceDTO> insuranceResponse =
                insuranceController.updateInsurance(DataFactory.makeInsuranceDTO());

        Assertions.assertNotNull(insuranceResponse);
        Assertions.assertNotNull(insuranceResponse.getBody());

        Assertions.assertEquals(insuranceResponse.getStatusCode(), HttpStatus.OK);
        AssertionsUtils.assertInsurance(insuranceResponse.getBody(), DataFactory.makeInsuranceDTO());
        Assertions.assertEquals(insuranceResponse.getBody().getClass(), InsuranceDTO.class);

        verify(insuranceService).updateInsurance(any());
    }

    @Test
    public void testDeleteInsurance(){
        doNothing().when(insuranceService).deleteInsurance(any());
        ResponseEntity<?> insuranceResponse =
                insuranceController.deleteInsurance(DataFactory.makeInsuranceDTO().getId());

        Assertions.assertNotNull(insuranceResponse);
        Assertions.assertNull(insuranceResponse.getBody());

        Assertions.assertEquals(insuranceResponse.getStatusCode(), HttpStatus.NO_CONTENT);

        verify(insuranceService).deleteInsurance(any());
    }

    @Test
    public void testFindAllInsurance() {
        when(insuranceService.findAllInsurances()).thenReturn(
                List.of(DataFactory.makeInsuranceDTO(),
                        DataFactory.makeInsuranceDTO()
                )
        );
        ResponseEntity<List<InsuranceDTO>> insuranceResponse =
                insuranceController.findAllInsurances();

        Assertions.assertNotNull(insuranceResponse);
        Assertions.assertNotNull(insuranceResponse.getBody());
        Assertions.assertTrue(insuranceResponse.getBody() instanceof List<InsuranceDTO>);
        Assertions.assertEquals(insuranceResponse.getBody().size(), 2);
        Assertions.assertEquals(insuranceResponse.getStatusCode(), HttpStatus.OK);
        AssertionsUtils.assertInsurance(insuranceResponse.getBody().get(0), DataFactory.makeInsuranceDTO());

        verify(insuranceService).findAllInsurances();
    }
}
