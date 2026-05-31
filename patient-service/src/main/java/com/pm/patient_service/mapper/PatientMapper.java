package com.pm.patient_service.mapper;

import com.pm.patient_service.dto.PatientResponseDTO;
import com.pm.patient_service.module.Patient;

public class PatientMapper {

    public static PatientResponseDTO toDTO(Patient patient){
        PatientResponseDTO patientDTO = new PatientResponseDTO();
        patientDTO.setId(patient.getId().toString());
        patientDTO.setName(patient.getName());
        patientDTO.setAddress(patientDTO.getAddress());
        patientDTO.setEmail(patientDTO.getEmail());
        patientDTO.setDateOfBirth(patient.getDateOfBirth().toString());

        return patientDTO;
    }

}

