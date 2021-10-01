package com.upc.edu.pe.petcare.util;


import com.upc.edu.pe.petcare.dto.PersonProfileRequest;
import com.upc.edu.pe.petcare.dto.response.PersonProfileResponse;
import com.upc.edu.pe.petcare.model.PersonProfile;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonProfileConverter {

    @Autowired
    private ModelMapper modelMapper;

    public PersonProfile convertDTOToEntity(PersonProfileRequest request){
        return modelMapper.map(request, PersonProfile.class);
    }

    public PersonProfileResponse convertEntityToDto(PersonProfile entity){
        return modelMapper.map(entity, PersonProfileResponse.class);
    }

    public List<PersonProfileResponse>  convertListEntityToDto(List<PersonProfile> list){
        return list.stream()
                .map(mapEntity -> convertEntityToDto(mapEntity))
                .collect(Collectors.toList());
    }
}

// Permite ser inyectado en otra clase, poner uno de estos:
// @Component(general) - @Controller/@RestController - @Service - @Repository