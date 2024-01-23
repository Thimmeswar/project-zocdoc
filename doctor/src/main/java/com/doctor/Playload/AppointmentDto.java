package com.doctor.Playload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    @Transient
    public static final String SEQUENCE_NAME = "appointment_sequence";

    @Id
    private long appointmentId;
    private long patientId;
    private long doctorId;
    private String timeSlot;
    private LocalDateTime bookingTime;

}
