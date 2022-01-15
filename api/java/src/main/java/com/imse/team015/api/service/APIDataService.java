package com.imse.team015.api.service;


import com.google.gson.Gson;
import com.imse.team015.api.dao.IRepository;
import com.imse.team015.api.dao.mongo.MongoRepository;
import com.imse.team015.api.dao.mysql.MySQLRepository;
import com.imse.team015.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class APIDataService {
    private IRepository iRepository;

    @Autowired
    public APIDataService(IRepository iRepository) {
        this.iRepository = new MySQLRepository();
    }

    public void switchToMongo(boolean active) {
        if (active)
            iRepository = new MongoRepository();
        else
            iRepository = new MySQLRepository();
    }

    public String getTransactions() {
        return iRepository.findAllTransactions();
    }

    public String getTransactionById(Long id) {
        return iRepository.findTransaction(id);
    }

    public void createTransaction(String payload) {
        Gson gson = new Gson();
        Transaction t = gson.fromJson(payload, Transaction.class);

        iRepository.createTransaction(t);
    }
}
