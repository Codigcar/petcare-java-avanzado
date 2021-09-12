package com.upc.edu.pe.petcare.service.impl;


import com.upc.edu.pe.petcare.model.PersonProfile;
import com.upc.edu.pe.petcare.repository.GenericRepository;
import com.upc.edu.pe.petcare.repository.PersonProfileRepository;
import com.upc.edu.pe.petcare.service.PersonProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonProfileServiceImpl extends CrudServiceImpl<PersonProfile, Long> implements PersonProfileService {

    @Autowired
    private PersonProfileRepository personProfileRepository;

    @Override
    protected GenericRepository<PersonProfile, Long> getRepository() {
        return personProfileRepository;
    }

}
