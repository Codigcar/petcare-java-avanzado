package com.upc.edu.pe.petcare.service.impl;

import com.upc.edu.pe.petcare.model.Provider;
import com.upc.edu.pe.petcare.repository.GenericRepository;
import com.upc.edu.pe.petcare.repository.ProviderRepository;
import com.upc.edu.pe.petcare.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl extends CrudServiceImpl<Provider, Long> implements ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    protected GenericRepository<Provider, Long> getRepository() {
        return providerRepository;
    }

    @Override
    public Provider findByBusinessProfileId(Long id) throws Exception {
        return providerRepository.getById(id);
    }
}
