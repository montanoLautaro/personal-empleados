package com.practicas.personal;

import com.practicas.personal.models.Personal;
import com.practicas.personal.repositories.PersonalRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PersonalApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PersonalApplication.class, args);
		PersonalRepository personalRepository = context.getBean(PersonalRepository.class);
		personalRepository.save(new Personal("El", "Pez", "qwerty", "123", "admin"));
	}

}
