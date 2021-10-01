package com.upc.edu.pe.petcare.repository;


import com.upc.edu.pe.petcare.model.PersonProfile;

public interface PersonProfileRepository extends GenericRepository<PersonProfile,Long> {
    PersonProfile findPersonProfileByAccount_Id(Long id);
}
