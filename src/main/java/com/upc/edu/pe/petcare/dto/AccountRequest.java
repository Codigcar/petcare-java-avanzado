package com.upc.edu.pe.petcare.dto;

import com.upc.edu.pe.petcare.model.PersonProfile;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class AccountRequest {

    @NotNull(message = "email no puede ser vacio")
    private String email;

    //@NotNull(message = "password no puede ser vacio")
    private String password;
}
