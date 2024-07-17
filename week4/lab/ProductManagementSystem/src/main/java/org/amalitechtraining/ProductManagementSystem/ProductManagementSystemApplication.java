package org.amalitechtraining.ProductManagementSystem;

import org.amalitechtraining.ProductManagementSystem.Models.Product;
import org.amalitechtraining.ProductManagementSystem.Repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ProductManagementSystemApplication {


	private static final Logger log =  LoggerFactory.getLogger(ProductManagementSystemApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(ProductManagementSystemApplication.class, args);
	}

}
