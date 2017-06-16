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

import it.uniroma3.spring.model.Amministratore;
import it.uniroma3.spring.service.AmministratoreService;
import it.uniroma3.spring.service.UtenteService;

@Controller
public class AmministratoreController {
	
	@Autowired
	private AmministratoreService service;

  public AmministratoreController(){
	  
  }

  //Mostra la pagina di creazione 
    @RequestMapping(value = "/createAmministratore", method = RequestMethod.GET)
    public String welcome(Model model) {
      model.addAttribute("amministratore", new Amministratore());
      return "/amministratore/createAmministratore";
    }
  
  //controlla se ci sono errori di validazione e in caso contrario aggiunge l'amministratore alla lista
    @RequestMapping(value = "/createAmministratore", method = RequestMethod.POST)
    public String create(@Valid Amministratore amministratore, BindingResult result) {
      if(result.hasErrors()){
          return "/amministratore/createAmministratore";
      }
      
      this.service.add(amministratore);
      
      return "/amministratore/viewAmministratore";
    }
  
  
}
