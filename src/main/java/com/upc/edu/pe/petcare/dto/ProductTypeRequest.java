package com.upc.edu.pe.petcare.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ProductTypeRequest {

    @NotNull
    @Size(min=3, message="Nombre es minimo 3 caracteres")
    private String name;

    @NotNull
    @Size(min=3, message="Descripcción es minimo 5 caracteres")
    private String description;

}
