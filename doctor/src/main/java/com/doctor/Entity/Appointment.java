package com.doctor.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "appointments")
public class Appointment {
    @Transient
    public static final String SEQUENCE_appointment = "appointment_sequence";

    @Id
    private long appointmentId;
    private long patientId;
    private long doctorId;
    private String timeSlot;
    private LocalDateTime bookingTime;

}

