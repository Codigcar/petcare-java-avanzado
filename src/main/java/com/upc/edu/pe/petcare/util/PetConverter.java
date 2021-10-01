package com.upc.edu.pe.petcare.util;

import com.upc.edu.pe.petcare.dto.PetRequest;
import com.upc.edu.pe.petcare.dto.response.PetResponse;
import com.upc.edu.pe.petcare.model.Pet;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PetConverter {

    @Autowired
    private ModelMapper modelMapper;

    public Pet convertDTOToEntity(PetRequest petRequest){
        return modelMapper.map(petRequest, Pet.class);
    }

    public PetResponse convertEntityToDTO(Pet entity){
        return modelMapper.map(entity, PetResponse.class);
    }

    public List<PetResponse> convertListEntityToDTO(List<Pet> pets){
        return pets.stream().map(mapEntity -> convertEntityToDTO(mapEntity)).collect(Collectors.toList());
    }
}
