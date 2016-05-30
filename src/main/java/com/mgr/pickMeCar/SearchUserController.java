package com.mgr.pickMeCar;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class SearchUserController {
	@Autowired
	private UserService userService;
	@Autowired
	private MarkService markService;

	private static final Logger logger = LoggerFactory.getLogger(SearchUserController.class);

	@RequestMapping(value = "/searchUser", method = RequestMethod.GET)
	public String searchTrack(Model model) {
		model.addAttribute("user", new User());
		List<User> track = userService.list();
//		model.addAttribute("trackList", trackService.list());
		return "searchUser";
	}
	@RequestMapping(value = "/searchUserTable/username={username}", method = RequestMethod.GET)
	public String searchTrackParam(Model model, @PathVariable("username") String username) {
//		model.addAttribute("track", new Track());
		List<User> trackList = null;
		if(!username.equals("") ){
			trackList = userService.findByUserName(username);
		}
		model.addAttribute("userList", trackList);
	
		return "searchUserResultTable";
	}
	@RequestMapping(value = "/searchUserTable", method = RequestMethod.GET)
	public String searchTrackAll(Model model) {
//		model.addAttribute("track", new Track());
		List<User> track = userService.list();
		model.addAttribute("userList", userService.list());		
		
		
		return "searchUserResultTable";
	}	
}
