package com.upc.edu.pe.petcare.model;
 /*
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
public class ProfilePK implements Serializable {


    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "dni", nullable = false, length = 8)
    private String dni;

    @Column(name = "phone", nullable = false, length = 9)
    private String phone;

    @Column(name = "age", nullable = false, length = 9)
    private String age;

   @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Account account;
}
*/

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
public class ProfilePK implements Serializable {


    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}
