package com.upc.edu.pe.petcare.service;


import com.upc.edu.pe.petcare.dto.response.AccountResponse;
import com.upc.edu.pe.petcare.model.Account;

public interface AccountService extends CrudService<Account, Long> {

   Object findAccountByEmailAndPassword(String email) throws Exception;
   AccountResponse findOneByEmail(String email) throws Exception;
}
