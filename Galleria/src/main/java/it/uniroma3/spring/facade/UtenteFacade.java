package it.uniroma3.spring.facade;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import it.uniroma3.spring.model.Utente;

public class UtenteFacade extends AbstractFacade<Utente>{
	
	public UtenteFacade(){
		super();
	}
	
	@Transactional
	public Utente createUtente(String username, String password){
		Utente u= new Utente();
		u.setUsername(username);
		u.setPassword(password);
		this.em.persist(u);
		return u;
	}

	@Override
	public Class<?> getThisClass() {
		return this.getClass();
	}
	
}
