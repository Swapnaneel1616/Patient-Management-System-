package com.pm.patient_service.controller;

import com.pm.patient_service.dto.PatientRequestDTO;
import com.pm.patient_service.dto.PatientResponseDTO;
import com.pm.patient_service.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;



    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getPatients(){
        return new ResponseEntity<>(patientService.getPatient(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> savePatient( @Valid @RequestBody PatientRequestDTO patientRequestDTO){
        return new ResponseEntity<>(patientService.createPatient(patientRequestDTO) , HttpStatus.CREATED);
    }
}
