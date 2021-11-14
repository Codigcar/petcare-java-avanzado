package com.upc.edu.pe.petcare.dto.response;

import lombok.Data;

@Data
public class ProductResponse {
    private Long id;
    private String name;

    private String description;
    private String image;
}
