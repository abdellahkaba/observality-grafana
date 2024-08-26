package com.isi.observability_grafana;

import com.isi.observability_grafana.entities.Product;
import com.isi.observability_grafana.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ObservabilityGrafanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObservabilityGrafanaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args -> {
			productRepository.save(Product.builder().name("Computer").price(2000).build());
			productRepository.save(Product.builder().name("Smart Phone").price(1200).build());
			productRepository.save(Product.builder().name("Printer").price(300).build());
			productRepository.save(Product.builder().name("Iphone 15").price(4000).build());
			productRepository.save(Product.builder().name("Montre").price(250).build());
			productRepository.findAll().forEach(System.out::println);
		};
	}
}
