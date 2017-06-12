package it.uniroma3.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	
	@PostMapping("/login")
	public String login(){
		return "login";
	}
	
	@PostMapping("/signup")
	public String signup(){
		return "registrati";
	}
	
	@PostMapping("/home")
	public String goHome(){
		return "index";
	}
}
