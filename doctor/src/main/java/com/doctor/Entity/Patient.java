package com.doctor.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Transient;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "patients")
public class Patient {
    @Transient
    public static final String SEQUENCE_NAME ="user_sequence";

    @Id
    private long patientId;

    private String name;
    private String disease;
    private int age;



}
