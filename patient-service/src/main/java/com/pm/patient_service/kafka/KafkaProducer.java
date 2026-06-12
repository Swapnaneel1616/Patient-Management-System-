package com.pm.patient_service.kafka;

import com.pm.patient_service.module.Patient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Slf4j
@Service
public class KafkaProducer {

    private final KafkaTemplate<String , byte[]> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String , byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(Patient patient){
        PatientEvent event = PatientEvent.newBuilder()
                .setPatientId(patient.getId().toString())
                .setName(patient.getName())
                .setEmail(patient.getEmail())
                .setEventType("PATIENT_CREATED")
                .build();

        kafkaTemplate.send("patient", event.toByteArray())
                .whenComplete((result, ex) -> {
                    if (ex != null) {
                        log.error("Failed to send PatientCreated event to topic 'patient': {}", event, ex);
                    } else {
                        log.info("Sent PatientCreated event to topic 'patient': {}", event);
                    }
                });
    }


}
