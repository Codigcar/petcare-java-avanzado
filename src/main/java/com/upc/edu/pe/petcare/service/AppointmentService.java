package com.upc.edu.pe.petcare.service;


import com.upc.edu.pe.petcare.dto.AppointmentRequest;
import com.upc.edu.pe.petcare.dto.response.AppointmentResponse;
import com.upc.edu.pe.petcare.model.Appointment;

import java.util.List;

public interface AppointmentService extends CrudService<Appointment, Long> {

    AppointmentResponse register(AppointmentRequest appointmentRequest) throws Exception;
    List<AppointmentResponse> deleteAppointments(Long appointmentId,  Long personProfileId) throws Exception;
    List<AppointmentResponse> getAllByPersonProfileId(Long personProfileId) throws Exception;
    List<AppointmentResponse> getAllByPersonProfileIdAndPetId(Long personProfileId,Long petId, int status) throws Exception;
    List<AppointmentResponse> getAllByPersonProfileIdAndStatus(Long personProfileId, int status) throws Exception;

    List<AppointmentResponse> updateAppointmentByAppointmentIdAndStatus(Long appointmentId, int status, Long bussinessProfileId, int isPersonOrBusinessId) throws  Exception;

    List<AppointmentResponse> getAppointmentsByBusinessProfileId(Long bussinessProfileId) throws  Exception;

    List<AppointmentResponse> getAppointmentsByBusinessProfileIdAndStatus(Long businessProfileId, int status)throws  Exception;

    List<Integer> getAppointmentsByMesByBusinessProfileId(String mes, Long businessProfileId)throws  Exception;

    List<Integer> getCalculoConStatus1y2y3(Long businessProfileId) throws  Exception;


}
