package com.upc.edu.pe.petcare.repository;

import com.upc.edu.pe.petcare.model.Appointment;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface AppointmentRepository extends GenericRepository<Appointment, Long> {
    @Query("select a from Appointment a where a.personProfile.id = ?1 ")
    List<Appointment> getAppointmentsByPersonProfileId(Long PersonProfileId);

    @Query("select a from Appointment a where a.provider.businessProfile.id = ?1 ")
    List<Appointment> getAppointmentsByBusinessProfileId(Long bussinessProfileId);

    @Query("select a from Appointment a where  a.personProfile.id = ?1 and a.pet.id = ?2 and a.status=?3")
    List<Appointment> getAppointmentsByPersonProfileIdAndPetIdAndStatus(Long PersonProfileId, Long PetId, int status);

    @Query("select a from Appointment a where  a.personProfile.id = ?1 and a.status=?2")
    List<Appointment> getAppointmentsByPersonProfileIdAndStatus(Long PersonProfileId, int status);

    @Query("select a from Appointment a where   a.provider.businessProfile.id = ?1 and a.status=?2")
    List<Appointment> getAppointmentsByBusinessssProfileIdAndStatus(Long businessProfileId, int status);

    @Query("select a from Appointment a where a.mes = ?1 and a.provider.businessProfile.id = ?2")
    List<Appointment> getAppointmentsByMesByBusinessProfileId(String mes, Long businessProfileId);



}
