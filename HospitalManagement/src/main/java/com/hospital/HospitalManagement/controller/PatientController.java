package com.hospital.HospitalManagement.controller;

import com.hospital.HospitalManagement.dto.SignInInput;
import com.hospital.HospitalManagement.dto.SignInOutput;
import com.hospital.HospitalManagement.dto.SignUpInput;
import com.hospital.HospitalManagement.dto.SignUpOutput;
import com.hospital.HospitalManagement.module.AppointmentKey;
import com.hospital.HospitalManagement.module.Doctor;
import com.hospital.HospitalManagement.service.AuthenticationService;
import com.hospital.HospitalManagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @Autowired
    AuthenticationService authenticationService;


    //sign up
    @PostMapping("/signup")
    public SignUpOutput signUp(@RequestBody SignUpInput signUpDto){
        return patientService.singUp(signUpDto);
    }


    //SingIn
    @PostMapping("/signing")
    public SignInOutput signup(@RequestBody SignInInput signInInDto){
        return  patientService.signIn(signInInDto);
    }



    //see all doctor
    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctor(@RequestParam String userEmail , @RequestParam String token){

        HttpStatus status;
        List<Doctor> allDoctor = null;
        //user authentication first

        if(authenticationService.authenticate(userEmail , token)){

            allDoctor = patientService.getAllDoctor();
            status = HttpStatus.OK;
        }else{
            status = HttpStatus.FORBIDDEN;
        }

         return new ResponseEntity<List<Doctor>>(allDoctor , status);
    }


    //delete my appointment

    @DeleteMapping("appointment")
    ResponseEntity<Void> cancelAppointment(@RequestParam String userEmail, @RequestParam String token, @RequestBody AppointmentKey key)
    {

        HttpStatus status;
        if(authenticationService.authenticate(userEmail,token))
        {
            patientService.cancelAppointment(key);
            status = HttpStatus.OK;
        }
        else
        {
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<Void>(status);

    }

}
