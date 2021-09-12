package com.upc.edu.pe.petcare.service;


import com.upc.edu.pe.petcare.model.Account;
import com.upc.edu.pe.petcare.model.BusinessProfile;
import com.upc.edu.pe.petcare.model.PersonProfile;

public interface BusinessProfileService extends CrudService<BusinessProfile, Long> {

    BusinessProfile registerBusinessProfile(BusinessProfile businessProfile, Account account) throws Exception;

}
