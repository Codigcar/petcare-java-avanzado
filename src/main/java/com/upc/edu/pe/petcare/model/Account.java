package com.upc.edu.pe.petcare.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "account")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, length = 80)
    private String email;

    @Column(name = "password", nullable = false, length = 80)
    private String password;

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false, foreignKey = @ForeignKey(name = "FK_account_rol"))
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "subscription_plan_id", nullable = false, foreignKey = @ForeignKey(name = "FK_account_subscriptionplan"))
    private SubscriptionPlan subscriptionPlan;

    //@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<PersonProfile> personProfileList;

}
