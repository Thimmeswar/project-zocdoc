package com.doctor.Playload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class patientdto {
    @Id
    private long patientId;
    private String name;
    private String disease;
    private int age;

}
