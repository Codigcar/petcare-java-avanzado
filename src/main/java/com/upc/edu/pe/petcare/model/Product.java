package com.upc.edu.pe.petcare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    //RelationShips
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "product_type_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ProductType productType;


}

/*
    @ManyToOne()
    @JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(name = "FK_pet_person"))
    private PersonProfile person;

*/