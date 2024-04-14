package com.shoplinker.api;

import com.shoplinker.api.main.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestShopLinkerApplication {

	public static void main(String[] args) {
		SpringApplication.from(Application::main).with(TestShopLinkerApplication.class).run(args);
	}

}
