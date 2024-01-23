package com.doctor.Respository;

import com.doctor.Entity.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AppointmentRepository extends MongoRepository<Appointment,Long> {
    List<Appointment> findByDoctorIdAndTimeSlot(long doctorId, String timeSlot);
}
