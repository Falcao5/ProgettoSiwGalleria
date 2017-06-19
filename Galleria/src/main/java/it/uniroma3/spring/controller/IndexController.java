package it.uniroma3.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.uniroma3.spring.model.Autore;
import it.uniroma3.spring.model.Quadro;
import it.uniroma3.spring.service.QuadroService;

@Controller
public class IndexController {

	@Autowired
	private QuadroService quadroService;

	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String goHomeGet(){
		return "/index";
	}

	
}