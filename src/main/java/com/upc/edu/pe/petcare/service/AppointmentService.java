package com.upc.edu.pe.petcare.service;


import com.upc.edu.pe.petcare.dto.response.AppointmentResponse;
import com.upc.edu.pe.petcare.model.Appointment;

public interface AppointmentService extends CrudService<Appointment, Long> {

    AppointmentResponse register(Long personProfile_id, Long pet_id,Long businessProfile_id,Long product_id,Long productType_id) throws Exception;

}
