package it.uniroma3.spring.controller;

import java.util.List;

import javax.validation.Valid;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.uniroma3.spring.model.Quadro;
import it.uniroma3.spring.service.QuadroService;
import it.uniroma3.spring.service.UtenteService;

@Controller
public class QuadroController {

	@Autowired
	private QuadroService service;

	public QuadroController(){
		
	}

	//Mostra la pagina di creazione 
	@RequestMapping(value = "/createQuadro", method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("quadro",new Quadro());
		return "/createQuadro";
	}

	//controlla se ci sono errori di validazione e in caso contrario aggiunge il quadro alla lista
	@RequestMapping(value = "/createQuadro", method = RequestMethod.POST)
	public ModelAndView create(@Valid Quadro quadro, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()){
			mav = new ModelAndView("/createQuadro");
			return mav;
		}
		
		service.add(quadro);
		
		mav = new ModelAndView("/viewQuadro");
		mav.getModel().put("quadro", quadro);
		
		return mav;
	}

}
