package com.hospital.HospitalManagement.service;

import com.hospital.HospitalManagement.module.AppointmentKey;
import com.hospital.HospitalManagement.module.AuthenticationToken;
import com.hospital.HospitalManagement.module.Patient;
import com.hospital.HospitalManagement.repository.IAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired

    IAuthenticationRepository iAuthenticationRepository;

    public void saveToken(AuthenticationToken token){
        iAuthenticationRepository.save(token);
    }

    public AuthenticationToken getToken(Patient patient) {
        return iAuthenticationRepository.findByPatient(patient);
    }

    public boolean authenticate(String userEmail, String token) {
        AuthenticationToken authToken =  iAuthenticationRepository.findFirstByToken(token);
        String expectedEmail = authToken.getPatient().getPatientEmail();
        return  expectedEmail.equals(userEmail);
    }


}
