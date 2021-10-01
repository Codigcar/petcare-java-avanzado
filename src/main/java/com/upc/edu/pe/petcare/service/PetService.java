package com.upc.edu.pe.petcare.service;

import com.upc.edu.pe.petcare.dto.PetRequest;
import com.upc.edu.pe.petcare.dto.response.PetResponse;
import com.upc.edu.pe.petcare.model.Pet;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PetService extends CrudService<Pet, Long> {
    List<Pet> findByPersonId(Long id) throws Exception;
}
