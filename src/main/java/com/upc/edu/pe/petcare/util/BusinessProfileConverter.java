package com.upc.edu.pe.petcare.util;

import com.upc.edu.pe.petcare.dto.BusinessProfileRequest;
import com.upc.edu.pe.petcare.dto.response.BusinessProfileResponse;
import com.upc.edu.pe.petcare.model.BusinessProfile;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BusinessProfileConverter {

    @Autowired
    private ModelMapper modelMapper;

    public BusinessProfile convertDTOToEntity(BusinessProfileRequest request){
        return modelMapper.map(request, BusinessProfile.class);
    }

    public BusinessProfileResponse convertEntityToDto(BusinessProfile entity){
        return modelMapper.map(entity, BusinessProfileResponse.class);
    }

    public List<BusinessProfileResponse>  convertListEntityToDto(List<BusinessProfile> list){
        return list.stream()
                .map(mapEntity -> convertEntityToDto(mapEntity))
                .collect(Collectors.toList());
    }
}

// Permite ser inyectado en otra clase, poner uno de estos:
// @Component(general) - @Controller/@RestController - @Service - @Repository