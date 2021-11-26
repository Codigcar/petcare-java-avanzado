package com.upc.edu.pe.petcare.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.upc.edu.pe.petcare.model.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
public class AccountResponse {
     Long id;

     String name;

     String dni;

     String phone;

     String age;

     Account account;

}

