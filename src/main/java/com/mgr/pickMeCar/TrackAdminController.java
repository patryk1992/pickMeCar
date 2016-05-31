package com.mgr.pickMeCar;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mgr.pickMeCar.db.model.Track;
import com.mgr.pickMeCar.db.model.User;
import com.mgr.pickMeCar.service.MarkService;
import com.mgr.pickMeCar.service.TrackService;
import com.mgr.pickMeCar.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TrackAdminController {
	@Autowired
	private TrackService trackService;
	@Autowired
	private MarkService markService;

	private static final Logger logger = LoggerFactory.getLogger(TrackAdminController.class);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "admin/tracks", method = RequestMethod.GET)
	public String myTrack(Model model) {
//		model.addAttribute("track", new Track());
		List<Track> track = trackService.list();
		model.addAttribute("trackList", trackService.list());		
		return "adminTracks";
	}
	@RequestMapping(value = "admin/tracks/{id}", method = RequestMethod.GET)
	public String myTrack(Model model,@PathVariable Integer id) {
//		model.addAttribute("track", new Track());
		List<Track> trackList = trackService.list();
		Track track = null;
		for(Track x : trackList){
			if(x.getId()==id){
				track=x;
			}
		}
		model.addAttribute("track", track);
		model.addAttribute("trackList", trackService.list());	
		return "adminTracksEditForm";
	}
	@RequestMapping(value = "admin/tracks/delete/{id}", method = RequestMethod.GET)
	public String delete(Model model,@PathVariable Integer id) {
		trackService.delete(id);		
		model.addAttribute("trackList", trackService.list());		
		return "adminTracks";
	}
	@RequestMapping(value = "admin/tracks/edit", method = RequestMethod.POST)
	public String edit(Model model,Track track) {
		model.addAttribute("trackList", trackService.list());	
		trackService.saveOrUpdate(track);
		return "adminTracks";
	}
	@RequestMapping(value = "admin/tracks/editForm", method = RequestMethod.GET)
	public String editForm(Model model) {
				
		return "adminTracksEditForm";
	}
	
}
