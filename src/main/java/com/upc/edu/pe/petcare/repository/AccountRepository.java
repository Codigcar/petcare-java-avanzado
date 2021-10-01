package com.upc.edu.pe.petcare.repository;


import com.upc.edu.pe.petcare.model.Account;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends GenericRepository<Account,Long> {
    @Query("select a from Account  a where a.email = ?1 and a.password=?2")
    Optional<Account> findAccountByEmailAndPassword(String email, String password);
}
