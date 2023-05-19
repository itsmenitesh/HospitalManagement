package com.hospital.HospitalManagement.repository;

import com.hospital.HospitalManagement.module.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor , Long> {

    Doctor findByDoctorId(Long doctorId);
}
