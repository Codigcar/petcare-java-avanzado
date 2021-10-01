package com.upc.edu.pe.petcare.util;


import com.upc.edu.pe.petcare.dto.BusinessProfileRequest;
import com.upc.edu.pe.petcare.dto.PersonProfileRequest;
import com.upc.edu.pe.petcare.dto.response.PersonProfileResponse;
import com.upc.edu.pe.petcare.model.Account;
import com.upc.edu.pe.petcare.model.PersonProfile;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountConverter {

    @Autowired
    private ModelMapper modelMapper;

    public Account convertPersonProfileRequestDTOToEntity(PersonProfileRequest request){
        return modelMapper.map(request, Account.class);
    }

    public Account convertBusinessProfileRequestDTOToEntity(BusinessProfileRequest request){
        return modelMapper.map(request, Account.class);
    }
}

// Permite ser inyectado en otra clase, poner uno de estos:
// @Component(general) - @Controller/@RestController - @Service - @Repository