package com.upc.edu.pe.petcare.service.impl;


import com.upc.edu.pe.petcare.model.Account;
import com.upc.edu.pe.petcare.model.PersonProfile;
import com.upc.edu.pe.petcare.repository.*;
import com.upc.edu.pe.petcare.service.PersonProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonProfileServiceImpl extends CrudServiceImpl<PersonProfile, Long> implements PersonProfileService {

    @Autowired
    private PersonProfileRepository personProfileRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;

    // @Autowired     <--- esto ya no va, no va porque quiero crear una instnacia totalmente diferente
    private BCryptPasswordEncoder bbcryt = new BCryptPasswordEncoder();


    @Override
    protected GenericRepository<PersonProfile, Long> getRepository() {
        return personProfileRepository;
    }

    @Override
    public PersonProfile registerPersonProfile(PersonProfile personProfile, Account account) throws Exception {
        account.setRol(rolRepository.getById(2L));
        account.setPassword(bbcryt.encode(account.getPassword()));
        account.setSubscriptionPlan(subscriptionPlanRepository.getById(1L));
        personProfile.setAccount(accountRepository.save(account));
        return personProfileRepository.save(personProfile);
    }
}
