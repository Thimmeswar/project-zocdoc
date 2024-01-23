package com.doctor.Playload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctordto {
    @Id
    private long id;
    private String name;
    private String qualification;
    private String specialization;
    private int experience;
    private String description;
}
