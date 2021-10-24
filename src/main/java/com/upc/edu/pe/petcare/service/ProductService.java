package com.upc.edu.pe.petcare.service;


import com.upc.edu.pe.petcare.model.Product;

import java.util.List;

public interface ProductService extends CrudService<Product, Long> {
    Product registerProduct(Product product, Long provider_id, Long product_type_id) throws Exception;
    List<Product> getProductByProviderIdAndProductTypeId(Long providerId, Long productTypeId) throws Exception;

    //Product getProductByProviderId(Long providerId);
}
