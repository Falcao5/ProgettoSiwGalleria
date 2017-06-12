package it.uniroma3.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
		
	@RequestMapping(path="/login")
	public String login(){
		return "login.html";
	}
	
	@RequestMapping(path="/signup")
	public String signup(){
		return "/registrati.html";
	}
	
	@RequestMapping(path="/home")
	public String goHome(){
		return "index.html";
	}
	
}
