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

import com.mgr.pickMeCar.db.model.Mark;
import com.mgr.pickMeCar.db.model.Track;
import com.mgr.pickMeCar.db.model.User;
import com.mgr.pickMeCar.service.MarkService;
import com.mgr.pickMeCar.service.TrackService;
import com.mgr.pickMeCar.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MarkController {
	@Autowired
	private MarkService markService;
	@Autowired
	private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(MarkController.class);

	@RequestMapping("/mark/idRatingUser={idRatingUser}")
	public String newTrack(Model model,  @PathVariable("idRatingUser") int idRatingUser) {
		Mark mark = new Mark();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
		mark.setRatingUser(userService.get(idRatingUser));
		mark.setUser(userService.findOneByUserName(name));
		markService.saveOrUpdate(mark);
		model.addAttribute("userList", userService.list());
		
		return "searchUser";
	}
	
	
	@RequestMapping(value = "/mark/edit", method = RequestMethod.POST)
	public String edit(Model model,Mark mark) {
		model.addAttribute("userList", markService.list());	
		markService.saveOrUpdate(mark);
		return "myTrack";
	}

}
