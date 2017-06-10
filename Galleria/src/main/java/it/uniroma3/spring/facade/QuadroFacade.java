package it.uniroma3.spring.facade;

import java.awt.Dimension;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import it.uniroma3.spring.model.Quadro;
import it.uniroma3.spring.model.Amministratore;
import it.uniroma3.spring.model.Autore;

@Stateless
@EJB(name="ejb/QuadroFacade", beanInterface=QuadroFacade.class, beanName="QuadroFacade")
public class QuadroFacade extends AbstractFacade{
	public QuadroFacade(){
		
	}
	
	public Quadro createQuadro(String titolo, Integer anno, String tecnica, Dimension dimensioni, Autore autoreDellOpera){
		Quadro q=new Quadro();
		q.setTitolo(titolo);
		q.setAnno(anno);
		q.setTecnica(tecnica);
		q.setDimensioni(dimensioni);
		q.setAutore(autoreDellOpera);
		this.em.persist(q);
		return q;
	}
	
	/**
	 * Cerca nel database un Quadro in base a un attributo. Questo attributo ha il tipo di o, e il nome dell'attributo è attributeName
	 * @param o Oggetto in base al quale ricercare il Quadro
	 * @param attribute String in base al quale ricercare il Quadro
	 * @return	L'Amministratore trovato con il parametro attributeName
	 * @return	null se non esistono Quadro nel database con quell'attributeName
	 */
	public Quadro getAmministratore(Object o, String attributeName){
		return (Quadro)this.getObjectFindByAttribute(o, attributeName);
	}

	@Override
	public Class<?> getThisClass() {
		return this.getClass();
	}
}
		
//	public List<Quadro> getAllQuadro(){
//		return this.em.createNamedQuery("Quadro.findAll", Quadro.class).getResultList();
//	}
//	
//	public Quadro getQuadro(Long id) {
//		try {
//			return this.em.createNamedQuery("Quadro.findById", Quadro.class).setParameter("id", id).getSingleResult();
//		} catch (NoResultException e) {
//			return null;
//		}
//	}
//
//	public Quadro getQuadro(String titolo) {
//		try {
//			return this.em.createNamedQuery("Quadro.findByTitolo", Quadro.class).setParameter("titolo", titolo).getSingleResult();
//		} catch (NoResultException e) {
//			return null;
//		}
//	}
//
//	public Quadro getQuadro(Integer anno) {
//		try {
//			return this.em.createNamedQuery("Quadro.findByAnno", Quadro.class).setParameter("anno", anno).getSingleResult();
//		} catch (NoResultException e) {
//			return null;
//		}
//	}
