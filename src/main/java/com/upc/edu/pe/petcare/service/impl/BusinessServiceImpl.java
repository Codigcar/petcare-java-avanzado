package com.upc.edu.pe.petcare.service.impl;


import com.upc.edu.pe.petcare.model.Account;
import com.upc.edu.pe.petcare.model.BusinessProfile;
import com.upc.edu.pe.petcare.repository.*;
import com.upc.edu.pe.petcare.service.BusinessProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl extends CrudServiceImpl<BusinessProfile, Long> implements BusinessProfileService {

    @Autowired
    private BusinessProfileRepository businessProfileRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;

    @Override
    protected GenericRepository<BusinessProfile, Long> getRepository() {
        return businessProfileRepository;
    }

    @Override
    public BusinessProfile registerBusinessProfile(BusinessProfile businessProfile, Account account) throws Exception {
        account.setRol(rolRepository.getById(3L));
        account.setSubscriptionPlan(subscriptionPlanRepository.getById(2L));
        businessProfile.setAccount(accountRepository.save(account));
        return businessProfileRepository.save(businessProfile);
    }
}
