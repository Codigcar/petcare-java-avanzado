package com.upc.edu.pe.petcare.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "business_profile")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class BusinessProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "dni", nullable = false, length = 8)
    private String dni;

    @Column(name = "phone", nullable = false, length = 9)
    private String phone;

    @Column(name = "age", nullable = false, length = 3)
    private String age;

    @Column(name = "owner", nullable = false, length = 9)
    private Boolean owner;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Account account;

    @OneToMany(mappedBy = "businessProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("businessProfile")
    private List<Provider> providers;

}
