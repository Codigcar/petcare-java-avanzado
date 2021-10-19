package com.upc.edu.pe.petcare.util;

import com.upc.edu.pe.petcare.dto.PetRequest;
import com.upc.edu.pe.petcare.dto.ProductTypeRequest;
import com.upc.edu.pe.petcare.dto.response.PetResponse;
import com.upc.edu.pe.petcare.dto.response.ProductTypeResponse;
import com.upc.edu.pe.petcare.model.ProductType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductTypeConverter {
    @Autowired
    private ModelMapper modelMapper;

    public ProductType convertDTOToEntity(ProductTypeRequest request) {
        return modelMapper.map(request, ProductType.class);
    }

    public ProductTypeResponse convertEntityToDTO(ProductType entity) {
        return modelMapper.map(entity, ProductTypeResponse.class);
    }

    public List<ProductTypeResponse> convertListEntityToDTO(List<ProductType> list) {
        return list.stream().map(mapEntity -> convertEntityToDTO(mapEntity)).collect(Collectors.toList());
    }


}
