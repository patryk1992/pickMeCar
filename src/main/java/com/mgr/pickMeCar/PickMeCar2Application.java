package com.mgr.pickMeCar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "com.mgr.pickMeCar.db.configuration" })
@SpringBootApplication

public class PickMeCar2Application {

	public static void main(String[] args) {
		SpringApplication.run(PickMeCar2Application.class, args);
	}
}
