package com.doctor.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection="appointment_sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentSequence {
    @Id
    private String id;
    private long seq;
}
