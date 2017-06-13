package it.uniroma3.spring.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class MainController {
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(){
		return "registrati";
	}
	
	@RequestMapping("/home")
	public String goHome(){
		return "index";
	}
	/*
	@Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");
        return resolver;
    }
    */
}
