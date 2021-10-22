package com.upc.edu.pe.petcare.controller;

import com.upc.edu.pe.petcare.dto.AppointmentRequest;
import com.upc.edu.pe.petcare.dto.ProductRequest;
import com.upc.edu.pe.petcare.dto.response.AppointmentResponse;
import com.upc.edu.pe.petcare.dto.response.ProductResponse;
import com.upc.edu.pe.petcare.model.Appointment;
import com.upc.edu.pe.petcare.model.Product;
import com.upc.edu.pe.petcare.service.AppointmentService;
import com.upc.edu.pe.petcare.util.AppointmentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentConverter appointmentConverter;

    @GetMapping()
    public ResponseEntity<List<AppointmentResponse>> getAll() throws Exception {
        List<Appointment> list = appointmentService.getAll();
        return new ResponseEntity<>(appointmentConverter.convertListEntityToDTO(list), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<AppointmentResponse> create(@Valid @RequestBody AppointmentRequest requestModel) throws Exception {
        Appointment newModel = appointmentService
                .create(appointmentConverter.convertDTOToEntity(requestModel));
        return new ResponseEntity<>(appointmentConverter.convertEntityToDTO(newModel), HttpStatus.CREATED);
    }
}
