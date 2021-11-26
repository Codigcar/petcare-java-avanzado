package com.upc.edu.pe.petcare.service.impl;

import com.upc.edu.pe.petcare.model.Pet;
import com.upc.edu.pe.petcare.repository.GenericRepository;
import com.upc.edu.pe.petcare.repository.PetRepository;
import com.upc.edu.pe.petcare.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
