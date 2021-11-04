package com.upc.edu.pe.petcare.repository;

import com.upc.edu.pe.petcare.model.Appointment;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepository extends GenericRepository<Appointment, Long> {
    @Query("select a from Appointment a where a.personProfile.id = ?1 ")
    List<Appointment> getAppointmentsByPersonProfileId(Long PersonProfileId);
}
