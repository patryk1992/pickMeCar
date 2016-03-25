package com.mgr.pickMeCar.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mgr.pickMeCar.db.model.User;
import com.mgr.pickMeCar.db.repository.UserRepository;

@RestController
public class RegisterController {
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "rest-api/register", method = RequestMethod.POST)
	public ResponseEntity<Void> login(@RequestBody User user) {
		System.out.println("Login User " + user.getName());
		System.out.println("Login User " + userRepository.findAll());
		User fuser = userRepository.findByName(user.getName()).size() > 0
				? userRepository.findByName(user.getName()).get(0) : null;

		if (fuser == null) {
			userRepository.save(user);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	

		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}
}
