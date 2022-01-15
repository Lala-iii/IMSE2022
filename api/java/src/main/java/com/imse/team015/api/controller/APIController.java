package com.imse.team015.api.controller;


import com.imse.team015.api.service.APIDataService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class APIController {

    private final APIDataService service;

    public APIController(APIDataService service) {
        this.service = service;
    }
}
