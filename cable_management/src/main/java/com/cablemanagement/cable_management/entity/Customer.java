package com.cablemanagement.cable_management.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "address")
    private String address;

    @NonNull
    @Column(name = "house_no")
    private String houseNo;

    
    @Column(name = "active")
    private boolean active = true;

    @NonNull
    @Column(name = "customer_type")
    private String customerType;

    @NonNull
    @Column(name = "pack")
    private String pack;

    @JsonIgnore
    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    private Stb stb;

    @JsonIgnore
     @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL )
    private Payment payment;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<History> history;

}
