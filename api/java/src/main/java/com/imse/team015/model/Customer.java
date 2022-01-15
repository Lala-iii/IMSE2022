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
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String firstname;
    private String lastname;
    private String gender;
    private int svnr;
    private Date date_of_birth;
    private String street_with_no;
    private String city;
    private String postal_code;
}
