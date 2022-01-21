package com.imse.team015.api.dao.mongo;

import com.google.gson.Gson;
import com.imse.team015.api.dao.IRepository;
import com.imse.team015.model.Account;
import com.imse.team015.model.Customer;
import com.imse.team015.model.Transaction;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class MongoRepository implements IRepository {
    private final String connString = "mongodb://admin:admin@mongo";

    private static long customerID = 1;
    private static long accountID = 1;
    private static long transactionID = 1;

    public static void setCustomerID(long id) {
        customerID = id;
    }

    public static void setAccountID(long id) {
        accountID = id;
    }

    public static void setTransactionID(long id) {
        transactionID = id;
    }



    public void migrateTransaction(Transaction t) {
        MongoClient mongoClient = MongoClients.create(connString);
        MongoDatabase database = mongoClient.getDatabase("bankapp");
        MongoCollection<Document> transactionCollection = database.getCollection("transaction");

        Document doc = new Document("_id", new ObjectId())
                .append("id", t.getId())
                .append("sender_account", t.getSender_account())
                .append("receiver_account", t.getReceiver_account())
                .append("transaction_type", t.getTransaction_type())
                .append("expense_type", t.getExpense_type())
                .append("date_of_occurrence", t.getDate_of_occurrence())
                .append("payment_reference", t.getPayment_reference())
                .append("amount", t.getAmount());

        transactionCollection.insertOne(doc);
    }

    public void migrateAccount(Account a) {
        MongoClient mongoClient = MongoClients.create(connString);
        MongoDatabase database = mongoClient.getDatabase("bankapp");
        MongoCollection<Document> accountCollection = database.getCollection("account");

        Document doc = new Document("_id", new ObjectId())
                .append("id", a.getId())
                .append("account_type", a.getAccount_type())
                .append("date_of_creation", a.getDate_of_creation())
                .append("iban", a.getIban())
                .append("bic", a.getBic())
                .append("balance", a.getBalance())
                .append("currency", a.getCurrency())
                .append("owner", a.getOwner());

        accountCollection.insertOne(doc);
    }

    public void migrateCustomer(Customer c) {
        MongoClient mongoClient = MongoClients.create(connString);
        MongoDatabase database = mongoClient.getDatabase("bankapp");
        MongoCollection<Document> customersCollection = database.getCollection("customer");

        Document doc = new Document("_id", new ObjectId())
                .append("id", c.getId())
                .append("firstname", c.getFirstname())
                .append("lastname", c.getLastname())
                .append("gender", c.getGender())
                .append("svnr", c.getSvnr())
                .append("date_of_birth", c.getDate_of_birth())
                .append("address", c.getAddress());

        customersCollection.insertOne(doc);
    }


    @Override
    public void deleteTransaction(Long id) {
        MongoClient mongoClient = MongoClients.create(connString);
        MongoDatabase database = mongoClient.getDatabase("bankapp");
        MongoCollection<Document> transactionCollection = database.getCollection("transaction");

        transactionCollection.deleteOne(Filters.eq("id", id));
    }

    @Override
    public void createTransaction(Transaction t) {
        MongoClient mongoClient = MongoClients.create(connString);
        MongoDatabase database = mongoClient.getDatabase("bankapp");
        MongoCollection<Document> transactionCollection = database.getCollection("transaction");

        Document doc = new Document("_id", new ObjectId())
                .append("id", transactionID)
                .append("sender_account", t.getSender_account())
                .append("receiver_account", t.getReceiver_account())
                .append("transaction_type", t.getTransaction_type())
                .append("expense_type", t.getExpense_type())
                .append("date_of_occurrence", t.getDate_of_occurrence())
                .append("payment_reference", t.getPayment_reference())
                .append("amount", t.getAmount());

        transactionCollection.insertOne(doc);
        transactionID++;
    }

    @Override
    public void updateTransaction(Long id, Transaction t) {
        MongoClient mongoClient = MongoClients.create(connString);
        MongoDatabase database = mongoClient.getDatabase("bankapp");
        MongoCollection<Document> transactionCollection = database.getCollection("transaction");

        Document doc = new Document("_id", new ObjectId())
                .append("id", id)
                .append("sender_account", t.getSender_account())
                .append("receiver_account", t.getReceiver_account())
                .append("transaction_type", t.getTransaction_type())
                .append("expense_type", t.getExpense_type())
                .append("date_of_occurrence", t.getDate_of_occurrence())
                .append("payment_reference", t.getPayment_reference())
                .append("amount", t.getAmount());


        transactionCollection.deleteOne(Filters.eq("id", id));
        transactionCollection.insertOne(doc);


        //transactionCollection.updateOne(Filters.eq("id", id), new Document("$set", doc);
    }

    @Override
    public String findTransaction(Long id) {
        MongoClient mongoClient = MongoClients.create(connString);
        MongoDatabase database = mongoClient.getDatabase("bankapp");
        MongoCollection<Document> transactionsCollection = database.getCollection("transaction");


        Document doc = transactionsCollection.find(Filters.eq("id", id)).first();

        Transaction t = null;
        if (doc != null) {
            t = new Transaction((Long) doc.get("id"),
                    (Long) doc.get("sender_account"),
                    (Long) doc.get("receiver_account"),
                    (String) doc.get("transaction_type"),
                    (String) doc.get("expense_type"),
                    (String) doc.get("date_of_occurrence"),
                    (String)doc.get("payment_reference"),
                    (Double) doc.get("amount"));
        }

        return new Gson().toJson(t);
    }

    @Override
    public String findAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        MongoClient mongoClient = MongoClients.create(connString);
        MongoDatabase database = mongoClient.getDatabase("bankapp");
        MongoCollection<Document> transactionsCollection = database.getCollection("transaction");

        FindIterable<Document> list = transactionsCollection.find();

        for (Document doc : list) {
            Transaction t = new Transaction((Long) doc.get("id"),
                    (Long) doc.get("sender_account"),
                    (Long) doc.get("receiver_account"),
                    (String) doc.get("transaction_type"),
                    (String) doc.get("expense_type"),
                    (String) doc.get("date_of_occurrence"),
                    (String)doc.get("payment_reference"),
                    (Double) doc.get("amount"));
            transactions.add(t);
        }


        return new Gson().toJson(transactions);
    }

    @Override
    public void deleteAccount(Long id) {
        MongoClient mongoClient = MongoClients.create(connString);
        MongoDatabase database = mongoClient.getDatabase("bankapp");
        MongoCollection<Document> accountCollection = database.getCollection("account");

        accountCollection.deleteOne(Filters.eq("id", id));
    }

    @Override
    public void createAccount(Account a) {
        MongoClient mongoClient = MongoClients.create(connString);
        MongoDatabase database = mongoClient.getDatabase("bankapp");
        MongoCollection<Document> accountCollection = database.getCollection("account");

        Document doc = new Document("_id", new ObjectId())
                .append("id", accountID)
                .append("account_type", a.getAccount_type())
                .append("date_of_creation", a.getDate_of_creation())
                .append("iban", a.getIban())
                .append("bic", a.getBic())
                .append("balance", a.getBalance())
                .append("currency", a.getCurrency())
                .append("owner", a.getOwner());

        accountCollection.insertOne(doc);
        accountID++;
    }

    @Override
    public void updateAccount(Long id, Account a) {
        MongoClient mongoClient = MongoClients.create(connString);
        MongoDatabase database = mongoClient.getDatabase("bankapp");
        MongoCollection<Document> accountCollection = database.getCollection("account");

        Document doc = new Document("_id", new ObjectId())
                .append("id", a.getId())
                .append("account_type", a.getAccount_type())
                .append("date_of_creation", a.getDate_of_creation())
                .append("iban", a.getIban())
                .append("bic", a.getBic())
                .append("balance", a.getBalance())
                .append("currency", a.getCurrency())
                .append("owner", a.getOwner());

        accountCollection.updateOne(Filters.eq("id", id), doc);
    }

    @Override
    public String findAccount(Long id) {
        MongoClient mongoClient = MongoClients.create(connString);
        MongoDatabase database = mongoClient.getDatabase("bankapp");
        MongoCollection<Document> accountCollection = database.getCollection("account");

        Document doc = accountCollection.find(Filters.eq("id", id)).first();

        Account a = null;
        if (doc != null) {
            a = new Account((Long) doc.get("id"),
                    (String) doc.get("account_type"),
                    (String) doc.get("date_of_creation"),
                    (String) doc.get("iban"),
                    (String) doc.get("bic"),
                    (double) doc.get("balance"),
                    (String)doc.get("currency"),
                    (Long) doc.get("owner"));
        }

        return new Gson().toJson(a);
    }

    @Override
    public String findAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        MongoClient mongoClient = MongoClients.create(connString);
        MongoDatabase database = mongoClient.getDatabase("bankapp");
        MongoCollection<Document> accountCollection = database.getCollection("account");

        FindIterable<Document> list = accountCollection.find();

        for (Document doc : list) {
            Account a = new Account((Long) doc.get("id"),
                    (String) doc.get("account_type"),
                    (String) doc.get("date_of_creation"),
                    (String) doc.get("iban"),
                    (String) doc.get("bic"),
                    (double) doc.get("balance"),
                    (String)doc.get("currency"),
                    (Long) doc.get("owner"));
            accounts.add(a);
        }


        return new Gson().toJson(accounts);
    }

    @Override
    public void deleteCustomer(Long id) {
        MongoClient mongoClient = MongoClients.create(connString);
        MongoDatabase database = mongoClient.getDatabase("bankapp");
        MongoCollection<Document> customersCollection = database.getCollection("customer");

        customersCollection.deleteOne(Filters.eq("id", id));
    }

    @Override
    public void createCustomer(Customer c) {
        MongoClient mongoClient = MongoClients.create(connString);
        MongoDatabase database = mongoClient.getDatabase("bankapp");
        MongoCollection<Document> customersCollection = database.getCollection("customer");

        Document doc = new Document("_id", new ObjectId())
                .append("id", customerID)
                .append("firstname", c.getFirstname())
                .append("lastname", c.getLastname())
                .append("gender", c.getGender())
                .append("svnr", c.getSvnr())
                .append("date_of_birth", c.getDate_of_birth())
                .append("address", c.getAddress());

        customersCollection.insertOne(doc);
        customerID++;
    }

    @Override
    public void updateCustomer(Long id, Customer c) {
        MongoClient mongoClient = MongoClients.create(connString);
        MongoDatabase database = mongoClient.getDatabase("bankapp");
        MongoCollection<Document> customersCollection = database.getCollection("customer");

        Document doc = new Document("_id", new ObjectId())
                .append("id", c.getId())
                .append("firstname", c.getFirstname())
                .append("lastname", c.getLastname())
                .append("gender", c.getGender())
                .append("svnr", c.getSvnr())
                .append("date_of_birth", c.getDate_of_birth())
                .append("address", c.getAddress());

        customersCollection.updateOne(Filters.eq("id", id), doc);
    }

    @Override
    public String findCustomer(Long id) {
        MongoClient mongoClient = MongoClients.create(connString);
        MongoDatabase database = mongoClient.getDatabase("bankapp");
        MongoCollection<Document> customersCollection = database.getCollection("customer");

        Document doc = customersCollection.find(Filters.eq("id", id)).first();

        Customer c = null;
        if (doc != null) {
            c = new Customer((Long) doc.get("id"),
                    (String) doc.get("firstname"),
                    (String) doc.get("lastname"),
                    (String) doc.get("gender"),
                    (int) doc.get("svnr"),
                    (String) doc.get("date_of_birth"),
                    (String)doc.get("address"));
        }

        return new Gson().toJson(c);
    }

    @Override
    public String findAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        MongoClient mongoClient = MongoClients.create(connString);
        MongoDatabase database = mongoClient.getDatabase("bankapp");
        MongoCollection<Document> customersCollection = database.getCollection("customer");

        FindIterable<Document> list = customersCollection.find();

        for (Document doc : list) {
            Customer customer = new Customer();
            customer.setId((Long) doc.get("id"));
            customer.setFirstname((String) doc.get("firstname"));
            customer.setLastname((String) doc.get("lastname"));
            customer.setGender((String) doc.get("gender"));
            customer.setSvnr((Integer) doc.get("svnr"));
            customer.setDate_of_birth((String) doc.get("date_of_birth"));
            customer.setAddress((String) doc.get("address"));
            customers.add(customer);
        }


        return new Gson().toJson(customers);
    }
}
