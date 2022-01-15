package com.imse.team015;

import com.imse.team015.api.service.APIDataService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class APIServiceApplication {
private final APIDataService dataService;

    public static void main(String[] args) {
        SpringApplication.run(APIServiceApplication.class, args);
    }

    public APIServiceApplication(APIDataService dataService) {
        this.dataService = dataService;
    }
}
