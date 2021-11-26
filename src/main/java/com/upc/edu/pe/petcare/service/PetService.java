package com.upc.edu.pe.petcare.service;

import com.upc.edu.pe.petcare.model.Pet;

import java.util.List;

public interface PetService extends CrudService<Pet, Long> {
    List<Pet> findByPersonId(Long id) throws Exception;
}
