package com.mgr.pickMeCar.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.util.UriComponentsBuilder;


import com.mgr.pickMeCar.db.dao.GroupsDAO;
import com.mgr.pickMeCar.db.dao.GroupsDAOImpl;
import com.mgr.pickMeCar.db.dao.TokenDAO;
import com.mgr.pickMeCar.db.dao.UserCarDAO;
import com.mgr.pickMeCar.db.model.Groups;
import com.mgr.pickMeCar.db.model.Token;
import com.mgr.pickMeCar.db.model.User;

@RestController

public class GroupsController {
	@Autowired
	private GroupsDAO groupsDao;
	 @RequestMapping(value = "/rest-api/groups",method = RequestMethod.GET,produces = "application/json",headers="Accept=*/*")
	    public ResponseEntity<List<Groups>> groups() {
			
			List<Groups> ligroups =groupsDao.list();
			if(ligroups.isEmpty()){
	            return new ResponseEntity<List<Groups>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity <List<Groups>>(ligroups, HttpStatus.OK);
	 }
}
