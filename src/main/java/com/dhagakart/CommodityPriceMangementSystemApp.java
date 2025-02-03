package com.dhagakart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class CommodityPriceMangementSystemApp {

	public static void main(String[] args) {
		SpringApplication.run(CommodityPriceMangementSystemApp.class, args);
	}

}
