package com.hospital.HospitalManagement.service;

import com.hospital.HospitalManagement.dto.SignInInput;
import com.hospital.HospitalManagement.dto.SignInOutput;
import com.hospital.HospitalManagement.dto.SignUpInput;
import com.hospital.HospitalManagement.dto.SignUpOutput;
import com.hospital.HospitalManagement.module.AppointmentKey;
import com.hospital.HospitalManagement.module.AuthenticationToken;
import com.hospital.HospitalManagement.module.Doctor;
import com.hospital.HospitalManagement.module.Patient;
import com.hospital.HospitalManagement.repository.IAuthenticationRepository;
import com.hospital.HospitalManagement.repository.IPatientRepository;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    IPatientRepository iPatientRepository;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    AppointmentService appointmentService;


                                  //singUp//
    public SignUpOutput singUp(SignUpInput signUpDto) {
        //1st. check if user already exists or not using user Email
        Patient patient = iPatientRepository.findFirstByPatientEmail(signUpDto.getUserEmail());
        if(patient != null) {
            throw new IllegalStateException("This UserEmail already Exists !!! .. Please try to Login");
        }


        //2nd. password encryption
        String encryptedPassword = null;
        try {
            encryptedPassword = encryptPassword(signUpDto.getUserPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        //3rd. save the user data

        patient = new Patient(signUpDto.getUserFirstName() , signUpDto.getUserLastName() , signUpDto.getUserEmail() , encryptedPassword , signUpDto.getUserContact());
        iPatientRepository.save(patient);

        //4th. Token create
        AuthenticationToken token = new AuthenticationToken(patient);
        authenticationService.saveToken(token);


        //5th. return singUpOutput
        return  new SignUpOutput("User registered" , "Account Created successfully");
    }


    //encryption method
    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5") ;
        md5.update(userPassword.getBytes());
        byte[] digested = md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);
        return hash;
    }
//___________________________________________________________________________________________________//

                                 //signIn//

    public SignInOutput signIn(SignInInput signInInDto) {
        //1st. check email exists
        Patient patient = iPatientRepository.findFirstByPatientEmail(signInInDto.getPatientEmail());

        if(patient == null) {
            throw new IllegalStateException("This User is not Exists !!! .. Please try to Create account or please signUp");
        }

        //2nd. encrypt the password
        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signInInDto.getPatientPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }


        //3rd. match it with database encrypted password

        boolean isPasswordValid = encryptedPassword.equals(patient.getPatientPassword());
        if(!isPasswordValid){
            throw new IllegalStateException("Incorrect Password !!! .. Please re-check");
        }

        //4th. figure out the token
        AuthenticationToken authToken = authenticationService.getToken(patient);

        //5th. set up output response

        return  new SignInOutput("Authentication successfully",authToken.getToken());
    }

    //get All Doctor
    public List<Doctor> getAllDoctor() {
        return doctorService.getAllDoctor();
    }


    //cancel appointment
    public void cancelAppointment(AppointmentKey key) {

        appointmentService.cancelAppointment(key);

    }
}
