package com.mgr.pickMeCar.rest;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.mgr.pickMeCar.HomeController;
import com.mgr.pickMeCar.db.dao.CityDAO;
import com.mgr.pickMeCar.db.dao.GroupsDAO;
import com.mgr.pickMeCar.db.dao.GroupsDAOImpl;
import com.mgr.pickMeCar.db.dao.MarkDAO;
import com.mgr.pickMeCar.db.dao.TokenDAO;
import com.mgr.pickMeCar.db.dao.TrackDAO;
import com.mgr.pickMeCar.db.dao.UserCarDAO;
import com.mgr.pickMeCar.db.dao.UserDAO;
import com.mgr.pickMeCar.db.model.City;
import com.mgr.pickMeCar.db.model.Groups;
import com.mgr.pickMeCar.db.model.Mark;
import com.mgr.pickMeCar.db.model.Token;
import com.mgr.pickMeCar.db.model.Track;
import com.mgr.pickMeCar.db.model.User;

@RestController
public class CityController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private CityDAO cityDao;
	@Autowired
	private UserDAO userDao;
	 @RequestMapping(value = "/rest-api/city",method = RequestMethod.GET,produces = "application/json",headers="Accept=*/*")
	    public ResponseEntity <List<City>> listCity() {
			
			List<City> liCity =cityDao.list();
			logger.info("Welcome list"+ liCity.toString());
			if(liCity.isEmpty()){
	            return new ResponseEntity<List<City>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }

	        return new ResponseEntity <List<City>>(liCity, HttpStatus.OK);
	 }
	 @RequestMapping(value = "/rest-api/city",method = RequestMethod.POST,produces = "application/json",headers="Accept=*/*")
	    public ResponseEntity<Void> createCity(@RequestBody City city,    UriComponentsBuilder ucBuilder) {		 
	        if (city.getId()!=null && cityDao.get(city.getId())!=null) {	           
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	        
	        cityDao.saveOrUpdate(city);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/rest-api/city/{id}").buildAndExpand(city.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 @RequestMapping(value = "/rest-api/city/{id}",method = RequestMethod.DELETE,produces = "application/json",headers="Accept=*/*")
	    public ResponseEntity<City> deleteCity(@PathVariable("id") int id) {
	        City city = cityDao.get(id);
	        if (city == null) {
	            
	            return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
	        }
	 
	        cityDao.delete(id);
	        return new ResponseEntity<City>(HttpStatus.NO_CONTENT);
	 }
	  @RequestMapping(value = "/rest-api/city/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<City> updateCity(@PathVariable("id") int id, @RequestBody City city) {
		  City currentCity = cityDao.get(id);
	         
	        if (currentCity==null) {
	           
	            return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
	        }
	 
//	        currentCity.setUser(city.getUser());
//	        currentCity.setRate(city.getRate());
//	        currentCity.setDescription(city.getDescription());
		       
	        
	        cityDao.saveOrUpdate(currentCity);
	        return new ResponseEntity<City>(currentCity, HttpStatus.OK);
	    }
}
