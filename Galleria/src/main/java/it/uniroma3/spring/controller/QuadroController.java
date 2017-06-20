package it.uniroma3.spring.controller;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.uniroma3.spring.model.Autore;
import it.uniroma3.spring.model.Quadro;
import it.uniroma3.spring.service.AutoreService;
import it.uniroma3.spring.service.QuadroService;

@Controller
public class QuadroController {

	@Autowired
	private AutoreService autoreService;
	
	@Autowired
	private QuadroService quadroService;

	public QuadroController(){
		
	}
	
	@RequestMapping(value = "/viewQuadro", method = RequestMethod.POST)
	public ModelAndView viewQuadro(@ModelAttribute Quadro quadro){
		ModelAndView mav = new ModelAndView();
		
		mav.getModel().put("quadro", quadro);
		
		mav.getModel().put("autore", quadro.getAutore());
		
		mav.setViewName("/viewQuadro");
		
		return mav;
	}
	
	//Mostra la pagina di creazione 
	@RequestMapping(value = "/protected/createQuadro", method = RequestMethod.GET)
	public String createQuadroGet(Model model) {
		Quadro quadro = new Quadro();
		model.addAttribute("quadro", quadro);
		Iterable<Autore> autori = autoreService.findAll();
		model.addAttribute("autori", autori);
		
		return "/createQuadro";
	}
	
	@Transactional
	@RequestMapping(value = "/protected/createQuadro", method = RequestMethod.POST)
	public ModelAndView createQuadroPost(@ModelAttribute Quadro quadro, @ModelAttribute Autore autore) {
		ModelAndView mav = new ModelAndView();
		
		this.quadroService.add(quadro);
		
		Map<String,Object> mMap = mav.getModel();
		mMap.put("quadro", quadro);
		
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