package it.uniroma3.spring.controller;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.*;

import it.uniroma3.spring.model.Autore;

@Controller
public class AutoreController {
  
  private List<Autore> autoriList;

  public AutoreController(){
    autoriList = new ArrayList<Autore>();
  }

  //Mostra la pagina di creazione 
    @RequestMapping(value = "/createAutore", method = RequestMethod.GET)
    public String welcome(Model model) {
      model.addAttribute("autore",new Autore());
      return "/autore/createAutore";
    }
  
  //controlla se ci sono errori di validazione e in caso contrario aggiunge l'autore alla lista
    @RequestMapping(value = "/createAutore", method = RequestMethod.POST)
    public String create(@Valid Autore autore, BindingResult result) {
      if(result.hasErrors()){
          return "/autore/createAutore";
      }
      autoriList.add(autore);
      return "redirect:getview";
    }
  
  //mostra la lista dei autori
    @RequestMapping(value = "/getViewAutore")
    public String view(Model model) {
      model.addAttribute("autoriList", autoriList);
      return "/viewAutore";
    }
  
  
}
