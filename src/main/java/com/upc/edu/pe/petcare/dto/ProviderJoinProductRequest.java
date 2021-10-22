package com.upc.edu.pe.petcare.dto;

import com.upc.edu.pe.petcare.model.Pet;
import com.upc.edu.pe.petcare.model.Product;
import com.upc.edu.pe.petcare.model.Provider;
import lombok.Data;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ProviderJoinProductRequest {


    @NotNull
    private Long product_id;

    @NotNull
    private Long provider_id;
}
