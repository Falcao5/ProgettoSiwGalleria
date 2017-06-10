package it.uniroma3.spring.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import it.uniroma3.spring.model.Quadro;
import it.uniroma3.spring.model.Opera;

@Stateless
@EJB(name="ejb/QuadroFacade", beanInterface=QuadroFacade.class, beanName="QuadroFacade")
public class QuadroFacade {

	@PersistenceContext(unitName="uniroma3")
	private EntityManager em;

	public QuadroFacade(EntityManager em) {
		this.em = em;
	}
	
	public QuadroFacade(){
		
	}
	
	public Quadro createQuadro(String titolo, Integer anno, String tecnica, Dimension dimensioni, Autore autoreDellOpera){
		Quadro q=new Quadro();
		q.setTitolo(titolo);
		q.setAnno(anno);
		q.setTecnica(tecnica);
		q.setDimensioni(dimensioni);
		q.setAutoreDellOpera(autoreDellOpera);
		this.em.persist(q);
		return q;
	}
		
	public List<Quadro> getAllQuadro(){
		return this.em.createNamedQuery("Quadro.findAll", Quadro.class).getResultList();
	}
	
	public Quadro getQuadro(Long id) {
		try {
			return this.em.createNamedQuery("Quadro.findById", Quadro.class).setParameter("id", id).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Quadro getQuadro(String titolo) {
		try {
			return this.em.createNamedQuery("Quadro.findByTitolo", Quadro.class).setParameter("titolo", titolo).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Quadro getQuadro(Integer anno) {
		try {
			return this.em.createNamedQuery("Quadro.findByAnno", Quadro.class).setParameter("anno", anno).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
}