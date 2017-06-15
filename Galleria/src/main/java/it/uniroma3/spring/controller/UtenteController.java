package it.uniroma3.spring.controller;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.*;

import it.uniroma3.spring.model.Utente;

@Controller
public class UtenteController {
  
  private List<Utente> utentiList;

  public UtenteController(){
    utentiList = new ArrayList<Utente>();
  }

  //Mostra la pagina di creazione 
    @RequestMapping(value = "/createUtente", method = RequestMethod.GET)
    public String welcome(Model model) {
      model.addAttribute("utente",new Utente());
      return "/utente/createUtente";
    }
  
  //controlla se ci sono errori di validazione e in caso contrario aggiunge l'utente alla lista
    @RequestMapping(value = "/createUtente", method = RequestMethod.POST)
    public String create(@Valid Utente utente, BindingResult result) {
      if(result.hasErrors()){
          return "/utente/createUtente";
      }
      utentiList.add(utente);
      return "redirect:getview";
    }
  
  
}
