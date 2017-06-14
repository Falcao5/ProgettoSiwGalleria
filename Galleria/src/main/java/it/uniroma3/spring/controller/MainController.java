package it.uniroma3.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.uniroma3.spring.facade.AmministratoreFacade;
import it.uniroma3.spring.facade.UtenteFacade;
import it.uniroma3.spring.model.Amministratore;
import it.uniroma3.spring.model.Utente;

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
	
	@RequestMapping(value="/registraUtente", method=RequestMethod.POST)
	public ModelAndView registraUtente(	@RequestParam("username") String username, 
									@RequestParam("password") String password
								){
		
		AmministratoreFacade af = new AmministratoreFacade();
		if(username.equals("admin") && af.getObjectFindByAttribute("admin", "username")==null) // Se lo username inserito è admin e non esiste nel db un Amministratore con username "admin"
			return registraAmministratore(username,password);
		
		UtenteFacade uf = new UtenteFacade();
		Utente u = uf.createUtente(username, password);
		
		ModelAndView maw = new ModelAndView("registrato");
		maw.getModel().put("user", u);
		
		return new ModelAndView("registrato");
	}
	
	@RequestMapping(value="/registraAmministratore", method=RequestMethod.POST)
	public ModelAndView registraAmministratore(	@RequestParam("username") String username, 
											@RequestParam("password") String password
										){
		AmministratoreFacade af = new AmministratoreFacade();
		Amministratore a = af.createAmministratore(username, password);
		
		ModelAndView maw = new ModelAndView("registrato");
		maw.getModel().put("admin", a);
		
		return maw;
	}
	
}
