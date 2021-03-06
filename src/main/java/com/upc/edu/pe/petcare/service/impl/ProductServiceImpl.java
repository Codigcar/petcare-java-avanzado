package com.upc.edu.pe.petcare.service.impl;

import com.upc.edu.pe.petcare.model.*;
import com.upc.edu.pe.petcare.repository.*;
import com.upc.edu.pe.petcare.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ProductServiceImpl extends CrudServiceImpl<Product, Long> implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    protected GenericRepository<Product, Long> getRepository() {
        return productRepository;
    }

    @Transactional
    @Override
    public Product registerProduct(Product product, Long provider_id, Long product_type_id) throws Exception {
       try {
           Provider providerDB = providerRepository.getById(provider_id);
           ProductType productType = productTypeRepository.getById(product_type_id);

           product.setProductType(productType);
           product.setProvider(providerDB);
           return productRepository.save(product);
       }catch ( Exception e ){
           throw new Exception("Error al registrar producto: "+ e.getMessage());
       }
    }

    @Override
    public List<Product> getProductByProviderIdAndProductTypeId(Long providerId, Long productTypeId) throws Exception {
        try {

            return productRepository.getProductByProviderIdAndProductTypeId(providerId, productTypeId);
        }
        catch ( Exception e ){
            throw new Exception("Error getProductByProviderIdAndProductTypeId: "+ e.getMessage());
        }
    }
}
