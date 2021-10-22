package com.upc.edu.pe.petcare.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.upc.edu.pe.petcare.model.BusinessProfile;
import com.upc.edu.pe.petcare.model.PersonProfile;
import com.upc.edu.pe.petcare.model.Pet;
import com.upc.edu.pe.petcare.model.Product;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class AppointmentRequest {

    @NotNull
    private Date createdAt;

    @NotNull
    private String startTime;

    @NotNull
    private String veterinaryName;

    @NotNull
    private String productTypeName;

    @NotNull
    private String productName;

    @NotNull
    private String petName;

    @NotNull
    private String PersonName;

    @NotNull
    private Pet pet;

    @NotNull
    private Product product;

    @NotNull
    private BusinessProfile businessProfile;

    @NotNull
    private PersonProfile personProfile;

}
