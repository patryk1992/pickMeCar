package com.mgr.pickMeCar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		model.addAttribute("users", trackService.list());
		return "searchTrack";
	}

}
