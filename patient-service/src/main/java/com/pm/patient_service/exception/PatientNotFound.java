package com.pm.patient_service.exception;

public class PatientNotFound extends RuntimeException {
    public PatientNotFound(String message) {
        super(message);
    }
}
