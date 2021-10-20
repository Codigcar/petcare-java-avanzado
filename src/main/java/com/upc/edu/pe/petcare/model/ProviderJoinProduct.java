                                                                                                                                                                                                                                            package com.upc.edu.pe.petcare.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "provider_join_products")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ProviderJoinProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "FK_providerjoinproducttype_product"))
    private Product product;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false, foreignKey = @ForeignKey(name = "FK_providerjoinproducttype_provider"))
    private Provider provider;

}
