package com.upc.edu.pe.petcare.util;

import com.upc.edu.pe.petcare.dto.ProductRequest;
import com.upc.edu.pe.petcare.dto.ProviderJoinProductTypeRequest;
import com.upc.edu.pe.petcare.dto.response.ProductResponse;
import com.upc.edu.pe.petcare.dto.response.ProviderJoinProductTypeResponse;
import com.upc.edu.pe.petcare.model.Product;
import com.upc.edu.pe.petcare.model.ProviderJoinProduct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConverter {
    @Autowired
    private ModelMapper modelMapper;

    public Product convertDTOToEntity(ProductRequest request) {
        return modelMapper.map(request, Product.class);
    }

    public ProductResponse convertEntityToDTO(Product entity) {
        return modelMapper.map(entity, ProductResponse.class);
    }

    public List<ProductResponse> convertListEntityToDTO(List<Product> list) {
        return list.stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }


}
