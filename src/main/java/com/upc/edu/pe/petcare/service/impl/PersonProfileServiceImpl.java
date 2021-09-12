package com.upc.edu.pe.petcare.service.impl;


import com.upc.edu.pe.petcare.dto.PersonProfileRequest;
import com.upc.edu.pe.petcare.model.Account;
import com.upc.edu.pe.petcare.model.PersonProfile;
import com.upc.edu.pe.petcare.model.SubscriptionPlan;
import com.upc.edu.pe.petcare.repository.*;
import com.upc.edu.pe.petcare.service.PersonProfileService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    protected GenericRepository<PersonProfile, Long> getRepository() {
        return personProfileRepository;
    }

    @Override
    public PersonProfile registerPersonProfile(PersonProfile personProfile, Account account) throws Exception {
        /*Account accountNew = new Account();
        accountNew.setEmail(personProfileRequest.getEmail());
        accountNew.setPassword(personProfileRequest.getPassword());
        accountNew.setRol(rolRepository.getById(2L));
        accountNew.setSubscriptionPlan(subscriptionPlanRepository.getById(1L));

        Account accountDB = accountRepository.save(accountNew);
        */
        account.setRol(rolRepository.getById(2L));
        account.setSubscriptionPlan(subscriptionPlanRepository.getById(1L));
        //Account accountDB = accountRepository.save(account);

        personProfile.setAccount(accountRepository.save(account));
        //personProfileRepository.save(personProfile);
        return personProfileRepository.save(personProfile);
    }
}
