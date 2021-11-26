package com.upc.edu.pe.petcare.controller;

import com.upc.edu.pe.petcare.dto.PetRequest;
import com.upc.edu.pe.petcare.dto.response.PetResponse;
import com.upc.edu.pe.petcare.exception.ModelNotFoundException;
import com.upc.edu.pe.petcare.model.PersonProfile;
import com.upc.edu.pe.petcare.model.Pet;
import com.upc.edu.pe.petcare.service.PersonProfileService;
import com.upc.edu.pe.petcare.service.PetService;
import com.upc.edu.pe.petcare.util.ExceptionMessageEnum;
import com.upc.edu.pe.petcare.util.PetConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private PersonProfileService personProfileService;

    @Autowired
    private PetConverter petConverter;

    @GetMapping()
    public ResponseEntity<List<PetResponse>> getAllPets() throws Exception{
        List<Pet> pets = petService.getAll();
        return new ResponseEntity<>(petConverter.convertListEntityToDTO(pets), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<PetResponse> createPet(@Valid @RequestBody PetRequest petRequest) throws Exception{
        PersonProfile personProfile = personProfileService.getById(petRequest.getPerson_id())
                .orElseThrow(()-> new ModelNotFoundException(ExceptionMessageEnum.MODEL_NOT_FOUND.getValue()));
        Pet pet = petConverter.convertDTOToEntity(petRequest);
        pet.setPerson(personProfile);
        Pet newPet = petService.create(pet);
        return new ResponseEntity<>(petConverter.convertEntityToDTO(newPet) , HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetResponse> getPetById(@PathVariable("id") Long id) throws Exception{
        Pet pet = petService.getById(id)
                .orElseThrow(()-> new ModelNotFoundException(ExceptionMessageEnum.MODEL_NOT_FOUND.getValue()));
        return new ResponseEntity<>(petConverter.convertEntityToDTO(pet), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable("id") Long id) throws Exception{
        Pet pet = petService.getById(id)
                .orElseThrow(()-> new ModelNotFoundException(ExceptionMessageEnum.MODEL_NOT_FOUND.getValue()));
        petService.delete(pet.getId());
    }

    //@PutMapping()
    //public ResponseEntity<Pet> updatePet(@Valid @RequestBody PetRequest petRequest) throws Exception{
    //    Pet pet = petService.update(petConverter.convertDTOToEntity(petRequest));
    //    return new ResponseEntity<>(pet, HttpStatus.OK);
    //}

    @GetMapping("/byPerson/{id}")
    public ResponseEntity<List<PetResponse>> getByPersonId(@PathVariable("id") Long id)throws Exception{
        List<Pet> pets = new ArrayList<Pet>();
        pets = petService.findByPersonId(id);
        return new ResponseEntity<>(petConverter.convertListEntityToDTO(pets), HttpStatus.OK);
    }


}
