package com.hospital.HospitalManagement.repository;

import com.hospital.HospitalManagement.module.AuthenticationToken;
import com.hospital.HospitalManagement.module.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepository extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findByPatient(Patient patient);

    AuthenticationToken findFirstByToken(String token);
}
