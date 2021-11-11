package com.upc.edu.pe.petcare.controller;

import com.upc.edu.pe.petcare.dto.AccountRequest;
import com.upc.edu.pe.petcare.dto.response.AccountResponse;
import com.upc.edu.pe.petcare.model.PersonProfile;
import com.upc.edu.pe.petcare.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @Autowired
    private AccountService accountService;

    @PostMapping()
    public ResponseEntity<AccountResponse> verifyAccount(@Valid @RequestBody AccountRequest accountRequest) throws Exception{
        AccountResponse personProfile = accountService.findAccountByEmailAndPassword(accountRequest.getEmail(), accountRequest.getPassword());
        return new ResponseEntity<>(personProfile, HttpStatus.CREATED);
    }
}
