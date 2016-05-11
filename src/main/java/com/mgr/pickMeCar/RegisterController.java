package com.mgr.pickMeCar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mgr.pickMeCar.db.model.User;
import com.mgr.pickMeCar.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RegisterController {
	@Autowired
	private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@RequestMapping("/register")
	public String newUser(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "/register/new", method = RequestMethod.POST)
	public String saveUser(User user) {
		userService.saveOrUpdate(user);
		return "greeting";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("users", userService.list());
		return "register";
	}

}
