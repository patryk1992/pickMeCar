package com.mgr.pickMeCar.db.configuration;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.mgr.pickMeCar.db.model.Car;

import com.mgr.pickMeCar.db.model.Groups;
import com.mgr.pickMeCar.db.model.Mark;

import com.mgr.pickMeCar.db.model.Track;
import com.mgr.pickMeCar.db.model.UserCar;
import com.mgr.pickMeCar.db.model.UserGroup;
import com.mgr.pickMeCar.db.model.UserTrack;



@Configuration
@ComponentScan({ "com.mgr.pickMeCar" })
@EntityScan({ "com.mgr.pickMeCar.db.model" })
@EnableJpaRepositories({ "com.mgr.pickMeCar.db.repository" })
public class CustomizedRestMvcConfiguration extends RepositoryRestMvcConfiguration {

	@Override
	protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.setBasePath("/rest-api");
		config.setReturnBodyOnCreate(true);
		config.exposeIdsFor(Car.class,  Groups.class, Mark.class, 
				Track.class, com.mgr.pickMeCar.db.model.User.class, UserCar.class, UserGroup.class,
				UserTrack.class);
	}

}
