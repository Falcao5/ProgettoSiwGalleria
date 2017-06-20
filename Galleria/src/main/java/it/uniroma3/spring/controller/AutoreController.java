package it.uniroma3.spring.controller;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.spring.model.Autore;
import it.uniroma3.spring.model.Quadro;
import it.uniroma3.spring.service.AutoreService;
import it.uniroma3.spring.service.QuadroService;

@Controller
public class AutoreController {

	@Autowired
	private AutoreService autoreService;
	
	@Autowired
	private QuadroService quadroService;

	public AutoreController(){

	}

	@RequestMapping(value = "/viewAutore", method = RequestMethod.POST)
	public String viewAutore(Model model, @ModelAttribute Autore autore){
		List<Quadro> quadriDalDb = (List<Quadro>)quadroService.findAll();
		
		List<Quadro> quadri = new LinkedList<>();
		
		for(Quadro q : quadriDalDb){
			if(q.getAutore().equals(autore))
				quadri.add(q);
		}
		
		if(autore!=null){
			System.out.println(autore.getNome());
			System.out.println(autore.getCognome());
		}
		
		model.addAttribute(autore);
		model.addAttribute(quadri);
		
		return "/viewAutore";
	}
	
	@RequestMapping(value = "/protected/createAutore", method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("autore",new Autore());
		return "/createAutore";
	}

	@Transactional
	@RequestMapping(value = "/protected/createAutore", method = RequestMethod.POST)
	public String create(Model model, @ModelAttribute Autore autore) {
		
		this.autoreService.add(autore);
		
		model.addAttribute(autore);
		
		return "/viewAutore";
	}

}
