package com.upc.edu.pe.petcare.service.impl;

import com.upc.edu.pe.petcare.dto.response.AccountResponse;
import com.upc.edu.pe.petcare.exception.ModelNotFoundException;
import com.upc.edu.pe.petcare.model.Account;
import com.upc.edu.pe.petcare.model.PersonProfile;
import com.upc.edu.pe.petcare.repository.AccountRepository;
import com.upc.edu.pe.petcare.repository.BusinessProfileRepository;
import com.upc.edu.pe.petcare.repository.GenericRepository;
import com.upc.edu.pe.petcare.repository.PersonProfileRepository;
import com.upc.edu.pe.petcare.service.AccountService;
import com.upc.edu.pe.petcare.util.AccountConverter;
import com.upc.edu.pe.petcare.util.AppointmentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    public AccountResponse findAccountByEmailAndPassword(String email, String password) throws Exception {

        if (Objects.equals(email, "") || Objects.equals(password, "")) {
            throw new ModelNotFoundException("Los campos no pueden estar vacios");
        }
       try{
           Account accountDB = accountRepository.findAccountByEmailAndPassword(email, password).orElseThrow(()-> new ModelNotFoundException("correo y/o contraseña incorrecta"));
           AccountResponse accountResponse;

           PersonProfile personProfileDB = personProfileRepository.findPersonProfileByAccount_Id(accountDB.getId());

           if(personProfileDB == null){
               accountResponse =  accountConverter.convertBPDTOToEntity( businessProfileRepository.findBusinessProfileByAccount_Id(accountDB.getId()));
           } else {
               accountResponse =  accountConverter.convertPPDTOToEntity(personProfileDB);
           }

           /*
           List<GrantedAuthority> roles = new ArrayList<>();
           roles.add(new SimpleGrantedAuthority(accountDB.getRol().getName()));

           UserDetails ud = new User(accountDB.getEmail(), accountDB.getPassword(), true, true, true, true, roles);
            */


           return accountResponse;
       }catch ( Exception e ){
           throw new Exception("Error en el login: "+ e);
       }
    }
}
