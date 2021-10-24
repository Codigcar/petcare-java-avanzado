package com.upc.edu.pe.petcare.service;


import com.upc.edu.pe.petcare.model.Account;
import com.upc.edu.pe.petcare.model.PersonProfile;

import java.util.Optional;

public interface AccountService extends CrudService<Account, Long> {

    PersonProfile findAccountByEmailAndPassword(String email, String password) throws Exception;
}
