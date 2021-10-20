package com.upc.edu.pe.petcare.service.impl;

import com.upc.edu.pe.petcare.model.Pet;
import com.upc.edu.pe.petcare.model.Product;
import com.upc.edu.pe.petcare.repository.GenericRepository;
import com.upc.edu.pe.petcare.repository.PetRepository;
import com.upc.edu.pe.petcare.repository.ProductRepository;
import com.upc.edu.pe.petcare.service.PetService;
import com.upc.edu.pe.petcare.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends CrudServiceImpl<Product, Long> implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    protected GenericRepository<Product, Long> getRepository() {
        return productRepository;
    }
}
