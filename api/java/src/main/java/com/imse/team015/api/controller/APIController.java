package com.imse.team015.api.controller;


import com.imse.team015.api.service.APIDataService;
import com.imse.team015.model.Customer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class APIController {

    private final APIDataService service;
    //private final CustomerReposiory customerReposiory;
    public APIController(APIDataService service) {
        this.service = service;
    }

    /*@GetMapping("/data_generator")
    List<Customer> getCustomers(){
        return customerReposiory.findAll();
    }*/



}
