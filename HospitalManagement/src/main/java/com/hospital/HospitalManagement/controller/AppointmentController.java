package com.hospital.HospitalManagement.controller;

import com.hospital.HospitalManagement.module.Appointment;
import com.hospital.HospitalManagement.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping()
    void bookAppointment(@RequestBody Appointment appointment){
        appointmentService.bookAppoinment(appointment);
    }

}
