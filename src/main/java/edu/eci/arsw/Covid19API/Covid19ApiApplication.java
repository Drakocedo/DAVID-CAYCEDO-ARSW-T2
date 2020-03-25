package edu.eci.arsw.Covid19API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.Covid19BackEnd"})
public class Covid19ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid19ApiApplication.class, args);
	}

}
