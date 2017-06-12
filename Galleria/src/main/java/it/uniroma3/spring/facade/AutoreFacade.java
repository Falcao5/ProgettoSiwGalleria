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
public class AutoreFacade extends AbstractFacade {

	public AutoreFacade(){

	}

	public Autore createAutore(String nome, String cognome, String nazionalita, Date dataDiNascita, Date dataDiMorte){
		Autore a= new Autore();
		a.setNome(nome);
		a.setCognome(cognome);
		a.setNazionalita(nazionalita);
		a.setDataDiNascita(dataDiNascita);
		a.setDataDiMorte(dataDiMorte);
		this.em.persist(a);
		return a;
	}
	
	/**
	 * Cerca nel database un Autore in base a un attributo. Questo attributo ha il tipo di o, e il nome dell'attributo è attribute 
	 * @param o Oggetto in base al quale ricercare l'Autore
	 * @param attribute String in base al quale ricercare l'Autore
	 * @return	L'Autore trovato con il parametro attributo
	 * @return	null se non esistono Autore nel database con quell'attribute
	 */
	public Autore getAutore(Object o, String attributeName){
		return (Autore)getObjectFindByAttribute(o,attributeName);
	}

	@Override
	public Class<?> getThisClass() {
		return this.getClass();
	}
}


//	public List<Autore> getAllAutore(){
//		try{
//			return this.em.createNamedQuery("Autore.findAll", Autore.class).getResultList();
//		}catch (NoResultException error){
//			return null;
//		}
//	}
//	/**
//	 * @param o
//	 * @param queryName
//	 * @param byParameter
//	 * @return l'Autore che ha l'Object o come attributo.
//	 */
//	public Autore getAutoreFindBy(Object o, String queryName, String byParameter){
//		try {
//			return this.em.createNamedQuery(queryName, Autore.class).setParameter(byParameter, o).getSingleResult();
//		} catch (NoResultException e) {
//			return null;
//		}
//	}
//	
//	/**
//	 * Costruisce la query da passare al metodo getAutoreFindBy(...)
//	 * @param o Oggetto in base al quale ricercare l'Autore
//	 * @param attribute Attributo in base al quale ricercare l'Autore
//	 * @return	L'autore trovato con il parametro attributo
//	 * @return	null se l'autore non esiste in base all'attributo
//	 */
//	public Autore getAutoreFindByAttribute(Object o, String attribute) {
//		String iniziale = attribute.substring(0, 1).toUpperCase();	// Primo carattere maiuscolo 	  (A)
//		String finale = attribute.substring(1).toLowerCase();		// Nome dell'attributo minuscolo 	(ttributo)
//		String queryName = "Autore.findBy" + iniziale + finale;		// String queryName = "Autore.findByAttributo"
//		
//		return getAutoreFindBy(o, queryName, attribute);
//	}
//	