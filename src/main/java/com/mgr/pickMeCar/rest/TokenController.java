package com.mgr.pickMeCar.rest;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.util.UriComponentsBuilder;

import com.mgr.pickMeCar.HomeController;
import com.mgr.pickMeCar.db.dao.TokenDAO;
import com.mgr.pickMeCar.db.dao.GroupsDAO;
import com.mgr.pickMeCar.db.dao.GroupsDAOImpl;
import com.mgr.pickMeCar.db.dao.MarkDAO;
import com.mgr.pickMeCar.db.dao.TokenDAO;
import com.mgr.pickMeCar.db.dao.TrackDAO;
import com.mgr.pickMeCar.db.dao.UserCarDAO;
import com.mgr.pickMeCar.db.dao.UserDAO;
import com.mgr.pickMeCar.db.model.Token;
import com.mgr.pickMeCar.db.model.Groups;
import com.mgr.pickMeCar.db.model.Mark;
import com.mgr.pickMeCar.db.model.Token;
import com.mgr.pickMeCar.db.model.Track;
import com.mgr.pickMeCar.db.model.User;

@RestController
public class TokenController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private TokenDAO tokenDao;
	@Autowired
	private UserDAO userDao;
	 @RequestMapping(value = "/rest-api/token",method = RequestMethod.GET,produces = "application/json",headers="Accept=*/*")
	    public ResponseEntity <List<Token>> listToken() {
			
			List<Token> liToken =tokenDao.list();
			logger.info("Welcome list"+ liToken.toString());
			if(liToken.isEmpty()){
	            return new ResponseEntity<List<Token>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }

	        return new ResponseEntity <List<Token>>(liToken, HttpStatus.OK);
	 }
	 @RequestMapping(value = "/rest-api/token",method = RequestMethod.POST,produces = "application/json",headers="Accept=*/*")
	    public ResponseEntity<Void> createToken(@RequestBody Token token,    UriComponentsBuilder ucBuilder) {		 
	        if (token.getId()!=null && tokenDao.get(token.getId())!=null) {	           
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	        
	        tokenDao.saveOrUpdate(token);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/rest-api/token/{id}").buildAndExpand(token.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 @RequestMapping(value = "/rest-api/token/{id}",method = RequestMethod.DELETE,produces = "application/json",headers="Accept=*/*")
	    public ResponseEntity<Token> deleteToken(@PathVariable("id") int id) {
	        Token token = tokenDao.get(id);
	        if (token == null) {
	            
	            return new ResponseEntity<Token>(HttpStatus.NOT_FOUND);
	        }
	 
	        tokenDao.delete(id);
	        return new ResponseEntity<Token>(HttpStatus.NO_CONTENT);
	 }
	  @RequestMapping(value = "/rest-api/token/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Token> updateToken(@PathVariable("id") int id, @RequestBody Token token) {
		  Token currentToken = tokenDao.get(id);
	         
	        if (currentToken==null) {
	           
	            return new ResponseEntity<Token>(HttpStatus.NOT_FOUND);
	        }
	 
//	        currentToken.setUser(token.getUser());
//	        currentToken.setRate(token.getRate());
//	        currentToken.setDescription(token.getDescription());
		       
	        
	        tokenDao.saveOrUpdate(currentToken);
	        return new ResponseEntity<Token>(currentToken, HttpStatus.OK);
	    }
}
