package com.collectionart.app.collectionart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CollectionArtApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollectionArtApplication.class, args);
	}

}
