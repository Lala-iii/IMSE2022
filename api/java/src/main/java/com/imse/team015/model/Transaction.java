package com.imse.team015.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    private Long sender_account;
    private Long receiver_account;
    private String transaction_type;
    private String expense_type;
    private Date date_of_occurrence;
    private String payment_reference;
    private double amount;
}
