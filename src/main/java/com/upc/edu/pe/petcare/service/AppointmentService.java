package com.upc.edu.pe.petcare.service;


import com.upc.edu.pe.petcare.dto.AppointmentRequest;
import com.upc.edu.pe.petcare.dto.response.AppointmentResponse;
import com.upc.edu.pe.petcare.model.Appointment;

public interface AppointmentService extends CrudService<Appointment, Long> {

    AppointmentResponse register(AppointmentRequest appointmentRequest) throws Exception;

}
