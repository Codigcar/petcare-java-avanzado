package com.upc.edu.pe.petcare.repository;


import com.upc.edu.pe.petcare.model.BusinessProfile;
import com.upc.edu.pe.petcare.model.PersonProfile;

public interface BusinessProfileRepository extends GenericRepository<BusinessProfile,Long> {

    BusinessProfile findBusinessProfileByAccount_Id(Long id);
}
