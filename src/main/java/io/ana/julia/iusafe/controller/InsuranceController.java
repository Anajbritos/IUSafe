package io.ana.julia.iusafe.controller;

import io.ana.julia.iusafe.data.dto.InsuranceDTO;
import io.ana.julia.iusafe.service.InsuranceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    private final InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @PostMapping("/create")
    public ResponseEntity<InsuranceDTO> createInsurance(@RequestBody InsuranceDTO insuranceDTO) {
        return new ResponseEntity<>(insuranceService.createInsurance(insuranceDTO),
                HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<InsuranceDTO> updateInsurance(@RequestBody InsuranceDTO insuranceDTO) {
        return ResponseEntity.ok(insuranceService.updateInsurance(insuranceDTO));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> deleteInsurance(@PathVariable Long id) {
        insuranceService.deleteInsurance(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<InsuranceDTO>> findAllInsurances() {
        return ResponseEntity.ok(insuranceService.findAllInsurances());
    }
}
