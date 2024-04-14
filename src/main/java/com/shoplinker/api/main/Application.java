package com.shoplinker.api.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.shoplinker.api.domain.entities")
@EnableJpaRepositories("com.shoplinker.api.infra.repositories")
@ComponentScan({"com.shoplinker.api.main", "com.shoplinker.api.infra"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
