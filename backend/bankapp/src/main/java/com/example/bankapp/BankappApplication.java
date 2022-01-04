package com.example.bankapp;

import com.example.bankapp.model.Customer;
import com.example.bankapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BankappApplication.class, args);
		System.out.println("hsgdysdbs");
	}
	@Autowired
	CustomerRepository customerRepository;


	@Override
	public void run(String... args) throws Exception {
          System.out.println("lsdjakidybdbbbbbbbbb");
		Customer customer1 =  Customer.builder()
				.firstName("Tim")
				.lastName("Cook")
				.address("Baker Street 45")
				.dateOfBirth("17.11.1965")
				.email("apple@info.com")
				.build();

		Customer customer2 =  Customer.builder()
				.firstName("Arvind")
				.lastName("Krishna")
				.address("Willington street 67")
				.dateOfBirth("09.07.1974")
				.email("ibm@info.com")
				.build();

		customerRepository.save(customer1);
		customerRepository.save(customer2);

	}
}
