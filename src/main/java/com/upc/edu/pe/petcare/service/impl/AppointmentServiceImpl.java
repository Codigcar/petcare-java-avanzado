package com.upc.edu.pe.petcare.service.impl;

import com.upc.edu.pe.petcare.model.Appointment;
import com.upc.edu.pe.petcare.model.Product;
import com.upc.edu.pe.petcare.repository.AppointmentRepository;
import com.upc.edu.pe.petcare.repository.GenericRepository;
import com.upc.edu.pe.petcare.repository.ProductRepository;
import com.upc.edu.pe.petcare.service.AppointmentService;
import com.upc.edu.pe.petcare.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl extends CrudServiceImpl<Appointment, Long> implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    protected GenericRepository<Appointment, Long> getRepository() {
        return appointmentRepository;
    }
}
