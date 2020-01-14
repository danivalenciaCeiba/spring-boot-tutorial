package com.ceiba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ceiba.framework")
public class CeibaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CeibaApplication.class, args);
	}

}
