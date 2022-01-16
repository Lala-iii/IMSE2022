package com.imse.team015.api.dao.mongo;

import com.imse.team015.api.dao.IRepository;
import com.imse.team015.model.Account;
import com.imse.team015.model.Customer;
import com.imse.team015.model.Transaction;

public class MongoRepository implements IRepository {
    @Override
    public void deleteTransaction(Long id) {

    }

    @Override
    public void createTransaction(Transaction t) {

    }

    @Override
    public void updateTransaction(Long id, Transaction t) {

    }

    @Override
    public String findTransaction(Long id) {
        return null;
    }

    @Override
    public String findAllTransactions() {
        return null;
    }

    @Override
    public void deleteAccount(Long id) {

    }

    @Override
    public void createAccount(Account a) {

    }

    @Override
    public void updateAccount(Long id, Account a) {

    }

    @Override
    public String findAccount(Long id) {
        return null;
    }

    @Override
    public String findAllAccounts() {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {

    }

    @Override
    public void createCustomer(Customer c) {

    }

    @Override
    public void updateCustomer(Long id, Customer c) {

    }

    @Override
    public String findCustomer(Long id) {
        return null;
    }

    @Override
    public String findAllCustomers() {
        return null;
    }
}
