package org.javabase.apps.controller;

import javax.servlet.http.HttpSession;

import org.javabase.apps.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
    UserService userservice;
    
    @Autowired
    HttpSession response;
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home() {

		log.info("Welcome home! ");
		return "index";
	}
	
}
