package com.upc.edu.pe.petcare.controller;

import com.upc.edu.pe.petcare.dto.AccountRequest;
import com.upc.edu.pe.petcare.dto.response.AccountResponse;
import com.upc.edu.pe.petcare.exception.ModelNotFoundException;
import com.upc.edu.pe.petcare.model.PersonProfile;
import com.upc.edu.pe.petcare.repository.PersonProfileRepository;
import com.upc.edu.pe.petcare.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/verifyEmail")
public class LoginController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private PersonProfileRepository personProfileRepository;


    @PostMapping()
    public ResponseEntity<Object> verifyAccount(@Valid @RequestBody AccountRequest accountRequest) throws Exception{
        if (Objects.equals(accountRequest.getEmail(), "") ) {
            throw new ModelNotFoundException("Los campos no pueden estar vacios");
        }
        Object personProfile = accountService.findAccountByEmailAndPassword(accountRequest.getEmail());
        return new ResponseEntity<>(personProfile, HttpStatus.OK);
    }
}
