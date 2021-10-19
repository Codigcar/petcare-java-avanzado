                                                                                                                                                                                                                                            package com.upc.edu.pe.petcare.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "provider_join_product_type")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ProviderJoinProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_type_id", nullable = false, foreignKey = @ForeignKey(name = "FK_providerjoinproducttype_producttype"))
    private ProductType productType;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false, foreignKey = @ForeignKey(name = "FK_providerjoinproducttype_provider"))
    private Provider provider;

}
