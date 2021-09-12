package com.upc.edu.pe.petcare.service;


import com.upc.edu.pe.petcare.dto.PersonProfileRequest;
import com.upc.edu.pe.petcare.model.Account;
import com.upc.edu.pe.petcare.model.PersonProfile;

public interface PersonProfileService extends CrudService<PersonProfile, Long> {

    PersonProfile registerPersonProfile(PersonProfile personProfile, Account account) throws Exception;
}
