package com.upc.edu.pe.petcare.controller;

import com.upc.edu.pe.petcare.dto.AccountRequest;
import com.upc.edu.pe.petcare.dto.response.AccountResponse;
import com.upc.edu.pe.petcare.model.Account;
import com.upc.edu.pe.petcare.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/autenticacion")
public class AutenticacionController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/email")
    public <email> ResponseEntity<AccountResponse> getDataByEmail(@Valid @RequestBody AccountRequest accountRequest) throws Exception{
        AccountResponse account = accountService.findOneByEmail(accountRequest.getEmail());
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
