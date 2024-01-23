package com.doctor.Controller;

import com.doctor.Entity.Doctor;
import com.doctor.Entity.Reviews;
import com.doctor.Playload.MahiDto;
import com.doctor.Playload.Reviewdto;
import com.doctor.Service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ReviewService service;
    //http://localhost:8080/api/review
    @PostMapping
     public ResponseEntity<Reviewdto>saveTheReviews(@RequestBody Reviewdto dto){
        Reviewdto reviewdto = service.saveTheReviews(dto);
        return new ResponseEntity<>(reviewdto,HttpStatus.OK);
    }
    //http://localhost:8080/api/review/1
    @GetMapping
    public ResponseEntity<List<Reviewdto>>getfindByDoctorId(@RequestParam long doctorId){
        List<Reviewdto> list = service.getfindByDoctorId(doctorId);

        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    Reviewdto mapToDto(Reviews review){
        Reviewdto mapdto = modelMapper.map(review, Reviewdto.class);
        return mapdto;
    }
    @GetMapping("/mahi")
    public ResponseEntity<MahiDto>GetallReviews(@RequestParam long doctorId){
        MahiDto mahiDto = service.GetallReviews(doctorId);
        return new ResponseEntity<>(mahiDto,HttpStatus.OK);

    }
}
