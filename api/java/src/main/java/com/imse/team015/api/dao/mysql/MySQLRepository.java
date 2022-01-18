package com.imse.team015.api.dao.mysql;

import com.google.gson.Gson;
import com.imse.team015.api.dao.IRepository;
import com.imse.team015.api.dao.MySQLUtils;
import com.imse.team015.model.Account;
import com.imse.team015.model.Customer;
import com.imse.team015.model.Transaction;

import java.sql.*;
import java.util.ArrayList;

public class MySQLRepository implements IRepository {
    private static final String base_url = "jdbc:mysql://localhost:3306/";
    private static final String url = base_url + "bankapp";
    private static final String username = "admin";
    private static final String password = "admin";


    public void deleteTransaction(Long id) {
        String query = "DELETE FROM transaction WHERE id = " + id + ";";
        MySQLUtils.executeUpdate(query);
    }

    public void createTransaction(Transaction t) {
        String query = "INSERT INTO transaction (sender_account, receiver_account, transaction_type, expense_type, date_of_occurrence, payment_reference, amount)" +
                " VALUES (" + t.getSender_account() + ", " + t.getReceiver_account() + ", '" + t.getTransaction_type() + "', '" +
                t.getExpense_type() + "', '" + t.getDate_of_occurrence() + "', '" + t.getPayment_reference() + "', " + t.getAmount() + ");";
        MySQLUtils.executeUpdate(query);
    }

    public void updateTransaction(Long id, Transaction t) {
        String query = "UPDATE transaction " +
                "SET sender_account = " + t.getSender_account() +
                ", receiver_account = " + t.getReceiver_account() +
                ", transaction_type = '" + t.getTransaction_type() +
                "', expense_type = '" + t.getExpense_type() +
                "', date_of_occurrence = '" + t.getDate_of_occurrence() +
                "', payment_reference = '" + t.getPayment_reference() +
                "', amount = " + t.getAmount() +
                " WHERE id = " + id + ";";
        MySQLUtils.executeUpdate(query);
    }

    public String findTransaction(Long id) {
        String query = "SELECT * FROM transaction WHERE id = " + id + ";";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement statement = conn.createStatement();) {

            ResultSet resultSet = statement.executeQuery(query);
            if (!resultSet.next())
                return null;
            else {
                Transaction t = fillTransaction(resultSet);

                Gson gson = new Gson();

                return gson.toJson(t);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Transaction fillTransaction(ResultSet resultSet) throws SQLException {
        Transaction t = new Transaction();
        t.setId(resultSet.getLong("id"));
        t.setSender_account(resultSet.getLong("sender_account"));
        t.setReceiver_account(resultSet.getLong("receiver_account"));
        t.setTransaction_type(resultSet.getString("transaction_type"));
        t.setExpense_type(resultSet.getString("expense_type"));
        t.setDate_of_occurrence(resultSet.getString("date_of_occurrence"));
        t.setPayment_reference(resultSet.getString("payment_reference"));
        t.setAmount(resultSet.getDouble("amount"));
        return t;
    }

    public String findAllTransactions() {
        String query = "SELECT * FROM transaction;";
        ArrayList<Transaction> transactions = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement statement = conn.createStatement();) {

            ResultSet resultSet = statement.executeQuery(query);
            if (!resultSet.next())
                return null;
            do {

                transactions.add(fillTransaction(resultSet));
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
        String query = "DELETE FROM account WHERE id = " + id + ";";
        MySQLUtils.executeUpdate(query);
    }

    @Override
    public void createAccount(Account a) {
        String query = "INSERT INTO account (owner, account_type, date_of_creation, iban, bic, balance, currency)" +
                " VALUES (" + a.getOwner() + ", '" + a.getAccount_type() + "', '" + a.getDate_of_creation() + "', '" +
                a.getIban() + "', '" + a.getBic() + "', " + a.getBalance() + ", '" + a.getCurrency() + "');";
        MySQLUtils.executeUpdate(query);
    }

    @Override
    public void updateAccount(Long id, Account a) {
        String query = "UPDATE account " +
                "SET owner = " + a.getOwner() +
                ", account_type = '" + a.getAccount_type() +
                "', date_of_creation = '" + a.getDate_of_creation() +
                "', iban = '" + a.getIban() +
                "', bic = '" + a.getBic() +
                "', balance = " + a.getBalance() +
                ", currency = '" + a.getCurrency() +
                "' WHERE id = " + id + ";";
        MySQLUtils.executeUpdate(query);
    }

    @Override
    public String findAccount(Long id) {
        String query = "SELECT * FROM account WHERE id = " + id + ";";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement statement = conn.createStatement();) {

            ResultSet resultSet = statement.executeQuery(query);
            if (!resultSet.next())
                return null;
            else {
                Account a = fillAccount(resultSet);

                Gson gson = new Gson();

                return gson.toJson(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Account fillAccount(ResultSet resultSet) throws SQLException {
        Account a = new Account();
        a.setId(resultSet.getLong("id"));
        a.setOwner(resultSet.getLong("owner"));
        a.setAccount_type(resultSet.getString("account_type"));
        a.setDate_of_creation(resultSet.getString("date_of_creation"));
        a.setIban(resultSet.getString("iban"));
        a.setBic(resultSet.getString("bic"));
        a.setBalance(resultSet.getDouble("balance"));
        a.setCurrency(resultSet.getString("currency"));
        return a;
    }

    @Override
    public String findAllAccounts() {
        String query = "SELECT * FROM account;";
        ArrayList<Account> accounts = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement statement = conn.createStatement();) {

            ResultSet resultSet = statement.executeQuery(query);
            if (!resultSet.next())
                return null;
            do {
                accounts.add(fillAccount(resultSet));
            } while (resultSet.next());
            Gson gson = new Gson();
            return gson.toJson(accounts);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {
        String query = "DELETE FROM account WHERE id = " + id + ";";
        MySQLUtils.executeUpdate(query);
    }

    @Override
    public void createCustomer(Customer c) {
        String query = "INSERT INTO customer (firstname, lastname, gender, svnr, date_of_birth, address)" +
                " VALUES ('" + c.getFirstname() + "', '" + c.getLastname() + "', '" + c.getGender() + "', " +
                c.getSvnr() + ", '" + c.getDate_of_birth() + "', '" + c.getAddress() + "');";
        MySQLUtils.executeUpdate(query);
    }

    @Override
    public void updateCustomer(Long id, Customer c) {
        String query = "UPDATE customer " +
                "SET firstname = '" + c.getFirstname() +
                "', lastname = '" + c.getLastname() +
                "', gender = '" + c.getGender() +
                "', svnr = " + c.getSvnr() +
                ", date_of_birth = '" + c.getDate_of_birth() +
                "', address = '" + c.getAddress() +
                "' WHERE id = " + id + ";";
        MySQLUtils.executeUpdate(query);
    }

    @Override
    public String findCustomer(Long id) {
        String query = "SELECT * FROM customer WHERE id = " + id + ";";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement statement = conn.createStatement();) {

            ResultSet resultSet = statement.executeQuery(query);
            if (!resultSet.next())
                return null;
            else {
                Customer c = fillCustomer(resultSet);


                Gson gson = new Gson();

                return gson.toJson(c);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Customer fillCustomer(ResultSet resultSet) throws SQLException {
        Customer c = new Customer();
        c.setId(resultSet.getLong("id"));
        c.setFirstname(resultSet.getString("firstname"));
        c.setLastname(resultSet.getString("lastname"));
        c.setGender(resultSet.getString("gender"));
        c.setSvnr(resultSet.getInt("svnr"));
        c.setDate_of_birth(resultSet.getString("date_of_birth"));
        c.setAddress(resultSet.getString("address"));
        return c;
    }

    @Override
    public String findAllCustomers() {
        String query = "SELECT * FROM customer;";
        ArrayList<Customer> customers = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement statement = conn.createStatement();) {

            ResultSet resultSet = statement.executeQuery(query);
            if (!resultSet.next())
                return null;
            do {
                customers.add(fillCustomer(resultSet));
            } while (resultSet.next());
            Gson gson = new Gson();
            return gson.toJson(customers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
