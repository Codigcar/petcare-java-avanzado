package com.upc.edu.pe.petcare.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.upc.edu.pe.petcare.model.BusinessProfile;
import com.upc.edu.pe.petcare.model.PersonProfile;
import com.upc.edu.pe.petcare.model.Pet;
import com.upc.edu.pe.petcare.model.Product;
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

    private String veterinaryName;

    private String productTypeName;

    private String productName;

    private String petName;

    private int status;

    private String PersonName;

    private Pet pet;

    private Product product;

    private BusinessProfile businessProfile;

    private PersonProfile personProfile;
}
