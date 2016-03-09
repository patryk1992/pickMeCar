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

import com.mgr.pickMeCar.db.dao.TokenDAO;
import com.mgr.pickMeCar.db.model.Token;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private TokenDAO userDao;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		//model.addAttribute("serverTime", formattedDate);
//		List<Token> listUsers = userDao.list();
//		logger.info("Welcome list"+ listUsers.toString());
		Token token = new Token("new1234", new Date(),  new Date());
		token.setId(1);
//		userDao.saveOrUpdate(token);
//		logger.info("Welcome list"+ userDao.get(1).getToken());
//		userDao.delete(2);
		
		return "home";
	}

}
