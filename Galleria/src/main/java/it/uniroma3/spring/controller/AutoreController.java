package it.uniroma3.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.spring.model.Autore;
import it.uniroma3.spring.service.AutoreService;

@Controller
public class AutoreController {

	@Autowired
	private AutoreService service;

	public AutoreController(){

	}

	//Mostra la pagina di creazione 
	@RequestMapping(value = "/protected/createAutore", method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("autore",new Autore());
		return "/createAutore";
	}

	//controlla se ci sono errori di validazione e in caso contrario aggiunge l'utente alla lista
	@RequestMapping(value = "/protected/createAutore", method = RequestMethod.POST)
	public String create(@ModelAttribute Autore autore) {

		this.service.add(autore);

		return "/viewAutore";
	}

}
