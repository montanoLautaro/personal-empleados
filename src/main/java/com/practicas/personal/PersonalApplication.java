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
		ApplicationContext context = SpringApplication.run(PersonalApplication.class, args);
		PersonalServiceImp imp = context.getBean(PersonalServiceImp.class);

		Cuenta cuenta1 = new Cuenta();
		imp.guardarPersonal(new Personal(null,"admin","admin",cuenta1));


	}

}
