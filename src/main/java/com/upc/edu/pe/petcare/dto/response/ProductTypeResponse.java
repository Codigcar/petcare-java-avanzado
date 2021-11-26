package com.upc.edu.pe.petcare.dto.response;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ProductTypeResponse {
    private Long id;

    private String name;

    private String description;
}
