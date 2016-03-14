package com.mgr.pickMeCar.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.util.UriComponentsBuilder;


import com.mgr.pickMeCar.db.dao.GroupsDAO;
import com.mgr.pickMeCar.db.dao.GroupsDAOImpl;
import com.mgr.pickMeCar.db.dao.MarkDAO;
import com.mgr.pickMeCar.db.dao.TokenDAO;
import com.mgr.pickMeCar.db.dao.TrackDAO;
import com.mgr.pickMeCar.db.dao.UserCarDAO;
import com.mgr.pickMeCar.db.dao.UserDAO;
import com.mgr.pickMeCar.db.model.Groups;
import com.mgr.pickMeCar.db.model.Mark;
import com.mgr.pickMeCar.db.model.Token;
import com.mgr.pickMeCar.db.model.Track;
import com.mgr.pickMeCar.db.model.User;

@RestController
public class MarkController {
	@Autowired
	private MarkDAO markDao;
	@Autowired
	private UserDAO userDao;
	 @RequestMapping(value = "/rest-api/mark",method = RequestMethod.GET,produces = "application/json",headers="Accept=*/*")
	    public ResponseEntity <Mark> listMark() {
			
			List<Mark> liMark =markDao.list();
//			if(liMark.isEmpty()){
//	            return new ResponseEntity<List<Mark>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//	        }
			User usr=userDao.get(1);
			
			Mark test = new Mark(usr, 4, "dsag");
	        return new ResponseEntity <Mark>(test, HttpStatus.OK);
	 }
	 @RequestMapping(value = "/rest-api/mark",method = RequestMethod.POST,produces = "application/json",headers="Accept=*/*")
	    public ResponseEntity<Void> createMark(@RequestBody Mark mark,    UriComponentsBuilder ucBuilder) {		 
	        if (mark.getId()!=null && markDao.get(mark.getId())!=null) {	           
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	        
	        markDao.saveOrUpdate(mark);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/rest-api/mark/{id}").buildAndExpand(mark.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 @RequestMapping(value = "/rest-api/mark/{id}",method = RequestMethod.DELETE,produces = "application/json",headers="Accept=*/*")
	    public ResponseEntity<Mark> deleteMark(@PathVariable("id") int id) {
	        Mark mark = markDao.get(id);
	        if (mark == null) {
	            
	            return new ResponseEntity<Mark>(HttpStatus.NOT_FOUND);
	        }
	 
	        markDao.delete(id);
	        return new ResponseEntity<Mark>(HttpStatus.NO_CONTENT);
	 }
	  @RequestMapping(value = "/rest-api/mark/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Mark> updateMark(@PathVariable("id") int id, @RequestBody Mark mark) {
		  Mark currentMark = markDao.get(id);
	         
	        if (currentMark==null) {
	           
	            return new ResponseEntity<Mark>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentMark.setUser(mark.getUser());
	        currentMark.setRate(mark.getRate());
	        currentMark.setDescription(mark.getDescription());
		       
	        
	        markDao.saveOrUpdate(currentMark);
	        return new ResponseEntity<Mark>(currentMark, HttpStatus.OK);
	    }
}
