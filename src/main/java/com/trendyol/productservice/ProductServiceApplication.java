package com.trendyol.productservice;

import com.trendyol.productservice.entity.Product;
import com.trendyol.productservice.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductService productService) {
		return args -> {
			Product product = new Product("iPhone",1000.00,100L);
			productService.saveProduct(product);
			Product anotherProduct = new Product("jean", 100.5, 1000L);
			productService.saveProduct(anotherProduct);
		};
	}

}
