package com.upc.edu.pe.petcare.util;

import com.upc.edu.pe.petcare.dto.AppointmentRequest;
import com.upc.edu.pe.petcare.dto.response.AppointmentResponse;
import com.upc.edu.pe.petcare.model.Appointment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppointmentConverter {

    @Autowired
    private ModelMapper modelMapper;

    public Appointment convertDTOToEntity(AppointmentRequest request) {
        return modelMapper.map(request, Appointment.class);
    }

    public AppointmentResponse convertEntityToDTO(Appointment entity) {
        return modelMapper.map(entity, AppointmentResponse.class);
    }

    public List<AppointmentResponse>  convertListEntityToDto(List<Appointment> list){
        return list.stream()
                .map(mapEntity -> convertEntityToDTO(mapEntity))
                .collect(Collectors.toList());
    }


}
