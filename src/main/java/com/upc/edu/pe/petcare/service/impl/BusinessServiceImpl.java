package com.upc.edu.pe.petcare.service.impl;


import com.upc.edu.pe.petcare.model.BusinessProfile;
import com.upc.edu.pe.petcare.repository.BusinessProfileRepository;
import com.upc.edu.pe.petcare.repository.GenericRepository;
import com.upc.edu.pe.petcare.service.BusinessProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl extends CrudServiceImpl<BusinessProfile, Long> implements BusinessProfileService {

    @Autowired
    private BusinessProfileRepository businessProfileRepository;

    @Override
    protected GenericRepository<BusinessProfile, Long> getRepository() {
        return businessProfileRepository;
    }

}
