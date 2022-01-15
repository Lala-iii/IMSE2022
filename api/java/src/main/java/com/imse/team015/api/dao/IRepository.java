package com.imse.team015.api.dao;

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
    void createAccount(Transaction transaction);
    void updateAccount(Long id, Transaction transaction);
    String findAccount(Long id);
    String findAllAccounts();

    void deleteCustomer(Long id);
    void createCustomer(Transaction transaction);
    void updateCustomer(Long id, Transaction transaction);
    String findCustomer(Long id);
    String findAllCustomers();

    void deleteEmployee(Long id);
    void createEmployee(Transaction transaction);
    void updateEmployee(Long id, Transaction transaction);
    String findEmployee(Long id);
    String findAllEmployees();
}
