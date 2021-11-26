package com.upc.edu.pe.petcare.dto.response;

import lombok.Data;

@Data
public class ProviderResponse {

    Long id;

    private String businessName;

    private String region;

    private String ruc;

    private String address;

    private String email;

    private String phone;

    private String description;

    private String banner;
}
