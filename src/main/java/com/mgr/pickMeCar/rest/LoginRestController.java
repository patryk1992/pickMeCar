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
public class LoginRestController {
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "rest-api/login", method = RequestMethod.POST)
	public ResponseEntity<Void> login(@RequestBody User user) {
		System.out.println("Login User " + user.getUserName());
		System.out.println("Login User " + userRepository.findAll());
		User fuser = userRepository.findByUserName(user.getUserName()).size() > 0
				? userRepository.findByUserName(user.getUserName()).get(0) : null;

		if (fuser != null) {
			if(fuser.getPassword().equals(user.getPassword())){
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
		}

		// UserCarDAO.saveUser(user);

		return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
	}
}
