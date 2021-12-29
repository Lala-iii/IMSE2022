package com.example.bankapp.controller;

import com.example.bankapp.model.Customer;

import com.example.bankapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class Controller {

    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping("/customers")
    public List<Customer> fetchCustomers() {
        return customerRepository.findAll();
    }

}

