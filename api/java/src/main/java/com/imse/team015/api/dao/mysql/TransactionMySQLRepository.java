package com.imse.team015.api.dao.mysql;

import com.imse.team015.api.dao.ITransactionRepository;
import com.imse.team015.model.Transaction;

import java.util.List;

public class TransactionMySQLRepository implements ITransactionRepository {
    public boolean deleteTransaction(Long id) {
        return false;
    }

    public boolean createTransaction(Transaction transaction) {
        return false;
    }

    public boolean updateTransaction(Long id, Transaction transaction) {
        return false;
    }

    public Transaction findTransaction(Long id) {
        return null;
    }

    public List<Transaction> findAll() {
        return null;
    }
}
