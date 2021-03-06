package com.upc.edu.pe.petcare.controller;

import com.upc.edu.pe.petcare.dto.PersonProfileRequest;
import com.upc.edu.pe.petcare.dto.response.PersonProfileResponse;
import com.upc.edu.pe.petcare.model.PersonProfile;
import com.upc.edu.pe.petcare.service.PersonProfileService;
import com.upc.edu.pe.petcare.util.AccountConverter;
import com.upc.edu.pe.petcare.util.PersonProfileConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/personprofiles")
public class PersonProfileController {

    @Autowired
    private PersonProfileService personProfileService;

    @Autowired
    private PersonProfileConverter personProfileConverter;

    @Autowired
    private AccountConverter accountConverter;

    //@Autowired
    //private BCryptPasswordEncoder bcryt;
    // personProfileRequest.setPassword( bcryt.encode(personProfileRequest.getPassword()) );

    @GetMapping()
    public ResponseEntity<List<PersonProfileResponse>> getAllPersonProfiles() throws Exception{
        List<PersonProfile> personProfileList = personProfileService.getAll();
        return new ResponseEntity<>(personProfileConverter.convertListEntityToDto(personProfileList), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<PersonProfileResponse> createProfile( @Valid @RequestBody PersonProfileRequest personProfileRequest) throws Exception{
       // personProfileRequest.setPassword( bcryt.encode(personProfileRequest.getPassword()) );
        PersonProfile profileNew = personProfileService
                .registerPersonProfile(personProfileConverter.convertDTOToEntity(personProfileRequest),
                        accountConverter.convertPersonProfileRequestDTOToEntity(personProfileRequest));
        return new ResponseEntity<>(personProfileConverter.convertEntityToDto(profileNew), HttpStatus.CREATED);
    }

}
