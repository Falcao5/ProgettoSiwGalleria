package it.uniroma3.spring.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.*;

import it.uniroma3.spring.model.Utente;
import it.uniroma3.spring.repository.UtenteRepository;
import it.uniroma3.spring.service.UtenteService;

@Controller
public class UtenteController {
  
	@Autowired
	private UtenteService service;
	
  public UtenteController(){
    
  }

  //Mostra la pagina di creazione 
    @RequestMapping(value = "/protected/createUtente", method = RequestMethod.GET)
    public String welcome(Model model) {
      model.addAttribute("utente",new Utente());
      return "/createUtente";
    }
  
  //controlla se ci sono errori di validazione e in caso contrario aggiunge l'utente alla lista
    @RequestMapping(value = "/protected/createUtente", method = RequestMethod.POST)
    public String create(@ModelAttribute Utente utente) {
      
      this.service.add(utente);
      
      return "/viewUtente";
    }
    
    
}
