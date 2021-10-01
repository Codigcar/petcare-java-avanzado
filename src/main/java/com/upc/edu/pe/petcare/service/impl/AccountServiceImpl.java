package com.upc.edu.pe.petcare.service.impl;

import com.upc.edu.pe.petcare.exception.ModelNotFoundException;
import com.upc.edu.pe.petcare.model.Account;
import com.upc.edu.pe.petcare.model.PersonProfile;
import com.upc.edu.pe.petcare.model.Pet;
import com.upc.edu.pe.petcare.repository.AccountRepository;
import com.upc.edu.pe.petcare.repository.GenericRepository;
import com.upc.edu.pe.petcare.repository.PersonProfileRepository;
import com.upc.edu.pe.petcare.repository.PetRepository;
import com.upc.edu.pe.petcare.service.AccountService;
import com.upc.edu.pe.petcare.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl extends CrudServiceImpl<Account, Long> implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PersonProfileRepository personProfileRepository;


    @Override
    protected GenericRepository<Account, Long> getRepository() {
        return accountRepository;
    }


    @Override
    public PersonProfile findAccountByEmailAndPassword(String email, String password) {

        if (email == "" || password=="") {
            new ModelNotFoundException("Los campos no pueden estar vacios");
        }

        Account accountDB = accountRepository.findAccountByEmailAndPassword(email, password).orElseThrow(()-> new ModelNotFoundException("correo y/o contraseña incorrecta"));
        PersonProfile personProfileDB = personProfileRepository.findPersonProfileByAccount_Id(accountDB.getId());
        return personProfileDB;
    }

}