package it.uniroma3.spring.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	@Autowired
    private UtenteRepository utenteRepository; 

  public UtenteController(){
    
  }

  //Mostra la pagina di creazione 
    @RequestMapping(value = "/createUtente", method = RequestMethod.GET)
    public String welcome(Model model) {
      model.addAttribute("found",new Utente());
      return "/createUtente";
    }
  
  //controlla se ci sono errori di validazione e in caso contrario aggiunge l'utente alla lista
    @RequestMapping(value = "/createUtente", method = RequestMethod.POST)
    public String create(@Valid Utente utente, BindingResult result) {
      if(result.hasErrors()){
          return "/createUtente";
      }
      
      this.service.add(utente);
      
      return "/viewUtente";
    }
    
    
}
