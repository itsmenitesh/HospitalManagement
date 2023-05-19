package com.hospital.HospitalManagement.repository;

import com.hospital.HospitalManagement.module.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient ,Long> {

    Patient findFirstByPatientEmail(String userEmail);

}
