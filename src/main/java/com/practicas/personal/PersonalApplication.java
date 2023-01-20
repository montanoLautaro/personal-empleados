package com.practicas.personal;

import com.practicas.personal.models.Cuenta;
import com.practicas.personal.models.Personal;
import com.practicas.personal.services.PersonalServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PersonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalApplication.class, args);
	}

}
