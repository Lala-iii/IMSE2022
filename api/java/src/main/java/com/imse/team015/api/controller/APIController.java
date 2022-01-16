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

    @GetMapping("/transaction")
    String getTransactions() {
        return service.getTransactions();
    }

    @GetMapping("/transaction/{id}")
    String getTransactionById(@PathVariable Long id) {
        return service.getTransactionById(id);
    }

    @PostMapping("/transaction")
    void createTransaction(@RequestBody String payload) {
        service.createTransaction(payload);
    }

    @PutMapping("/transaction/{id}")
    void changeTransaction(@PathVariable Long id, @RequestBody String payload) {
        service.updateTransaction(id, payload);
    }

    @DeleteMapping("/transaction/{id}")
    void deleteTransaction(@PathVariable Long id) {
        service.deleteTransaction(id);
    }

    @GetMapping("/customer")
    String getCustomers() {
        return service.getCustomers();
    }

    @GetMapping("/customer/{id}")
    String getCustomerById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @PostMapping("/customer")
    void createCustomer(@RequestBody String payload) {
        service.createCustomer(payload);
    }

    @PutMapping("/customer/{id}")
    void changeCustomer(@PathVariable Long id, @RequestBody String payload) {
        service.updateCustomer(id, payload);
    }

    @DeleteMapping("/customer/{id}")
    void deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
    }

    @GetMapping("/account")
    String getAccounts() {
        return service.getAccounts();
    }

    @GetMapping("/account/{id}")
    String getAccountById(@PathVariable Long id) {
        return service.getAccountById(id);
    }

    @PostMapping("/account")
    void createAccount(@RequestBody String payload) {
        service.createAccount(payload);
    }

    @PutMapping("/account/{id}")
    void changeAccount(@PathVariable Long id, @RequestBody String payload) {
        service.updateAccount(id, payload);
    }

    @DeleteMapping("/account/{id}")
    void deleteAccount(@PathVariable Long id) {
        service.deleteAccount(id);
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
