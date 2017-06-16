package it.uniroma3.spring.controller;

import java.util.List;

import javax.validation.Valid;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.spring.facade.QuadroFacade;
import it.uniroma3.spring.model.Quadro;

@Controller
public class QuadroController {
  
  private List<Quadro> quadriList;

  public QuadroController(){
    quadriList = new ArrayList<Quadro>();
  }

  //Mostra la pagina di creazione 
    @RequestMapping(value = "/createQuadro", method = RequestMethod.GET)
    public String welcome(Model model) {
      model.addAttribute("quadro",new Quadro());
      return "/createQuadro";
    }
  
  //controlla se ci sono errori di validazione e in caso contrario aggiunge il quadro alla lista
    @RequestMapping(value = "/createQuadro", method = RequestMethod.POST)
    public String create(@Valid Quadro quadro, BindingResult result) {
      if(result.hasErrors()){
          return "/createQuadro";
      }
      quadriList.add(quadro);
      return "redirect:getViewQuadro";
    }
  
  //mostra la lista dei quadri
    @RequestMapping(value = "/getviewQuadro")
    public String view(Model model) {
      model.addAttribute("quadriList", quadriList);
      return "/viewQuadro";
    }
  
  
}
