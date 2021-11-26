package com.upc.edu.pe.petcare.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.upc.edu.pe.petcare.model.*;
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

    @NotNull(message = "fecha no puede ser vacio")
    private Date createdAt;

    @NotNull(message = "tiempo no puede ser vacio")
    private String startTime;

    @NotNull(message = "status no puede ser vacio")
    private int status;

    @NotNull(message = "description no puede ser vacio")
    private String description;

    @NotNull(message = "mes no puede ser vacio")
    private String mes;


    @NotNull(message = "pet_id no puede ser vacio")
    private Long pet_id;

    @NotNull(message = "product_id no puede ser vacio")
    private Long product_id;

    @NotNull(message = "provider_id no puede ser vacio")
    private Long provider_id;

    @NotNull(message = "personProfile_id no puede ser vacio")
    private Long personProfile_id;

    @NotNull(message = "productType_id no puede ser vacio")
    private Long productType_id;

}
