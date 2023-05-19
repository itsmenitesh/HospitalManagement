package com.hospital.HospitalManagement.controller;

import com.hospital.HospitalManagement.module.Appointment;
import com.hospital.HospitalManagement.module.Doctor;
import com.hospital.HospitalManagement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    //add Doctor
    @PostMapping()
     public void addDoctor(@RequestBody Doctor doctor){
         doctorService.addDoctor(doctor);
    }



    //get Doctor all appointment
    @GetMapping("{doctorId}/appointments")
    ResponseEntity <List<Appointment>> getDoctorAppointment(@PathVariable Long doctorId){
        List<Appointment> myAppointment= null;
        HttpStatus status;

        try {
                myAppointment = doctorService.getMyAppointment(doctorId);
                System.out.println(myAppointment);
            if(myAppointment.isEmpty()){
                status = HttpStatus.NO_CONTENT;

            }else {
                status = HttpStatus.OK;
            }
        }
        catch (Exception e){
            System.out.println("The doctor Id is not valid");
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<List<Appointment>>(myAppointment ,status);
    }
}
