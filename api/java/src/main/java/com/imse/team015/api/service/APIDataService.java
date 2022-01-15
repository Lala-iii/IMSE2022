package com.imse.team015.api.service;


import com.imse.team015.api.dao.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class APIDataService {
    private final ITransactionRepository iRepository;

    @Autowired
    public APIDataService(ITransactionRepository iRepository) {
        this.iRepository = iRepository;
    }
}
