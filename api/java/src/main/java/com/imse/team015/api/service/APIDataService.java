package com.imse.team015.api.service;


import com.imse.team015.api.dao.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class APIDataService {
    private final DataRepository dataRepository;

    @Autowired
    public APIDataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }
}
