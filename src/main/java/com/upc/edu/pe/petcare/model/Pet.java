package com.upc.edu.pe.petcare.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "pet")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "age", nullable = false, length = 5)
    private Integer age;

    @Column(name = "breed", nullable = false, length = 150)
    private String breed;

    @Column(name = "photo", nullable = false, length = 300)
    private String photo;

    @Column(name = "gender", nullable = false)
    private Boolean gender;

    @ManyToOne()
    @JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(name = "FK_pet_person"))
    @JsonIgnoreProperties("pets")
    private PersonProfile person;

}
