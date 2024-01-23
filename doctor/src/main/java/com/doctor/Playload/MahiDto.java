package com.doctor.Playload;

import com.doctor.Entity.Doctor;
import com.doctor.Entity.Reviews;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MahiDto {
    private Doctor doctor1;
    private List<Reviews> reviews;
     private double ratingPercentage;
}
