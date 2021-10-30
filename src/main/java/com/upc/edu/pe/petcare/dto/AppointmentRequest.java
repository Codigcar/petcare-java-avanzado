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

    @NotNull
    private Date createdAt;

    @NotNull
    private String startTime;

    @NotNull
    private int status;

    @NotNull
    private Long pet_id;

    @NotNull
    private Long product_id;

    @NotNull
    private Long businessProfile_id;

    @NotNull
    private Long personProfile_id;

    @NotNull
    private Long productType_id;

}
