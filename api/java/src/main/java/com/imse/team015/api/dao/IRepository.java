package com.imse.team015.api.dao;

import com.imse.team015.model.Account;
import com.imse.team015.model.Customer;
import com.imse.team015.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepository {
    void deleteTransaction(Long id);
    void createTransaction(Transaction transaction);
    void updateTransaction(Long id, Transaction transaction);
    String findTransaction(Long id);
    String findAllTransactions();

    void deleteAccount(Long id);
    void createAccount(Account a);
    void updateAccount(Long id, Account a);
    String findAccount(Long id);
    String findAllAccounts();

    void deleteCustomer(Long id);
    void createCustomer(Customer c);
    void updateCustomer(Long id, Customer c);
    String findCustomer(Long id);
    String findAllCustomers();
}
