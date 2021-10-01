package com.upc.edu.pe.petcare.service.impl;

import com.upc.edu.pe.petcare.dto.PetRequest;
import com.upc.edu.pe.petcare.dto.response.PetResponse;
import com.upc.edu.pe.petcare.model.PersonProfile;
import com.upc.edu.pe.petcare.model.Pet;
import com.upc.edu.pe.petcare.repository.GenericRepository;
import com.upc.edu.pe.petcare.repository.PersonProfileRepository;
import com.upc.edu.pe.petcare.repository.PetRepository;
import com.upc.edu.pe.petcare.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl extends CrudServiceImpl<Pet, Long> implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    protected GenericRepository<Pet, Long> getRepository() {
        return petRepository;
    }

    @Override
    public List<Pet> findByPersonId(Long id) throws Exception{
        return petRepository.findByPersonId(id);
    }
}
