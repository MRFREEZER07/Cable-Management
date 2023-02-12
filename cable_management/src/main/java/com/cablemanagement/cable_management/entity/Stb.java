package com.cablemanagement.cable_management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stbox")
public class Stb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stb_id")
    private Long id;

    @NonNull
    @Column(name = "stbox_number")
    private String StboxNumber;

    @NonNull
    @Column(name = "stbox_id")
    private String StboxId;

    @NonNull
    @Column(name = "stbox_cust_number")
    private String StboxCustNumber;
    
    @NonNull
    @Column(name = "stbox_type")
    private String StboxType;
    
    @JsonIgnore
    @OneToOne(optional = false,fetch=FetchType.LAZY)
    @JoinColumn(name = "customer_id",referencedColumnName = "id") 
    private Customer customer;

}
