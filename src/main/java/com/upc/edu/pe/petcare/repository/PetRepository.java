package com.upc.edu.pe.petcare.repository;

import com.upc.edu.pe.petcare.model.Pet;

import java.util.List;

public interface PetRepository extends GenericRepository<Pet, Long> {
    List<Pet> findByPersonId(Long id) throws Exception;
}
