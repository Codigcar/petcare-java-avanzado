package com.upc.edu.pe.petcare.dto.response;

import com.upc.edu.pe.petcare.model.Pet;
import com.upc.edu.pe.petcare.model.Provider;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProviderJoinProductTypeResponse {
    private Long id;

    private Pet productType;

    private Provider provider;
}
