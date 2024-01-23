package com.doctor.Entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Transient;

@Document(collection = "doctors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Transient
    public static final String SEQUENCE_NAME ="user_sequence";
    @Id
    private long id;
    private String name;
    private String qualification;
    private String specialization;
    private int experience;
    private String description;

}

