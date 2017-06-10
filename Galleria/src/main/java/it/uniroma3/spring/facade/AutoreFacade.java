/**
 * @author Marte Valerio Falcone & Francesco Lauzi
 * 
 */

package it.uniroma3.spring.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import it.uniroma3.spring.model.Autore;

@Stateless
@EJB(name="ejb/AutoreFacade", beanInterface=AutoreFacade.class, beanName="AutoreFacade")
public class AutoreFacade {

	@PersistenceContext(unitName="uniroma3")
	private EntityManager em;
	
	public AutoreFacade(EntityManager em) {
		this.em = em;
	}
	
	public AutoreFacade(){
		
	}
	
	public Autore createAutore(String nome, String cognome, String nazionalita, Date dataDiNascita, Date dataDiMorte){
		Autore a=new Autore();
		a.setNome(nome);
		a.setCognome(cognome);
		a.setNazionalita(nazionalita);
		a.setDataDiNascita(dataDiNascita);
		a.setDataDiMorte(dataDiMorte);
		this.em.persist(a);
		return a;
	}
	
	public List<Autore> getAllAutore(){
		try{
			return this.em.createNamedQuery("Autore.findAll", Autore.class).getResultList();
		}catch (NoResultException error){
			return null;
		}
	}
	
	public Autore getAutore(Long id) {
		try {
			return this.em.createNamedQuery("Autore.findById", Autore.class).setParameter("id", id).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Autore getAutore(String nome) {
		try {
			return this.em.createNamedQuery("Autore.findByNome", Autore.class).setParameter("nome", nome).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Autore getAutore(String cognome) {
		try {
			return this.em.createNamedQuery("Autore.findByCognome", Autore.class).setParameter("cognome", cognome).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Autore getAutore(String string) {
		try {
			return this.em.createNamedQuery("Autore.findByNazionalità", Autore.class).setParameter("nazionalità", nazionalità).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Autore getAutore(Date dataDiNascita) {
		try {
			return this.em.createNamedQuery("Autore.findByDataDiNascita", Autore.class).setParameter("dataDiNascita", dataDiNascita).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Autore getAutore(Date dataDiMorte) {
		try {
			return this.em.createNamedQuery("Autore.findByDatadiMorte", Autore.class).setParameter("dataDiMorte", dataDiMorte).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}