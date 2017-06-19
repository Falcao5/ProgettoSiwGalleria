package it.uniroma3.spring.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.uniroma3.spring.model.Autore;
import it.uniroma3.spring.model.Quadro;
import it.uniroma3.spring.service.AutoreService;
import it.uniroma3.spring.service.QuadroService;
import it.uniroma3.spring.service.UtenteService;

@Controller
public class QuadroController {

	@Autowired
	private AutoreService autoreService;
	
	@Autowired
	private QuadroService quadroService;

	public QuadroController(){

	}
	
	@RequestMapping(value = "/viewQuadro", method = RequestMethod.GET)
	public String viewQuadroByTitolo(Model model, @RequestAttribute Quadro quadro){
		
		Quadro quadroTrovato = quadroService.findByTitolo(quadro.getTitolo());
		
		model.addAttribute("quadro", quadroTrovato);
		
		return "/viewQuadro";
	}
	
	//Mostra la pagina di creazione 
	@RequestMapping(value = "/protected/createQuadro", method = RequestMethod.GET)
	public String welcome(Model model) {
		Quadro quadro = new Quadro();
		model.addAttribute("quadro", quadro);
		Iterable<Autore> autori = autoreService.findAll();
		model.addAttribute("autori", autori);
		
		return "/createQuadro";
	}

	//controlla se ci sono errori di validazione e in caso contrario aggiunge l'utente alla lista
	@RequestMapping(value = "/protected/createQuadro", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute Quadro quadro, @ModelAttribute Autore autore) {
		ModelAndView mav = new ModelAndView();
		
		this.quadroService.add(quadro);
		
		Map<String,Object> mMap = mav.getModel();
		mMap.put("quadro", quadro);
		
		System.out.println(quadro.getDimensioni().getHeight());
		System.out.println(quadro.getDimensioni().getWidth());
		
		mMap.put("autore", autore);
		
		mav.setViewName("/viewQuadro");
		
		return mav;
	}
	
	@RequestMapping(value="/protected/removeQuadro/{quadroId}", method = RequestMethod.GET)
	public String remove(@PathVariable("quadroId") Long quadroId){
		this.quadroService.removeById(quadroId);
		return "/index";
	}

}