package com.upc.edu.pe.petcare.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ProductRequest {

    @NotNull
    @Size(min=3, message="Nombre es minimo 3 caracteres")
    public String name;

    @NotNull
    @Size(min=3, message="Mínimin 3 caracteres")
    public String description;

    @NotNull
    public Long provider_id;

}
