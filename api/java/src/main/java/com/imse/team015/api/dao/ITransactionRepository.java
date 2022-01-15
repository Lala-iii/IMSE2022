package com.imse.team015.api.dao;

import com.imse.team015.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransactionRepository {
    boolean deleteTransaction(Long id);
    boolean createTransaction(Transaction transaction);
    boolean updateTransaction(Long id, Transaction transaction);
    String findTransaction(Long id);
    List<Transaction> findAll();
}
