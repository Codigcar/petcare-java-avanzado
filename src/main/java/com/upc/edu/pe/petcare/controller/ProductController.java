package com.upc.edu.pe.petcare.controller;

import com.upc.edu.pe.petcare.dto.ProductRequest;
import com.upc.edu.pe.petcare.dto.response.ProductResponse;
import com.upc.edu.pe.petcare.model.Product;
import com.upc.edu.pe.petcare.service.ProductService;
import com.upc.edu.pe.petcare.util.ProductConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductConverter productConverter;

    @GetMapping()
    public ResponseEntity<List<ProductResponse>> getAll() throws Exception {
        List<Product> list = productService.getAll();
        return new ResponseEntity<>(productConverter.convertListEntityToDTO(list), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest modelRequest) throws Exception {
        Product newModel = productService
                .registerProduct(productConverter.convertDTOToEntity(modelRequest), modelRequest.provider_id, modelRequest.product_type_id);
        return new ResponseEntity<>(productConverter.convertEntityToDTO(newModel), HttpStatus.CREATED);
    }
    @GetMapping("/providerId/{providerId}/productTypeId/{productTypeId}")
    public ResponseEntity<List<ProductResponse>> getByProviderIdAndProductTypeId(@PathVariable("providerId") Long providerId, @PathVariable("productTypeId") Long productTypeId) throws Exception {
        List<Product> productList = productService.getProductByProviderIdAndProductTypeId(providerId, productTypeId);
        return new ResponseEntity<>(productConverter.convertListEntityToDTO(productList), HttpStatus.OK);
    }

}
