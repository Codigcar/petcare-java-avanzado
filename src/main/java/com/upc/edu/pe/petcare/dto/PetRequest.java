package com.upc.edu.pe.petcare.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PetRequest {

    @NotNull
    @Size(min=3, message="Nombre es minimo 3 caracteres")
    private String name;

    @NotNull
    private Integer age;

    @NotNull
    @Size(min=3, message="Raza es minimo 3 caracteres")
    private String breed;

    @NotNull
    private String photo;

    @NotNull
    private Boolean gender;

    @NotNull
    private Long person_id;
}
