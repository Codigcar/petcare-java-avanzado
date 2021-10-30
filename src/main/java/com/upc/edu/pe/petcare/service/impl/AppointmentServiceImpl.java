package com.upc.edu.pe.petcare.service.impl;

import com.upc.edu.pe.petcare.dto.response.AppointmentResponse;
import com.upc.edu.pe.petcare.model.Appointment;
import com.upc.edu.pe.petcare.model.Product;
import com.upc.edu.pe.petcare.repository.AppointmentRepository;
import com.upc.edu.pe.petcare.repository.GenericRepository;
import com.upc.edu.pe.petcare.repository.PersonProfileRepository;
import com.upc.edu.pe.petcare.repository.ProductRepository;
import com.upc.edu.pe.petcare.service.AppointmentService;
import com.upc.edu.pe.petcare.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl extends CrudServiceImpl<Appointment, Long> implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PersonProfileRepository personProfileRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    protected GenericRepository<Appointment, Long> getRepository() {
        return appointmentRepository;
    }



    @Override
    public AppointmentResponse register(Long personProfile_id, Long pet_id, Long businessProfile_id, Long product_id, Long productType_id) throws Exception {
        return null;
    }
}
