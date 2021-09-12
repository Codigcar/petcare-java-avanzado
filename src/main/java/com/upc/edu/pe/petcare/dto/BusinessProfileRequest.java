package com.upc.edu.pe.petcare.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class BusinessProfileRequest {

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
    private Boolean owner;
}
