package com.upc.edu.pe.petcare.service.impl;

import com.upc.edu.pe.petcare.model.Pet;
import com.upc.edu.pe.petcare.model.Product;
import com.upc.edu.pe.petcare.model.Provider;
import com.upc.edu.pe.petcare.model.ProviderJoinProduct;
import com.upc.edu.pe.petcare.repository.*;
import com.upc.edu.pe.petcare.service.PetService;
import com.upc.edu.pe.petcare.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl extends CrudServiceImpl<Product, Long> implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private ProviderJoinProductRepository providerJoinProductRepository;
    @Override
    protected GenericRepository<Product, Long> getRepository() {
        return productRepository;
    }

    @Override
    public Product registerProduct(Product product, Long provider_id) throws Exception {
       try {
           Provider providerDB = providerRepository.getById(provider_id);
           Product productDB = productRepository.save(product);

           ProviderJoinProduct providerJoinProductNew = new ProviderJoinProduct();
           providerJoinProductNew.setProduct(productDB);
           providerJoinProductNew.setProvider(providerDB);
           providerJoinProductRepository.save(providerJoinProductNew);

           return productDB;
       }catch ( Exception e ){
           throw new Exception("Error al registrar producto: "+ e);
       }
    }
}
