package com.cablemanagement.cable_management.entity;

import java.sql.Date;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Payment {
    private Long Id;
    private int AmountPaid;
    private int balanceAmount;
    private Date paymentDate;
    private int totalDue;
    
}
