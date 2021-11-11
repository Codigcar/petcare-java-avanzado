package com.upc.edu.pe.petcare.service;


import com.upc.edu.pe.petcare.dto.response.AccountResponse;
import com.upc.edu.pe.petcare.model.Account;
import com.upc.edu.pe.petcare.model.PersonProfile;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface AccountService extends CrudService<Account, Long> {

   AccountResponse findAccountByEmailAndPassword(String email, String password) throws Exception;

}
