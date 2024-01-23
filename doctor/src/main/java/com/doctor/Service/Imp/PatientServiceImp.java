package com.doctor.Service.Imp;


import com.doctor.Entity.Patient;
import com.doctor.Playload.patientdto;
import com.doctor.Respository.PatientRepository;
import com.doctor.Service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.doctor.Entity.Doctor.SEQUENCE_NAME;

@Service

public class PatientServiceImp implements PatientService {
    @Autowired
    private PatientRepository patientRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SequenceGeneratorService generatorService;


    @Override
    public patientdto savepatientdetails(patientdto dto) {

        Patient patient = mapToDocument(dto);
        Patient save = patientRepo.save(patient);
        patientdto patientdto = mapToDto(save);
        return patientdto;
    }
    Patient mapToDocument(patientdto dto){
        Patient map = modelMapper.map(dto, Patient.class);
        return map;
    }
    patientdto mapToDto(Patient patient){
        patientdto mapdto = modelMapper.map(patient, patientdto.class);
        return mapdto;
    }
}
