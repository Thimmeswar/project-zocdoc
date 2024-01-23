package com.doctor.Controller;

import com.doctor.Playload.Doctordto;
import com.doctor.Service.DoctorService;
import com.doctor.Service.Imp.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    private DoctorService service;
//http://localhost:8080/api/doctor
    @PostMapping
    public ResponseEntity<Doctordto> savetheData(@RequestBody Doctordto dto){
        Doctordto doctordto = service.savetheData(dto);

        return new ResponseEntity<>(doctordto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Doctordto>>getDoctorsByNameOrSpecialization
            (@RequestParam String query)
             {
        List<Doctordto> list = service.getDoctorsByNameOrSpecialization(query);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
