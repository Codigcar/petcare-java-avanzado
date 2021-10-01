package com.upc.edu.pe.petcare.controller;

import com.upc.edu.pe.petcare.dto.BusinessProfileRequest;
import com.upc.edu.pe.petcare.dto.PersonProfileRequest;
import com.upc.edu.pe.petcare.dto.response.BusinessProfileResponse;
import com.upc.edu.pe.petcare.dto.response.PersonProfileResponse;
import com.upc.edu.pe.petcare.model.BusinessProfile;
import com.upc.edu.pe.petcare.model.PersonProfile;
import com.upc.edu.pe.petcare.service.BusinessProfileService;
import com.upc.edu.pe.petcare.service.PersonProfileService;
import com.upc.edu.pe.petcare.util.AccountConverter;
import com.upc.edu.pe.petcare.util.BusinessProfileConverter;
import com.upc.edu.pe.petcare.util.PersonProfileConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/businessprofiles")
public class BusinessProfileController {

    @Autowired
    private BusinessProfileService businessProfileService;

    @Autowired
    private BusinessProfileConverter businessProfileConverter;

    @Autowired
    private AccountConverter accountConverter;

    @GetMapping()
    public ResponseEntity<List<BusinessProfileResponse>> getAllBusinessProfiles() throws Exception{
        List<BusinessProfile> list = businessProfileService.getAll();
        return new ResponseEntity<>(businessProfileConverter.convertListEntityToDto(list), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<BusinessProfileResponse> createProfile( @Valid @RequestBody BusinessProfileRequest businessProfileRequest) throws Exception{
        BusinessProfile businessProfileNew = businessProfileService.registerBusinessProfile(businessProfileConverter.convertDTOToEntity(businessProfileRequest), accountConverter.convertBusinessProfileRequestDTOToEntity(businessProfileRequest));
        return new ResponseEntity<>(businessProfileConverter.convertEntityToDto(businessProfileNew), HttpStatus.CREATED);
    }
}
