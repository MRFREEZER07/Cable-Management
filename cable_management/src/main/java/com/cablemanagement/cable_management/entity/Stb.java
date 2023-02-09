package com.cablemanagement.cable_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @Column(name = "id")
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

    @OneToOne(mappedBy = "stb", optional = false)
    private Customer user;

}
