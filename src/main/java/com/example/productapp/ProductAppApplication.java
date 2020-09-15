package com.example.productapp;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductAppApplication {
	
	@Value("classpath:static/realm-export.json")
	static
	Resource resourceFile;

	public static void main(String[] args) {
		SpringApplication.run(ProductAppApplication.class, args);
		System.out.println(classpath());
	}
	
	public static String classpath() {
		return resourceFile.mappedName();
	}
}


