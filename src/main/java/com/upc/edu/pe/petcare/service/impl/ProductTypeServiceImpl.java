package com.upc.edu.pe.petcare.service.impl;

import com.upc.edu.pe.petcare.model.ProductType;
import com.upc.edu.pe.petcare.repository.GenericRepository;
import com.upc.edu.pe.petcare.repository.ProductTypeRepository;
import com.upc.edu.pe.petcare.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeServiceImpl extends CrudServiceImpl<ProductType, Long> implements ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    protected GenericRepository<ProductType, Long> getRepository() {
        return productTypeRepository;
    }


}
