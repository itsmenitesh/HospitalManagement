package com.hospital.HospitalManagement.service;

import com.hospital.HospitalManagement.module.Appointment;
import com.hospital.HospitalManagement.module.Doctor;
import com.hospital.HospitalManagement.repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    IDoctorRepository iDoctorRepository;

    //addDoctor
    public void addDoctor(Doctor doctor) {
          Doctor d =iDoctorRepository.save(doctor);
          if(d==null){
              throw new IllegalStateException("doctor data is null");
          }
    }

    //get all doctor for patient by patient service
    public List<Doctor> getAllDoctor() {
        List<Doctor> allDoctor = iDoctorRepository.findAll();
        return allDoctor;
    }

    public List<Appointment> getMyAppointment(Long doctorId) {
        Doctor myDoc = iDoctorRepository.findByDoctorId(doctorId);

        if(myDoc == null ){
            throw new IllegalStateException("The doctor does not exists");
        }else {
            return myDoc.getAppointments();
        }

    }
}
