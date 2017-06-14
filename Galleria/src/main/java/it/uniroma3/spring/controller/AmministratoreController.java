package it.uniroma3.spring.controller;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.*;

import it.uniroma3.spring.model.Amministratore;

@Controller
public class AmministratoreController {
  
  private List<Amministratore> amministratoriList;

  public AmministratoreController(){
    amministratoriList = new ArrayList<Amministratore>();
  }

  //Mostra la pagina di creazione 
    @RequestMapping(value = "/createAmministratore", method = RequestMethod.GET)
    public String welcome(Model model) {
      model.addAttribute("amministratore",new Amministratore());
      return "/amministratore/createAmministratore";
    }
  
  //controlla se ci sono errori di validazione e in caso contrario aggiunge l'amministratore alla lista
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid Amministratore amministratore, BindingResult result) {
      if(result.hasErrors()){
          return "/amministratore/createAmministratore";
      }
      amministratoriList.add(amministratore);
      return "redirect:getview";
    }
  
  
}
