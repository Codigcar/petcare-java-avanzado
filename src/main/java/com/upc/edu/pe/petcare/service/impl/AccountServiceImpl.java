package com.upc.edu.pe.petcare.service.impl;

import com.upc.edu.pe.petcare.dto.response.AccountResponse;
import com.upc.edu.pe.petcare.exception.ModelNotFoundException;
import com.upc.edu.pe.petcare.model.Account;
import com.upc.edu.pe.petcare.model.BusinessProfile;
import com.upc.edu.pe.petcare.model.PersonProfile;
import com.upc.edu.pe.petcare.repository.AccountRepository;
import com.upc.edu.pe.petcare.repository.BusinessProfileRepository;
import com.upc.edu.pe.petcare.repository.GenericRepository;
import com.upc.edu.pe.petcare.repository.PersonProfileRepository;
import com.upc.edu.pe.petcare.service.AccountService;
import com.upc.edu.pe.petcare.util.AccountConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

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

    @Autowired
    private AccountConverter accountConverter;

    @Autowired
    private BusinessProfileRepository businessProfileRepository;

    @Override
    public Object findAccountByEmailAndPassword(String email) throws Exception {

        try{
        Account accountDB = accountRepository.findAccountByEmailAndPassword(email).orElseThrow(() -> new ModelNotFoundException("correo y/o contraseña incorrecta"));
            System.out.println("accountDB: " +accountDB);

        Object data = null;

        if (accountDB.getRol().getId() == 2) {
            data = personProfileRepository.findPersonProfileByAccount_Id(accountDB.getId());
        } else if (accountDB.getRol().getId() == 3) {
            data = businessProfileRepository.findBusinessProfileByAccount_Id(accountDB.getId());
        }
/*
           if(personProfileDB == null){
               accountResponse =  accountConverter.convertBPDTOToEntity( businessProfileRepository.findBusinessProfileByAccount_Id(accountDB.getId()));
           } else {
               accountResponse =  accountConverter.convertPPDTOToEntity(personProfileDB);
           }

 */
        return data;
       }catch ( Exception e ){
           throw new Exception("Error en el login: "+ e);
       }
    }
    


    @Override
    public AccountResponse findOneByEmail(String email) throws Exception {
        return accountConverter.convertEntityToDTO(accountRepository.findOneByEmail(email));
    }
}
