package com.upc.edu.pe.petcare.controller;

import com.upc.edu.pe.petcare.dto.AppointmentRequest;
import com.upc.edu.pe.petcare.dto.response.AppointmentResponse;
import com.upc.edu.pe.petcare.exception.ModelNotFoundException;
import com.upc.edu.pe.petcare.model.Appointment;
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
        return new ResponseEntity<>(appointmentConverter.convertListEntityToDto(list), HttpStatus.OK);
    }

    @GetMapping("/personProfile/{id}")
    public ResponseEntity<List<AppointmentResponse>> getAllByPersonProfileId(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(appointmentService.getAllByPersonProfileId(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<AppointmentResponse> create(@Valid @RequestBody AppointmentRequest requestModel) throws Exception {
        AppointmentResponse newModel = appointmentService
                .register(requestModel);
        return new ResponseEntity<>(newModel, HttpStatus.CREATED);
    }

    /*
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception{
        Appointment obj = appointmentService.getById(id).orElseThrow(() -> new ModelNotFoundException("Appointment no encontrado"));
        if(obj == null) {
            throw new ModelNotFoundException("Id NO ENCONTRADO " + id);
        }
        appointmentService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    */
    @DeleteMapping("{id}/personProfile/{personProfileId}")
    public ResponseEntity<List<AppointmentResponse>> delete(@PathVariable("id") Long id, @PathVariable("personProfileId") Long personProfileId) throws Exception{
        Appointment obj = appointmentService.getById(id).orElseThrow(() -> new ModelNotFoundException("Appointment no encontrado"));
        return new ResponseEntity<>(appointmentService.deleteAppointments(id,personProfileId), HttpStatus.OK);

    }
}
