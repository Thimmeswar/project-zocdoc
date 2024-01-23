package com.doctor.Playload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reviewdto {
    @Id
    private long id;
    private long doctorId;
    private long patientId;
    private int Rating;

}
