package com.upc.edu.pe.petcare.repository;


import com.upc.edu.pe.petcare.model.Account;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends GenericRepository<Account,Long> {
    @Query("select a from Account  a where a.email = ?1 ")
    Optional<Account> findAccountByEmailAndPassword(String email);

    @Query("select c from Account c where c.email = ?1 " )
    Account findOneByEmail(String email);
}
