package com.hospital.HospitalManagement.repository;

import com.hospital.HospitalManagement.module.Appointment;
import com.hospital.HospitalManagement.module.AppointmentKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment , AppointmentKey> {
}
