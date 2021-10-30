package com.upc.edu.pe.petcare.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Blob;

@Entity
@Table(name = "provider")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "business_name", nullable = false, length = 50)
    private String businessName;

    @Column(name = "region", nullable = false, length = 50)
    private String region;

    @Column(name = "ruc", nullable = false, length = 11)
    private String ruc;

    @Column(name = "address", nullable = false, length = 150)
    private String address;

    @Column(name = "email", nullable = false, length = 70)
    private String email;

    @Column(name = "phone", nullable = false, length = 9)
    private String phone;

    @Lob
    @NotEmpty
    @Type(type = "org.hibernate.type.TextType")
    private String description;

    @Column(name = "banner", length = 300)
    private String banner;

    @ManyToOne()
    @JoinColumn(name = "business_profile_id", nullable = false, foreignKey = @ForeignKey(name = "FK_provider_business"))
    @JsonIgnoreProperties("providers")
    private BusinessProfile businessProfile;
}
