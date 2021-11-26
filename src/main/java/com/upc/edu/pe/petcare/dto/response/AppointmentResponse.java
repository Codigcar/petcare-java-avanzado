package com.upc.edu.pe.petcare.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.upc.edu.pe.petcare.model.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class AppointmentResponse {
    private Long id;

    private Date createdAt;

    private String startTime;

    private int status;

    private String description;

    private String mes;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Pet pet;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Product product;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Provider provider;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private PersonProfile personProfile;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ProductType productType;
}

