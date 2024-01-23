package com.doctor.Service.Imp;

import com.doctor.Entity.Doctor;
import com.doctor.Playload.Doctordto;
import com.doctor.Respository.DoctorRepository;
import com.doctor.Service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.doctor.Entity.Doctor.SEQUENCE_NAME;

@Service
public class DoctorServiceImp implements DoctorService {
    @Autowired
    private DoctorRepository dRepo;
    @Autowired
    private SequenceGeneratorService generatorService;
    @Autowired
 private ModelMapper modelMapper;

    @Override
    public Doctordto savetheData(Doctordto dto) {
        dto.setId(generatorService.getSequenceNumber(SEQUENCE_NAME));
        Doctor doctor = mapToDocument(dto);
        Doctor save = dRepo.save(doctor);
        Doctordto dto1 = mapTodto(save);
        return dto1;
    }

    @Override
    public  List<Doctordto> getDoctorsByNameOrSpecialization(String query) {
        List<Doctor> list = dRepo.findByNameIgnoreCaseContainingOrSpecializationIgnoreCaseContaining(query, query);
        List<Doctordto> collect = list.stream().map(c -> mapTodto(c)).collect(Collectors.toList());
        return collect;
    }

    Doctor mapToDocument(Doctordto dto ){
        Doctor map = modelMapper.map(dto, Doctor.class);
        return map;
    }
    Doctordto mapTodto(Doctor doctor){
        Doctordto map = modelMapper.map(doctor, Doctordto.class);
        return map;
    }
}
