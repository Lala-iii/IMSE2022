package com.imse.team015.api.controller;


import com.imse.team015.api.service.APIDataService;
import com.imse.team015.model.Customer;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    String getTransactions() {
        return service.getTransactions();
    }

    @GetMapping("/transaction/{id}")
    String getTransactionById(@PathVariable Long id) {
        return service.getTransactionById(id);
    }

    @PostMapping("/transaction")
    void createTransaction(@RequestBody String transaction) {
        service.createTransaction(transaction);
    }

    @GetMapping("/switchToMongo")
    void switchDatabase() {
        service.switchToMongo(true);
    }

    @GetMapping("/switchToMySQL")
    void switchToMySQL() {
        service.switchToMongo(false);
    }
}
