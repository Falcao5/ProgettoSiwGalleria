package it.uniroma3.spring.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {
	
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String goHome() {
        return "index";
    }
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(){
		return "registrati";
	}
	
}
