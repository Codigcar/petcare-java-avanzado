package com.upc.edu.pe.petcare.controller;

import com.upc.edu.pe.petcare.dto.BusinessProfileRequest;
import com.upc.edu.pe.petcare.dto.response.BusinessProfileResponse;
import com.upc.edu.pe.petcare.model.Account;
import com.upc.edu.pe.petcare.model.BusinessProfile;
import com.upc.edu.pe.petcare.model.PersonProfile;
import com.upc.edu.pe.petcare.service.AccountService;
import com.upc.edu.pe.petcare.service.BusinessProfileService;
import com.upc.edu.pe.petcare.util.AccountConverter;
import com.upc.edu.pe.petcare.util.BusinessProfileConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @Autowired
    private AccountService accountService;

    /*
    @PostMapping()
    public ResponseEntity<PersonProfile> verifyAccount(@Valid @RequestBody Account account) throws Exception{
        PersonProfile personProfileDB = accountService.findAccountByEmailAndPassword(account.getEmail(), account.getPassword());
        return new ResponseEntity<>(personProfileDB, HttpStatus.CREATED);
    }
     */
}
