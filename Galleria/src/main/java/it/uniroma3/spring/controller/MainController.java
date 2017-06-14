package it.uniroma3.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.spring.facade.AmministratoreFacade;
import it.uniroma3.spring.facade.UtenteFacade;

@Controller
public class MainController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "login";
	}
			
			
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(){
		return "registrati";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "index";
	}
	
	@RequestMapping(value="/registraUtente", method=RequestMethod.POST)
	public String registraUtente(	@RequestParam("username") String username, 
									@RequestParam("password") String password
								){
		
		AmministratoreFacade af = new AmministratoreFacade();
		if(username.equals("admin") && af.getObjectFindByAttribute("admin", "username")==null) // Se lo username inserito è admin e non esiste nel db un Amministratore con username "admin"
			return registraAmministratore(username,password);
		
		UtenteFacade uf = new UtenteFacade();
		uf.createUtente(username, password);
		return "login";
	}
	
	@RequestMapping(value="/registraAmministratore", method=RequestMethod.POST)
	public String registraAmministratore(	@RequestParam("username") String username, 
											@RequestParam("password") String password
										){
		AmministratoreFacade af = new AmministratoreFacade();
		af.createAmministratore(username, password);
		return "login";
	}
	
}
