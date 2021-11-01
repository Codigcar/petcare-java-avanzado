package com.upc.edu.pe.petcare.service.impl;

import com.upc.edu.pe.petcare.dto.AppointmentRequest;
import com.upc.edu.pe.petcare.dto.response.AppointmentResponse;
import com.upc.edu.pe.petcare.exception.ModelNotFoundException;
import com.upc.edu.pe.petcare.model.*;
import com.upc.edu.pe.petcare.repository.*;
import com.upc.edu.pe.petcare.service.AppointmentService;
import com.upc.edu.pe.petcare.service.ProductService;
import com.upc.edu.pe.petcare.util.AppointmentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl extends CrudServiceImpl<Appointment, Long> implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PersonProfileRepository personProfileRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private AppointmentConverter appointmentConverter;

    @Override
    protected GenericRepository<Appointment, Long> getRepository() {
        return appointmentRepository;
    }

    @Override
    public AppointmentResponse register(AppointmentRequest appointmentRequest) throws Exception {
       try {
           Appointment appointment = appointmentConverter.convertDTOToEntity(appointmentRequest);
           PersonProfile personProfileDB = personProfileRepository.findById(appointmentRequest.getPersonProfile_id()).orElseThrow(()->new ModelNotFoundException("personProfile no encontrado"));
           Pet petDB = petRepository.findById(appointmentRequest.getPet_id()).orElseThrow(()->new ModelNotFoundException("pet no encontrado"));
           Provider providerDB = providerRepository.findById(appointmentRequest.getProvider_id()).orElseThrow(()-> new ModelNotFoundException("provider no encontrado"));
           Product productDB = productRepository.findById(appointmentRequest.getProduct_id()).orElseThrow(()-> new ModelNotFoundException("product no encontrado"));
           ProductType productTypeDB = productTypeRepository.findById(appointmentRequest.getProductType_id()).orElseThrow(()-> new ModelNotFoundException("productType no encontrado"));

           appointment.setPersonProfile(personProfileDB);
           appointment.setPet(petDB);
           appointment.setProvider(providerDB);
           appointment.setProduct(productDB);
           appointment.setProductType(productTypeDB);

           return appointmentConverter.convertEntityToDTO(appointmentRepository.save(appointment));

       } catch ( Exception e ){
           throw new Exception("Error en el register appointment: "+ e);
       }


    }
}
