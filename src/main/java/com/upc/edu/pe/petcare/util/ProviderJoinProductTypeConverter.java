package com.upc.edu.pe.petcare.util;

import com.upc.edu.pe.petcare.dto.ProductTypeRequest;
import com.upc.edu.pe.petcare.dto.ProviderJoinProductTypeRequest;
import com.upc.edu.pe.petcare.dto.response.ProductTypeResponse;
import com.upc.edu.pe.petcare.dto.response.ProviderJoinProductTypeResponse;
import com.upc.edu.pe.petcare.model.ProductType;
import com.upc.edu.pe.petcare.model.ProviderJoinProductType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProviderJoinProductTypeConverter {
    @Autowired
    private ModelMapper modelMapper;

    public ProviderJoinProductType convertDTOToEntity(ProviderJoinProductTypeRequest request) {
        return modelMapper.map(request, ProviderJoinProductType.class);
    }

    public ProviderJoinProductTypeResponse convertEntityToDTO(ProviderJoinProductType entity) {
        return modelMapper.map(entity, ProviderJoinProductTypeResponse.class);
    }

    public List<ProviderJoinProductTypeResponse> convertListEntityToDTO(List<ProviderJoinProductType> list) {
        return list.stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }


}
