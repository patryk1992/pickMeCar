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

import com.mgr.pickMeCar.db.dao.TokenDAO;
import com.mgr.pickMeCar.db.dao.UserDAO;
import com.mgr.pickMeCar.db.model.User;

@RestController
public class LoginController {
//	@Autowired
//	private UserDAO userDao;
//	 @RequestMapping(value = "/rest-api/login",method = RequestMethod.POST)
//	    public ResponseEntity<Void> login(@RequestBody User user) {
//	        System.out.println("Login User " + user.getName());
//	 
////	        if (UserCarDAO.isUserExist(user)) {
////	            System.out.println("A User with name " + user.getName() + " already exist");
////	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
////	        }
////	 
////	        UserCarDAO.saveUser(user);
////	 
//	       
//	        return new ResponseEntity<Void>( HttpStatus.CREATED);
//	    }
}
