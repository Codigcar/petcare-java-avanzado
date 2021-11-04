package com.upc.edu.pe.petcare.service;


import com.upc.edu.pe.petcare.dto.AppointmentRequest;
import com.upc.edu.pe.petcare.dto.response.AppointmentResponse;
import com.upc.edu.pe.petcare.model.Appointment;
import com.upc.edu.pe.petcare.repository.AppointmentRepository;

import java.util.List;

public interface AppointmentService extends CrudService<Appointment, Long> {

    AppointmentResponse register(AppointmentRequest appointmentRequest) throws Exception;
    List<AppointmentResponse> deleteAppointments(Long appointmentId,  Long personProfileId) throws Exception;
    List<AppointmentResponse> getAllByPersonProfileId(Long personProfileId) throws Exception;
}
