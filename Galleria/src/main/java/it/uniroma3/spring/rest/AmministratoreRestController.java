package it.uniroma3.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.spring.model.Amministratore;
import it.uniroma3.spring.service.AmministratoreService;
import it.uniroma3.spring.service.UtenteService;

@RestController
public class AmministratoreRestController {
	
	@Autowired
	AmministratoreService amministratoreService;
	
    @RequestMapping("/rest/amministratore/{id}")
    public Amministratore getAmministratore(@PathVariable Long id) {
        return amministratoreService.findbyId(id);
    }
}
