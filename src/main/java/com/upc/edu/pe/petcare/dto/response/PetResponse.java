package com.upc.edu.pe.petcare.dto.response;

import lombok.Data;

import javax.persistence.Column;

@Data
public class PetResponse {
    private Long id;

    private String name;

    private Integer age;

    private String breed;

    private String photo;

    private Boolean gender;
}
