package com.upc.edu.pe.petcare.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ProductRequest {

    @NotNull(message = "El nombre no puede estar vacio")
    @Size(min=3, message="Nombre es minimo 3 caracteres")
    public String name;

    @NotNull(message = "La descripción no puede estar vacio")
    @Size(min=3, message="Mínimin 3 caracteres")
    public String description;

    @NotNull(message = "provider_id no puede estar vacio")
    public Long provider_id;

    @NotNull(message = "product_type_id no puede estar vacio")
    public Long product_type_id;

}
