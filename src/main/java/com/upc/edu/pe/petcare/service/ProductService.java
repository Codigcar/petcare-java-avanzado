package com.upc.edu.pe.petcare.service;


import com.upc.edu.pe.petcare.model.Product;
import com.upc.edu.pe.petcare.model.Provider;

public interface ProductService extends CrudService<Product, Long> {
    Product registerProduct(Product product, Long provider_id, Long product_type_id) throws Exception;
}
