package com.upc.edu.pe.petcare.service;


import com.upc.edu.pe.petcare.model.PersonProfile;

public interface AccountService extends CrudService<PersonProfile, Long> {

    PersonProfile registerPersonProfile(PersonProfile personProfile, Long accountId) throws Exception;
}
