package com.upc.edu.pe.petcare.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PersonProfileRequest {


    @NotNull
    @Size(min=3, message="Nombre es minimo 3 caracteres")
    private String name;

    @NotNull
    @Size(min=8, max = 8, message="DNI es minimo 8 numeros")
    private String dni;

    @NotNull
    @Size(min=9, max = 9, message="Telefono es minimo 9 numeros")
    private String phone;

    @NotNull
    @Size(min=2, message="Edad es minimo 2 numeros")
    private String age;

    @NotNull
    @Size(min=3, message="Password es minimo 3 caracteres")
    private String password;

    @NotNull
    @Size(min=3, message="Email es minimo 3 caracteres")
    private String email;
}
