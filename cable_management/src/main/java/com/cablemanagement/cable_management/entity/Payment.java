package com.cablemanagement.cable_management.entity;



import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {
    public Long normalPrice =220L;
    public Long sportsPrice = 250L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @Nonnull
    @Column(name = "amount_paid")
    private Long paid;

    @Nonnull
    @LastModifiedDate
    @Column(name = "payment_date")
    private String paymentDate;

    @Nonnull
    @Column(name = "due")
    private Long due;


    @JsonIgnore
    @OneToOne(fetch=FetchType.EAGER,optional=false)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

}
