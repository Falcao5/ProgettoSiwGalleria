package it.uniroma3.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.spring.model.Utente;
import it.uniroma3.spring.service.UtenteService;

@RestController
public class UtenteRestController {

	@Autowired
	UtenteService utenteService;

	@RequestMapping("/rest/utente/{id}")
	public Utente getCustomer(@PathVariable Long id) {
		return utenteService.findbyId(id);
	}
}