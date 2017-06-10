package it.uniroma3.spring.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import it.uniroma3.spring.model.Utente;

@Stateless
@EJB(name="ejb/UtenteFacade", beanInterface=UtenteFacade.class, beanName="UtenteFacade")
public class UtenteFacade {

	@PersistenceContext(unitName="uniroma3")
	private EntityManager em;

	public UtenteFacade(EntityManager em) {
		this.em = em;
	}
	
	public UtenteFacade(){
		
	}
	
	public Utente createUtente(String username, String password){
		Utente u= new Utente();
		u.setUsername(username);
		u.setPassword(password);
		this.em.persist(u);
		return u;
	}
	
	public List<Utente> getAllUtente(){
		return this.em.createNamedQuery("Utente.findAll", Utente.class).getResultList();
	}
	
	public Utente getUtente(Long id) {
		try {
			return this.em.createNamedQuery("Utente.findById", Utente.class).setParameter("id", id).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Utente getUtente(String username) {
		try {
			return this.em.createNamedQuery("Utente.findByUsername", Utente.class).setParameter("username", username).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
