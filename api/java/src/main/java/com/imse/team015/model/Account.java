package com.imse.team015.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    private Long owner; // customerid
    private String account_type;
    private Date date_of_creation;
    private String iban;
    private String bic;
    private double balance;
    private String currency;
    private double account_limit;
}
