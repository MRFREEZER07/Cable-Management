package com.cablemanagement.cable_management.entity;

import java.sql.Date;

import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column(name = "id")
    private Long Id;

    @Nonnull
    @Column(name = "amount_paid")
    private Long amountPaid;

    @Nullable
    @LastModifiedDate
    @Column(name = "payment_date")
    private Date paymentDate;

    @Nullable
    @Column(name = "due")
    private Long due;


    @JsonIgnore
    @OneToOne(mappedBy = "payment", optional = false)
    private Customer user;

}
