package com.mgr.pickMeCar;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mgr.pickMeCar.db.model.Track;
import com.mgr.pickMeCar.db.model.User;
import com.mgr.pickMeCar.service.TrackService;
import com.mgr.pickMeCar.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TrackController {
	@Autowired
	private TrackService trackService;

	private static final Logger logger = LoggerFactory.getLogger(TrackController.class);

	@RequestMapping("/addtrack")
	public String newTrack(Model model) {
		model.addAttribute("track", new Track());
		return "addTrack";
	}

	@RequestMapping(value = "/addtrack/new", method = RequestMethod.POST)
	public String saveTrack(Track track) {
		trackService.saveOrUpdate(track);
		return "greeting";
	}

	@RequestMapping(value = "/tracks", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("users", trackService.list());
		return "register";
	}
	@RequestMapping(value = "/searchTrack", method = RequestMethod.GET)
	public String searchTrack(Model model) {
		model.addAttribute("track", new Track());
		List<Track> track = trackService.list();
//		model.addAttribute("trackList", trackService.list());
		return "searchTrack";
	}
	@RequestMapping(value = "/searchTrackTable/fromPlace={fromPlace}/toPlace={toPlace}/startingDate={startingDate}", method = RequestMethod.GET)
	public String searchTrackParam(Model model, @PathVariable("fromPlace") String fromPlace,@PathVariable("toPlace") String toPlace,@PathVariable("startingDate") String startingDate) {
//		model.addAttribute("track", new Track());
		List<Track> trackList = null;
		if(!fromPlace.equals("") && !toPlace.equals("") && !startingDate.equals("")){
			trackList = trackService.findByFromPlaceAndToPlaceAndStartingDate(fromPlace, toPlace, startingDate);
		}else if(!fromPlace.equals("") && !toPlace.equals("") ){
			trackList = trackService.findByFromPlaceAndToPlace(fromPlace, toPlace);
		}else if(!fromPlace.equals("")  && !startingDate.equals("")){
			trackList = trackService.findByFromPlaceAndStartingDate(fromPlace, startingDate);
		}else if( !toPlace.equals("") && !startingDate.equals("")){
			trackList = trackService.findByStartingDateAndToPlace(startingDate, toPlace);
		}else if(!fromPlace.equals("") ){
			trackList = trackService.findByFromPlace(fromPlace);
		}else if(!toPlace.equals("") ){
			trackList = trackService.findByToPlace(toPlace);
		}else if(!startingDate.equals("")){
			trackList = trackService.findByStartingDate(startingDate);
		}
		model.addAttribute("trackList", trackList);
	
		return "searchTrackResultTable";
	}
	@RequestMapping(value = "/searchTrackTable", method = RequestMethod.GET)
	public String searchTrackAll(Model model) {
//		model.addAttribute("track", new Track());
		List<Track> track = trackService.list();
		model.addAttribute("trackList", trackService.list());
	
		return "searchTrackResultTable";
	}
	@RequestMapping(value = "/myTrack", method = RequestMethod.GET)
	public String myTrack(Model model) {
//		model.addAttribute("track", new Track());
		List<Track> track = trackService.list();
		model.addAttribute("trackList", trackService.list());
	
		return "myTrack";
	}
	@RequestMapping(value = "/myTrack/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Integer id) {
		trackService.delete(id);		
		return "myTrack";
	}
	@RequestMapping(value = "/myTrack/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Integer id) {
		trackService.delete(id);		
		return "myTrack";
	}
	@RequestMapping(value = "/myTrack/editForm", method = RequestMethod.GET)
	public String editForm(Model model) {
				
		return "myTrackEditForm";
	}
}
