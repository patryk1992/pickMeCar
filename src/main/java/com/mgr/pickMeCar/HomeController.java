package com.mgr.pickMeCar;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mgr.pickMeCar.db.model.Token;
import com.mgr.pickMeCar.db.model.Track;
import com.mgr.pickMeCar.db.model.User;
import com.mgr.pickMeCar.db.repository.UserRepository;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private UserRepository userRepository;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	 @RequestMapping("/greeting")
	    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
	        model.addAttribute("name", name);
	        return "greeting";
	    }
	 @RequestMapping("/index")
	    public String index(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
	        model.addAttribute("name", name);
	        return "index";
	    }
	 @RequestMapping("/register")
	    public String register(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
	        model.addAttribute("name", name);
	        return "register";
	    }
	 @RequestMapping(value = "/register", method = RequestMethod.POST)
	 public String saveUser(User product){
//	     UserRepository.saveProduct(product);
	     return "redirect:/greeting/" ;
	 }
	  @RequestMapping(value = "/users", method = RequestMethod.GET)
	    public String list(Model model){
	        model.addAttribute("users",userRepository.findAll());
	        return "register";
	    }

}
