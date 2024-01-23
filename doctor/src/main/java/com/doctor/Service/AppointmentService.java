package com.doctor.Service;

import com.doctor.Entity.Appointment;
import com.doctor.Playload.AppointmentDto;

public interface AppointmentService {


    Appointment bookAppointment(long patientId, long doctorId, String timeSlot);
}
