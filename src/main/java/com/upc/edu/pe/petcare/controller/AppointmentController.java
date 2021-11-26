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

    @GetMapping("/businessProfile/{id}")
    public ResponseEntity<List<AppointmentResponse>> getAllByBusinessProfileId(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(appointmentService.getAppointmentsByBusinessProfileId(id), HttpStatus.OK);
    }

    @GetMapping("/personProfile/{personProfileId}/pet/{petId}/status/{status}")
    public ResponseEntity<List<AppointmentResponse>> getAllByPersonProfileIdAndPetId(@PathVariable("personProfileId") Long personProfileId, @PathVariable("petId") Long petId,@PathVariable("status") int status ) throws Exception {
        return new ResponseEntity<>(appointmentService.getAllByPersonProfileIdAndPetId(personProfileId,petId,status), HttpStatus.OK);
    }

    @GetMapping("/personProfile/{personProfileId}/status/{status}")
    public ResponseEntity<List<AppointmentResponse>> getAllByPersonProfileIdAndStatus(@PathVariable("personProfileId") Long personProfileId,@PathVariable("status") int status ) throws Exception {
        return new ResponseEntity<>(appointmentService.getAllByPersonProfileIdAndStatus(personProfileId,status), HttpStatus.OK);
    }

    @GetMapping("/businessProfile/{businessProfile}/status/{status}")
    public ResponseEntity<List<AppointmentResponse>> getAllByBusienssProfileIdAndStatus(@PathVariable("businessProfile") Long businessProfile,@PathVariable("status") int status ) throws Exception {
        return new ResponseEntity<>(appointmentService.getAppointmentsByBusinessProfileIdAndStatus(businessProfile,status), HttpStatus.OK);
    }

    @PutMapping("/appointment/{appointmentId}/status/{status}/personOrbusinesId/{personProfileId}/isPersonOrBusinessId/{isPersonOrBusinessId}") // 0: personProfile; 1:businessProfile
    public ResponseEntity<List<AppointmentResponse>> updateAllByPersonProfileIdAndStatus(@PathVariable("appointmentId") Long appointmentId,@PathVariable("status") int status,@PathVariable("personProfileId") Long personProfileId, @PathVariable("isPersonOrBusinessId") int isPersonOrBusinessId  ) throws Exception {
        List<AppointmentResponse> appointmentResponseDB = appointmentService.updateAppointmentByAppointmentIdAndStatus(appointmentId,status,personProfileId, isPersonOrBusinessId);
   //     return new ResponseEntity<>(appointmentService.getAppointmentsByBusinessProfileIdAndStatus(appointmentResponseDB.getProvider().getBusinessProfile().getId(),0), HttpStatus.OK);
        return new ResponseEntity<>(appointmentResponseDB, HttpStatus.OK);

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

    @GetMapping("/businessProfile/{businessProfileId}/byMes/{mes}")
    public ResponseEntity<List<Integer>> getAppointmentsByMes(@PathVariable("mes") String mes,@PathVariable("businessProfileId") Long businessProfileId ) throws Exception {
        return new ResponseEntity<>(appointmentService.getAppointmentsByMesByBusinessProfileId(mes,businessProfileId), HttpStatus.OK);
    }

    @GetMapping("/calculations123/businessProfile/{businessProfileId}")
    public ResponseEntity<List<Integer>> getCalculoConStatus1y2y3(@PathVariable("businessProfileId") Long businessProfileId ) throws Exception {
        return new ResponseEntity<>(appointmentService.getCalculoConStatus1y2y3(businessProfileId), HttpStatus.OK);
    }

}
