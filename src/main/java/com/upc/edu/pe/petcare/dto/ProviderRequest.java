package com.upc.edu.pe.petcare.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ProviderRequest {

    @NotNull
    @Size(min=3, message="Nombre es minimo 3 caracteres")
    private String businessName;

    @NotNull
    @Size(min=3, message="Region es minimo 3 caracteres")
    private String region;

    @NotNull
    @Size(min=11, max = 11, message="RUC debe de tener 11 caracteres")
    private String ruc;

    @NotNull
    @Size(min=3, message="Dirección es minimo 3 caracteres")
    private String address;

    @NotNull
    @Email(message = "Email formato incorrecto")
    private String email;

    @NotNull
    @Size(min=9, max = 9, message="Telefono debe de tener 9 caracteres")
    private String phone;

    private String description;
    private String banner;
    private Long business_profile_id;
}
