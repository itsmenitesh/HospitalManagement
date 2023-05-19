package com.hospital.HospitalManagement.service;

import com.hospital.HospitalManagement.module.Appointment;
import com.hospital.HospitalManagement.module.AppointmentKey;
import com.hospital.HospitalManagement.repository.IAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    @Autowired
    IAppointmentRepository iAppointmentRepository;

    public void bookAppoinment(Appointment appointment) {
        iAppointmentRepository.save(appointment);
    }


    // cancel Appointment
    public void cancelAppointment(AppointmentKey key) {
        iAppointmentRepository.deleteById(key);
    }
}
