package com.doctor.Controller;


import com.doctor.Playload.patientdto;
import com.doctor.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
   private PatientService service;
    @PostMapping
    //http://localhost:8081/api/patient/save
 public ResponseEntity<patientdto> savepatientdetails(@RequestBody patientdto dto){
        patientdto details = service.savepatientdetails(dto);
        return new ResponseEntity<>(details, HttpStatus.OK);
 }


}
