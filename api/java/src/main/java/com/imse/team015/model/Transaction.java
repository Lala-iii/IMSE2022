package com.imse.team015.model;

import com.imse.team015.api.dao.MySQLUtils;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Transaction implements DataGenerator{

    @Id
    //@GeneratedValue
    private Long id;

    //private Long sender_account;
    //private Long receiver_account;
    private Long sender_account;
    private Long receiver_account;
    private String transaction_type;
    private String expense_type;
    //private Date date_of_occurrence;
    private String date_of_occurrence;
    private String payment_reference;
    private Double amount;


    @Override
    public void generateData() {
        String[] accounts = new String[] {"AT67 7788 9999 0001 2011", "AT56 5056 7784 8253 2013",
                "AT56 5056 7253 5553 2012", "AT66 5056 3735 3324 2119", "AT16 4433 6253 9834 2202",
                "AT11 7354 8454 2312 1113","AT44 5056 7784 3984 2399",
                "AT13 7465 8365 1211 9375","AT56 6456 7357 2314 8736",
                "AT86 5056 7784 8253 2013","AT56 2256 9577 5553 2846"};
        String[] transactiontypes = new String[]{"Manual Transaction","SCAN Transaction","Automatic Transaction","Urgent Tranction"};
        String[] expensetypes = new String[]{"Groceries","Shopping","Debit","Online Banking Payment"};
        String[] date = new String[] {"12-3-21", "15-10-20", "18-10-20", "4-4-21", "24-1-21",
                "12-5-21","11-7-17", "3-5-10","4-8-9","10-5-16","8-9-9","1-10-19","7-6-05","17-4-14","11-6-12"};
        String[] paymentReference = new String[]{"1414323767","2362323428","1876252336",
                "2816352221","7132456552","5423137325","219372422","2342144323","2413253532",
                "3321423533","1761235426","2974823467","9235465355","8262524223"};
        Double[] amounts = new Double[]{345.67,847.12,3948.12,4390.56,948.45,9387.67,
                4975.5,2984.90,987.35,65123.78,90.45,34.23,847.06,2675.09,1334.67,
                214.56,114.56,3456.78,321.90,823.45,298.67,2948.45,890.12,234.56,9654.12,746.01,
                921.34,921.32,892.34,9104.67,204.33,112.34,321.45,2234.56,224.11,1207.89,216.31,121.11};

        ArrayList<Integer> customers = new ArrayList<>();

        String query = "SELECT DISTINCT id FROM account;";
        try (Connection conn = DriverManager.getConnection(MySQLUtils.url, MySQLUtils.username, MySQLUtils.password);
             Statement statement = conn.createStatement();) {

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                customers.add(resultSet.getInt("id"));
            }
        } catch (SQLException e) {

        }

        for(int i=0; i<100;i++){
            String RANDOM_ACCOUNT_QUERY = "INSERT INTO transaction(sender_account, receiver_account, transaction_type, expense_type, date_of_occurrence, payment_reference, amount) " +
                    "VALUES ("
                    + customers.get(ThreadLocalRandom.current().nextInt(0, customers.size())) +
                    ", " + customers.get(ThreadLocalRandom.current().nextInt(0, customers.size())) +
                    " ,'" + transactiontypes[ThreadLocalRandom.current().nextInt(0, transactiontypes.length)] +
                    "', '" + expensetypes[ThreadLocalRandom.current().nextInt(0, expensetypes.length)] +
                    "', '" + date[ThreadLocalRandom.current().nextInt(0, date.length)] +
                    "', '" + paymentReference[ThreadLocalRandom.current().nextInt(0, paymentReference.length)] +
                    "', " + amounts[ThreadLocalRandom.current().nextInt(0, amounts.length)] + ")" ;
            System.out.println(RANDOM_ACCOUNT_QUERY);
            MySQLUtils.executeUpdate(RANDOM_ACCOUNT_QUERY);

        }
    }

    @Override
    public void createTable() {
        String CREATE_TRANSACTION_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS transaction(id INT PRIMARY KEY AUTO_INCREMENT," +
                "sender_account INT, receiver_account INT, transaction_type VARCHAR(100), " +
                "expense_type VARCHAR(100), date_of_occurrence VARCHAR(100), payment_reference VARCHAR(100), amount DOUBLE(10,2), " +
                "CONSTRAINT fk_sender FOREIGN KEY(sender_account) REFERENCES account(id), "+
                "CONSTRAINT fk_receiver FOREIGN KEY(receiver_account) REFERENCES account(id));";
        MySQLUtils.executeUpdate(CREATE_TRANSACTION_TABLE_QUERY);
    }

    @Override
    public void dropTable() {
        String DROP_TRANSACTION_IF_EXISTS_QUERY = "DROP TABLE IF EXISTS transaction;";
        MySQLUtils.executeUpdate(DROP_TRANSACTION_IF_EXISTS_QUERY);

    }
}
