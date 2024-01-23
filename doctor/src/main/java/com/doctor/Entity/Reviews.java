package com.doctor.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Reviews {
    @Id

    private long id;
    private long doctorId;
    private long patientId;
    private int rating;

}