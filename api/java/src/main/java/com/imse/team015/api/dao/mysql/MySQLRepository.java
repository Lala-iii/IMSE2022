package com.imse.team015.api.dao.mysql;

import com.google.gson.Gson;
import com.imse.team015.api.dao.IRepository;
import com.imse.team015.api.dao.MySQLUtils;
import com.imse.team015.model.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLRepository implements IRepository {
    public void deleteTransaction(Long id) {
        String query = "DELETE FROM transaction WHERE id = " + id + ";";
        MySQLUtils.executeQuery(query);

    }

    public void createTransaction(Transaction t) {
        String query = "INSERT INTO transaction (sender_account, receiver_account, transaction_type, expense_type, date_of_occurrence, payment_reference, amount)" +
                " VALUES (" + t.getSender_account() +", "+ t.getReceiver_account() +", "+ t.getTransaction_type() +", "+ t.getExpense_type() +", "+ t.getDate_of_occurrence() +", " +
                t.getPayment_reference() +", "+ t.getAmount() +");";
        MySQLUtils.ExecuteUpdate(query);

    }

    public void updateTransaction(Long id, Transaction t) {
        String query = "UPDATE transaction " +
                "SET sender_account = " + t.getSender_account() + ", receiver_account = " + t.getReceiver_account() +
                ", transaction_type = " + t.getTransaction_type() + ", expense_type = ," + t.getExpense_type() +
                ", date_of_occurrence = " + t.getDate_of_occurrence() + ", payment_reference = " + t.getPayment_reference() +
                ", amount = "  + t.getTransaction_type() +
                " WHERE id = " + id + ";";
        MySQLUtils.ExecuteUpdate(query);
    }

    public String findTransaction(Long id) {
        String query = "SELECT * FROM transaction WHERE id = " + id + ";";
        ResultSet resultSet = MySQLUtils.executeQuery(query);
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

    public String findAllTransactions() {
        String query = "SELECT * FROM transaction;";
        ArrayList<Transaction> transactions = new ArrayList<>();
        ResultSet resultSet = MySQLUtils.executeQuery(query);
        try {
            if (!resultSet.next())
                return null;
            do {
                Transaction t = new Transaction();
                t.setId(resultSet.getLong("sender_account"));
                t.setReceiver_account(resultSet.getLong("receiver_account"));
                t.setTransaction_type(resultSet.getString("transaction_type"));
                t.setExpense_type(resultSet.getString("expense_type"));
                t.setDate_of_occurrence(resultSet.getDate("date_of_occurrence"));
                t.setPayment_reference(resultSet.getString("payment_reference"));
                t.setAmount(resultSet.getDouble("amount"));
                transactions.add(t);
            } while (resultSet.next());
            Gson gson = new Gson();
            return gson.toJson(transactions);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteAccount(Long id) {

    }

    @Override
    public void createAccount(Transaction transaction) {

    }

    @Override
    public void updateAccount(Long id, Transaction transaction) {

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
    public void createCustomer(Transaction transaction) {

    }

    @Override
    public void updateCustomer(Long id, Transaction transaction) {

    }

    @Override
    public String findCustomer(Long id) {
        return null;
    }

    @Override
    public String findAllCustomers() {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {

    }

    @Override
    public void createEmployee(Transaction transaction) {

    }

    @Override
    public void updateEmployee(Long id, Transaction transaction) {

    }

    @Override
    public String findEmployee(Long id) {
        return null;
    }

    @Override
    public String findAllEmployees() {
        return null;
    }
}
