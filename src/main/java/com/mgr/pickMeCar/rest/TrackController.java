package com.mgr.pickMeCar.rest;

import java.util.ArrayList;
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
import com.mgr.pickMeCar.db.dao.TokenDAO;
import com.mgr.pickMeCar.db.dao.TrackDAO;
import com.mgr.pickMeCar.db.dao.UserCarDAO;
import com.mgr.pickMeCar.db.model.Groups;
import com.mgr.pickMeCar.db.model.Token;
import com.mgr.pickMeCar.db.model.Track;
import com.mgr.pickMeCar.db.model.User;

@RestController

public class TrackController {
	@Autowired
	private TrackDAO trackDao;
	 @RequestMapping(value = "/rest-api/track",method = RequestMethod.GET,produces = "application/json",headers="Accept=*/*")
	    public ResponseEntity<List<Track>> listTrack() {
			
			List<Track> liTrack =trackDao.list();
			if(liTrack.isEmpty()){
	            return new ResponseEntity<List<Track>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity <List<Track>>(liTrack, HttpStatus.OK);
	 }
	 @RequestMapping(value = "/rest-api/track",method = RequestMethod.POST,produces = "application/json",headers="Accept=*/*")
	    public ResponseEntity<Void> createTrack(@RequestBody Track track,    UriComponentsBuilder ucBuilder) {		 
	        if (track.getId()!=null && trackDao.get(track.getId())!=null) {	           
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }	 
	        trackDao.saveOrUpdate(track);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/track/{id}").buildAndExpand(track.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 @RequestMapping(value = "/rest-api/track/{id}",method = RequestMethod.DELETE,produces = "application/json",headers="Accept=*/*")
	    public ResponseEntity<Track> deleteTrack(@PathVariable("id") int id) {
		 
		  
	        Track track = trackDao.get(id);
	        if (track == null) {
	            
	            return new ResponseEntity<Track>(HttpStatus.NOT_FOUND);
	        }
	 
	        trackDao.delete(id);
	        return new ResponseEntity<Track>(HttpStatus.NO_CONTENT);
	 }
	  @RequestMapping(value = "/rest-api/track/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Track> updateTrack(@PathVariable("id") int id, @RequestBody Track track) {
	        Track currentTrack = trackDao.get(id);
	         
	        if (currentTrack==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Track>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentTrack.setFromPlace(track.getFromPlace());
	        currentTrack.setToPlace(track.getToPlace());
	        currentTrack.setStartingPlace(track.getStartingPlace());
	        currentTrack.setStartingTime(track.getStartingTime());
	        currentTrack.setPrice(track.getPrice());
	        currentTrack.setThroughs(track.getThroughs());
	        currentTrack.setUserTracks(track.getUserTracks());
	        
	        trackDao.saveOrUpdate(currentTrack);
	        return new ResponseEntity<Track>(currentTrack, HttpStatus.OK);
	    }
}
