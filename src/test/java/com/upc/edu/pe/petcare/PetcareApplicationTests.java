package com.upc.edu.pe.petcare;

import com.upc.edu.pe.petcare.model.Account;
import com.upc.edu.pe.petcare.model.Rol;
import com.upc.edu.pe.petcare.model.SubscriptionPlan;
import com.upc.edu.pe.petcare.repository.AccountRepository;
import com.upc.edu.pe.petcare.repository.RolRepository;
import com.upc.edu.pe.petcare.repository.SubscriptionPlanRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PetcareApplicationTests {

    @Autowired
    private AccountRepository repo;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;

    @Autowired
    private BCryptPasswordEncoder bcryt;

    @Test
    void verificarClave() {

        Rol rol = rolRepository.getById(2L);
        SubscriptionPlan subscriptionPlan = subscriptionPlanRepository.getById(1L);

        Account us=new Account();
        us.setId(4L);
        us.setEmail("pedro@gmail.com");
        us.setPassword(bcryt.encode("1234"));
        us.setRol(rol);
        us.setSubscriptionPlan(subscriptionPlan);
        Account retorno=repo.save(us);

        assertEquals(retorno.getPassword(), us.getPassword());
    }


}
