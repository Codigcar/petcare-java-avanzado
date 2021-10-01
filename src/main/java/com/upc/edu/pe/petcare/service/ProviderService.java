package com.upc.edu.pe.petcare.service;

import com.upc.edu.pe.petcare.model.Provider;

import java.util.List;

public interface ProviderService extends CrudService<Provider, Long> {
    List<Provider> findByBusinessProfileId(Long id) throws Exception;
}
