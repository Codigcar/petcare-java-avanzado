package com.upc.edu.pe.petcare.dto.response;

import lombok.Data;

@Data
public class BusinessProfileResponse {

    private Long id;

    private String name;

    private String dni;

    private String phone;

    private String age;

    private Boolean owner;
}
