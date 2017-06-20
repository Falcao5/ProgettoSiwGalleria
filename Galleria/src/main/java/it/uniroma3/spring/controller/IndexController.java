package it.uniroma3.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.spring.model.Autore;
import it.uniroma3.spring.service.AutoreService;

@Controller
public class IndexController {

	@Autowired
	private AutoreService autoreService;

	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String goHomeGet(Model model){
		
		List<Autore> autori = (List<Autore>)autoreService.findAll();
		model.addAttribute("autori", autori);
		
		return "/index";
	}

	
}