package com.upc.edu.pe.petcare.util;


import com.upc.edu.pe.petcare.dto.AccountRequest;
import com.upc.edu.pe.petcare.dto.AppointmentRequest;
import com.upc.edu.pe.petcare.dto.BusinessProfileRequest;
import com.upc.edu.pe.petcare.dto.PersonProfileRequest;
import com.upc.edu.pe.petcare.dto.response.AccountResponse;
import com.upc.edu.pe.petcare.dto.response.AppointmentResponse;
import com.upc.edu.pe.petcare.dto.response.PersonProfileResponse;
import com.upc.edu.pe.petcare.model.Account;
import com.upc.edu.pe.petcare.model.Appointment;
import com.upc.edu.pe.petcare.model.BusinessProfile;
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

    public Appointment convertDTOToEntity(AccountRequest request) {
        return modelMapper.map(request, Appointment.class);
    }

    public AccountResponse convertEntityToDTO(Account entity) {
        return modelMapper.map(entity, AccountResponse.class);
    }

    public List<AccountResponse>  convertListEntityToDto(List<Account> list){
        return list.stream()
                .map(mapEntity -> convertEntityToDTO(mapEntity))
                .collect(Collectors.toList());
    }

    public Account convertPersonProfileRequestDTOToEntity(PersonProfileRequest request){
        return modelMapper.map(request, Account.class);
    }

    public Account convertBusinessProfileRequestDTOToEntity(BusinessProfileRequest request){
        return modelMapper.map(request, Account.class);
    }

    public AccountResponse convertBPDTOToEntity(BusinessProfile request){
        return modelMapper.map(request, AccountResponse.class);
    }

    public AccountResponse convertPPDTOToEntity(PersonProfile request){
        return modelMapper.map(request, AccountResponse.class);
    }
}

// Permite ser inyectado en otra clase, poner uno de estos:
// @Component(general) - @Controller/@RestController - @Service - @Repository