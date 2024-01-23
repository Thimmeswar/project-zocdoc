package com.doctor.Controller;

import com.doctor.Entity.Appointment;
import com.doctor.Playload.AppointmentDto;
import com.doctor.Service.AppointmentService;
import com.doctor.Service.Imp.AppointsequenceGeneratorservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.doctor.Entity.Appointment.SEQUENCE_appointment;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentControl {
    @Autowired
    private AppointmentService service;
    @Autowired
    private AppointsequenceGeneratorservice appointsequence;
    @PostMapping
    public ResponseEntity<?> bookAppointment(@RequestBody AppointmentDto appointmentDTO) {
        appointmentDTO.setAppointmentId(appointsequence.getSequenceNumber(SEQUENCE_appointment));
        try {
            Appointment appointment = service.bookAppointment(

                    appointmentDTO.getPatientId(),
                    appointmentDTO.getDoctorId(),
                    appointmentDTO.getTimeSlot()


            );

            return new ResponseEntity<>(appointment, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
