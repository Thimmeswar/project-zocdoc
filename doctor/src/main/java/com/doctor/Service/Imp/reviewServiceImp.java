package com.doctor.Service.Imp;

import com.doctor.Entity.Doctor;
import com.doctor.Entity.Patient;
import com.doctor.Entity.Reviews;
import com.doctor.Playload.MahiDto;
import com.doctor.Playload.Reviewdto;
import com.doctor.Respository.DoctorRepository;
import com.doctor.Respository.PatientRepository;
import com.doctor.Respository.ReviewRepository;
import com.doctor.Service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.doctor.Entity.Doctor.SEQUENCE_NAME;

@Service
public class reviewServiceImp implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepo;
    @Autowired
    private DoctorRepository doctorRepo;
    @Autowired
    private PatientRepository patientRepo;
    @Autowired
    private SequenceGeneratorService generatorService;
    @Autowired
    private ModelMapper modelMapper;



    @Override
    public List<Reviewdto>getfindByDoctorId(long doctorId) {
        List<Reviews> reviews = reviewRepo.findByDoctorId(doctorId);
        List<Reviewdto> list = reviews.stream().map(c -> mapToDto(c)).collect(Collectors.toList());
        return list ;

    }

    @Override
    public Reviewdto saveTheReviews(Reviewdto dto) {
        Optional<Doctor> optionalDoctor = doctorRepo.findById(dto.getDoctorId());
        Optional<Patient> optionalPatient = patientRepo.findById(dto.getPatientId());
        Doctor doctor = optionalDoctor.orElse(null);
        Patient patient = optionalPatient.orElse(null);

        if(doctor!=null || patient!=null){
            Reviews reviews = mapToDocument(dto);
            Reviews save = reviewRepo.save(reviews);
            Reviewdto reviewdto = mapToDto(save);
            return reviewdto;
        }
        return null;
    }

    @Override
    public MahiDto GetallReviews(long doctorId) {
        Doctor doctor = doctorRepo.findById(doctorId).get();
        List<Reviews> reviews = reviewRepo.findByDoctorId(doctorId);
        double totalRating=0;
        for (Reviews review :reviews) {
            totalRating+=review.getRating();
        }
        double averageRating=totalRating/ reviews.size();
        double ratingPercentage= (averageRating/5.0)*100.0;
        MahiDto dto1 = new MahiDto();
        dto1.setReviews(reviews);
        dto1.setDoctor1(doctor);
        dto1.setRatingPercentage(ratingPercentage);


        return dto1;
    }

    Reviews mapToDocument(Reviewdto dto){
        Reviews map = modelMapper.map(dto, Reviews.class);
        return map;
    }
    Reviewdto mapToDto(Reviews review){
        Reviewdto mapdto = modelMapper.map(review, Reviewdto.class);
        return mapdto;
    }

}

