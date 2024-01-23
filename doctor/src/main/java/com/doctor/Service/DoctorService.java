package com.doctor.Service;

import com.doctor.Playload.Doctordto;

import java.util.List;

public interface DoctorService {
    Doctordto savetheData(Doctordto dto);

    List<Doctordto> getDoctorsByNameOrSpecialization(String query);
}
