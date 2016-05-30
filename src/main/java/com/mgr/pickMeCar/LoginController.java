package com.mgr.pickMeCar;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mgr.pickMeCar.db.model.Track;
import com.mgr.pickMeCar.db.model.User;
import com.mgr.pickMeCar.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping("/login")
	public String newUser(Model model) {
//		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/login/new", method = RequestMethod.POST)
	public String saveUser(User user) {
		userService.saveOrUpdate(user);
		return "greeting";
	}
	 
	

}
