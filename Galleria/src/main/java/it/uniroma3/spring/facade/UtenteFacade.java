package it.uniroma3.spring.facade;


import java.util.List;

import javax.persistence.EntityManager;

import it.uniroma3.spring.model.Utente;

public class UtenteFacade extends AbstractFacade<Utente>{
	
	public UtenteFacade(){
		super();
	}
	
	public UtenteFacade(EntityManager em){
		super(em);
	}
	
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
