package com.doctor.Service.Imp;

import com.doctor.Entity.Appointment;
import com.doctor.Playload.AppointmentDto;
import com.doctor.Respository.AppointmentRepository;
import com.doctor.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static com.doctor.Entity.Appointment.SEQUENCE_appointment;

@Service
public class AppointmentServiceImp implements AppointmentService {
    @Autowired
 private AppointmentRepository appointmentRepo;
    @Autowired
    private AppointsequenceGeneratorservice appointsequence;
    private static final List<String> AVAILABLE_TIME_SLOTS = Arrays.asList("11.30am", "12.30pm", "2.30pm");

    @Override
    public Appointment bookAppointment(long patientId, long doctorId, String timeSlot) {
        if (!AVAILABLE_TIME_SLOTS.contains(timeSlot)) {
            // You can customize the response or throw an exception as needed
            throw new RuntimeException("Invalid time slot selected.");
        }
        // Check if the time slot is available for the specified doctor
        if (!isTimeSlotAvailable(doctorId, timeSlot)) {
            // You can customize the response or throw an exception as needed
            throw new RuntimeException("The selected time slot is not available.");
        }
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(appointsequence.getSequenceNumber(SEQUENCE_appointment));
        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setTimeSlot(timeSlot);
        appointment.setBookingTime(LocalDateTime.now());
        Appointment save = appointmentRepo.save(appointment);
        return save;
    }
    private boolean isTimeSlotAvailable(long doctorId, String timeSlot) {
        // You may query the existing appointments for the doctor and check if the time slot is already booked
        List<Appointment> doctorAppointments = appointmentRepo.findByDoctorIdAndTimeSlot(doctorId, timeSlot);
        for (Appointment appointment : doctorAppointments) {
            LocalDateTime appointmentDateTime = LocalDateTime.parse(appointment.getTimeSlot(),
                    DateTimeFormatter.ofPattern("hh.mma"));
            // Check if the appointment is older than 24 hours
            if (appointment.getBookingTime().plusHours(24).isAfter(LocalDateTime.now())) {
                return false; // Time slot is not available
            }
        }

        return true;

    }
}
