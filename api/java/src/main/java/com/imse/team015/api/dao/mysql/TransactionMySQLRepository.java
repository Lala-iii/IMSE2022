package com.imse.team015.api.dao.mysql;

import com.google.gson.Gson;
import com.imse.team015.api.dao.ITransactionRepository;
import com.imse.team015.api.dao.MYSQLUtils;
import com.imse.team015.model.Transaction;
import com.mysql.cj.protocol.Resultset;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    public String findTransaction(Long id) {
        String query = "SELECT * FROM transaction WHERE id = " + id + ";";
        ResultSet resultSet = MYSQLUtils.executeQuery(query);
        try {
            if (!resultSet.next())
                return null;
            else {
                Transaction t = new Transaction();
                t.setId(resultSet.getLong("sender_account"));
                t.setReceiver_account(resultSet.getLong("receiver_account"));
                t.setTransaction_type(resultSet.getString("transaction_type"));
                t.setExpense_type(resultSet.getString("expense_type"));
                t.setDate_of_occurrence(resultSet.getDate("date_of_occurrence"));
                t.setPayment_reference(resultSet.getString("payment_reference"));
                t.setAmount(resultSet.getDouble("amount"));

                Gson gson = new Gson();

                return gson.toJson(t);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Transaction> findAll() {
        return null;
    }
}
