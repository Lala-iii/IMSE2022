package com.imse.team015.api.service;


import com.google.gson.Gson;
import com.imse.team015.api.dao.IRepository;
import com.imse.team015.api.dao.mongo.MongoRepository;
import com.imse.team015.api.dao.mysql.MySQLRepository;
import com.imse.team015.model.Account;
import com.imse.team015.model.Customer;
import com.imse.team015.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class APIDataService {
    private IRepository iRepository;

    @Autowired
    public APIDataService(IRepository iRepository) {
        this.iRepository = new MySQLRepository();
    }

    public void switchToMongo(boolean active) {
        if (active)
            iRepository = new MongoRepository();
        else
            iRepository = new MySQLRepository();
    }

    public String getTransactions() {
        return iRepository.findAllTransactions();
    }

    public String getTransactionById(Long id) {
        return iRepository.findTransaction(id);
    }

    public void createTransaction(String payload) {
        Gson gson = new Gson();
        Transaction t = gson.fromJson(payload, Transaction.class);

        iRepository.createTransaction(t);
    }

    public void updateTransaction(Long id, String payload) {
        Gson gson = new Gson();
        Transaction t = gson.fromJson(payload, Transaction.class);
        iRepository.updateTransaction(id, t);
    }

    public void deleteTransaction(Long id) {
        iRepository.deleteTransaction(id);
    }

    public String getCustomers() { return iRepository.findAllCustomers(); }

    public String getCustomerById(Long id) { return iRepository.findCustomer(id); }

    public void createCustomer(String payload) {
        Gson gson = new Gson();
        Customer c = gson.fromJson(payload, Customer.class);
        iRepository.createCustomer(c);
    }

    public void updateCustomer(Long id, String payload) {
        Gson gson = new Gson();
        Customer c = gson.fromJson(payload, Customer.class);
        iRepository.createCustomer(c);
    }

    public void deleteCustomer(Long id) {
        iRepository.deleteCustomer(id);
    }

    public String getAccounts() { return iRepository.findAllAccounts(); }

    public String getAccountById(Long id) { return iRepository.findAccount(id); }

    public void createAccount(String payload) {
        Gson gson = new Gson();
        Account a = gson.fromJson(payload, Account.class);
        iRepository.createAccount(a);
    }

    public void updateAccount(Long id, String payload) {
        Gson gson = new Gson();
        Account a = gson.fromJson(payload, Account.class);
        iRepository.createAccount(a);
    }

    public void deleteAccount(Long id) {
        iRepository.deleteAccount(id);
    }

}
