package com.upc.edu.pe.petcare.dto.response;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class PetResponse {
     Long id;

     String name;

     Integer age;

     String breed;

     String photo;

     Boolean gender;

     String weight;

     String color;

     String eyeColor;

     String body;

     String chest;

     String neck;
}
