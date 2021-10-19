package com.upc.edu.pe.petcare.service.impl;

import com.upc.edu.pe.petcare.exception.ModelNotFoundException;
import com.upc.edu.pe.petcare.exception.ResponseExceptionHandler;
import com.upc.edu.pe.petcare.model.ProductType;
import com.upc.edu.pe.petcare.model.Provider;
import com.upc.edu.pe.petcare.model.ProviderJoinProductType;
import com.upc.edu.pe.petcare.repository.GenericRepository;
import com.upc.edu.pe.petcare.repository.ProductTypeRepository;
import com.upc.edu.pe.petcare.repository.ProviderJoinProductTypeRepository;
import com.upc.edu.pe.petcare.repository.ProviderRepository;
import com.upc.edu.pe.petcare.service.ProviderJoinProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProviderJoinProductTypeServiceImpl extends CrudServiceImpl<ProviderJoinProductType, Long> implements ProviderJoinProductTypeService {

    @Autowired
    private ProviderJoinProductTypeRepository providerJoinProductTypeRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    protected GenericRepository<ProviderJoinProductType, Long> getRepository() {
        return providerJoinProductTypeRepository;
    }


    @Override
    public ProviderJoinProductType registerByProviderIdAndProductTypeId(Long providerId, Long productTypeId) throws Exception {
        Optional<ProductType> productTypeBD = Optional.ofNullable(productTypeRepository.findById(productTypeId).orElseThrow(() -> new Exception("No existe el Id del ProductType")));
        Optional<Provider> providerDB = Optional.ofNullable(providerRepository.findById(providerId).orElseThrow(() -> new Exception("No existe Id del Provider")));


        ProviderJoinProductType providerJoinProductType = new ProviderJoinProductType();
        providerJoinProductType.setProductType(productTypeBD.get());
        providerJoinProductType.setProvider(providerDB.get());

        return providerJoinProductTypeRepository.save(providerJoinProductType);
    }
}
