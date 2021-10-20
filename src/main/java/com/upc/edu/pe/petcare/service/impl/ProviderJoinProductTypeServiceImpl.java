package com.upc.edu.pe.petcare.service.impl;

import com.upc.edu.pe.petcare.model.Product;
import com.upc.edu.pe.petcare.model.ProductType;
import com.upc.edu.pe.petcare.model.Provider;
import com.upc.edu.pe.petcare.model.ProviderJoinProduct;
import com.upc.edu.pe.petcare.repository.*;
import com.upc.edu.pe.petcare.service.ProviderJoinProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProviderJoinProductTypeServiceImpl extends CrudServiceImpl<ProviderJoinProduct, Long> implements ProviderJoinProductTypeService {

    @Autowired
    private ProviderJoinProductRepository providerJoinProductTypeRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    protected GenericRepository<ProviderJoinProduct, Long> getRepository() {
        return providerJoinProductTypeRepository;
    }


    @Override
    public ProviderJoinProduct registerByProviderIdAndProductTypeId(Long providerId, Long productTypeId) throws Exception {
        Optional<Product> productTypeBD = Optional.ofNullable(productRepository.findById(productTypeId).orElseThrow(() -> new Exception("No existe el Id del ProductType")));
        Optional<Provider> providerDB = Optional.ofNullable(providerRepository.findById(providerId).orElseThrow(() -> new Exception("No existe Id del Provider")));


        ProviderJoinProduct providerJoinProductType = new ProviderJoinProduct();
        providerJoinProductType.setProduct(productTypeBD.get());
        providerJoinProductType.setProvider(providerDB.get());

        return providerJoinProductTypeRepository.save(providerJoinProductType);
    }
}
