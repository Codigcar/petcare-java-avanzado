package com.upc.edu.pe.petcare.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.upc.edu.pe.petcare.model.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
public class AppointmentResponse {
    private Long id;

    private Date createdAt;

    private String startTime;

    private int status;


    private Pet pet;

    private Product product;

    private BusinessProfile businessProfile;

    private PersonProfile personProfile;

    //private ProductType productType;
}

