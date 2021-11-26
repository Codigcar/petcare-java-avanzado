package com.upc.edu.pe.petcare.controller;

import com.upc.edu.pe.petcare.dto.ProviderRequest;
import com.upc.edu.pe.petcare.dto.response.ProviderResponse;
import com.upc.edu.pe.petcare.exception.ModelNotFoundException;
import com.upc.edu.pe.petcare.model.BusinessProfile;
import com.upc.edu.pe.petcare.model.Pet;
import com.upc.edu.pe.petcare.model.Provider;
import com.upc.edu.pe.petcare.service.BusinessProfileService;
import com.upc.edu.pe.petcare.service.ProviderService;
import com.upc.edu.pe.petcare.util.ExceptionMessageEnum;
import com.upc.edu.pe.petcare.util.ProviderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @Autowired
    private BusinessProfileService businessProfileService;

    @Autowired
    private ProviderConverter providerConverter;

    @GetMapping()
    public ResponseEntity<List<ProviderResponse>> getAllProviders() throws Exception{
        List<Provider> providers = providerService.getAll();
        return new ResponseEntity<>(providerConverter.convertListEntityToDTO(providers), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Provider> createProvider(@Valid @RequestBody ProviderRequest providerRequest) throws Exception{
        BusinessProfile businessProfile = businessProfileService.getById(providerRequest.getBusiness_profile_id())
                .orElseThrow(()-> new ModelNotFoundException(ExceptionMessageEnum.MODEL_NOT_FOUND.getValue()));
        Provider provider = providerConverter.convertDTOToEntity(providerRequest);
        provider.setBusinessProfile(businessProfile);
        Provider newProvider = providerService.create(provider);
        return new ResponseEntity<>(newProvider, HttpStatus.CREATED);
    }

    //@PutMapping()
    //public ResponseEntity<Provider> updateProvider(@Valid @RequestBody ProviderRequest providerRequest) throws Exception{
    //    Provider provider = providerService.update(providerConverter.convertDTOToEntity(providerRequest));
    //    return new ResponseEntity<>(provider, HttpStatus.CREATED);
    //}

    @GetMapping("/{id}")
    public ResponseEntity<ProviderResponse> findByBusinessProfileId(@PathVariable("id") Long id)throws Exception{
        Provider providers = new Provider();
        providers = providerService.findByBusinessProfileId(id);
        return new ResponseEntity<>(providerConverter.convertEntityToDTO(providers), HttpStatus.OK);
    }
}
