package com.upc.edu.pe.petcare.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PetRequest {

    @NotNull
    @Size(min=3, message="name es minimo 3 caracteres")
    private String name;

    @NotNull(message = "age es obligatorio, number")
    private Integer age;

    @NotNull
    @Size(min=3, message="breed es minimo 3 caracteres")
    private String breed;

    @NotNull(message = "photo es obligatorio")
    private String photo;

    @NotNull(message = "gender es obligatorio")
    private Boolean gender;

    //--
    @NotNull(message = "weight es obligatorio")
    private String weight;

    @NotNull(message = "color es obligatorio")
    private String color;

    @NotNull(message = "eyeColor es obligatorio")
    private String eyeColor;

    @NotNull(message = "body es obligatorio")
    private String body;

    @NotNull(message = "chest es obligatorio")
    private String chest;

    @NotNull(message = "neck es obligatorio")
    private String neck;

    @NotNull
    private Long person_id;
}
