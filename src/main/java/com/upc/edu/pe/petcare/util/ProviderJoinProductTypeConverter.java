package com.upc.edu.pe.petcare.util;

import com.upc.edu.pe.petcare.dto.ProviderJoinProductRequest;
import com.upc.edu.pe.petcare.dto.response.ProviderJoinProductResponse;
import com.upc.edu.pe.petcare.model.ProviderJoinProduct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProviderJoinProductTypeConverter {
    @Autowired
    private ModelMapper modelMapper;

    public ProviderJoinProduct convertDTOToEntity(ProviderJoinProductRequest request) {
        return modelMapper.map(request, ProviderJoinProduct.class);
    }

    public ProviderJoinProductResponse convertEntityToDTO(ProviderJoinProduct entity) {
        return modelMapper.map(entity, ProviderJoinProductResponse.class);
    }

    public List<ProviderJoinProductResponse> convertListEntityToDTO(List<ProviderJoinProduct> list) {
        return list.stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }


}
