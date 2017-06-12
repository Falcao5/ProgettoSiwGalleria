package it.uniroma3.spring.facade;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractFacade {
	
	@PersistenceContext(unitName="uniroma3")
	protected EntityManager em;
	
	public AbstractFacade(){
		
	}
	
	public AbstractFacade(EntityManager em){
		this.em = em;
	}
	
	/**
	 * Cerca nel database un Object in base a un attributo. Questo attributo ha il tipo di o, e il nome dell'attributo è attribute 
	 * @param o Oggetto in base al quale ricercare l'Object
	 * @param attribute String in base al quale ricercare l'Object
	 * @return	L'Object trovato con il parametro attributo
	 * @return	null se non esistono Object nel database con quell'attribute
	 */
	protected Object getObjectFindByAttribute(Object o, String attribute) {
		String iniziale = attribute.substring(0, 1).toUpperCase();			// Primo carattere maiuscolo 	  (A)
		String finale = attribute.substring(1).toLowerCase();				// Nome dell'attributo minuscolo 	(ttributo)
		String nomeClasse = trovaNomeDiQuestaClasse();
		String queryName = nomeClasse + ".findBy" + iniziale + finale;		// String queryName = "Autore.findByAttributo"
		
		return this.getObjectFindBy(o, queryName, attribute);
	}
	
	/**
	 *  Questo metodo serve per ottenere il nome della classe 
	 *  Metodo di supporto a getObjectFindByAttribute(...)
	 * @return il nome della classe senza Facade finale
	 */
	private String trovaNomeDiQuestaClasse(){
		String nomeIntero = this.getThisClass().getSimpleName();	// Prendi il nome della classe
		String result = "";											// Init
		for(int i = 0; i<nomeIntero.length()+1 ; i++){				// Per ogni carattere del nome della classe
			if(!nomeIntero.substring(i).equals("Facade")){			// Se il resto del nome della classe non è "Facade"
				result = result + nomeIntero.charAt(i);				// Aggiungi il carattere alla stringa result
			} else {												// Altrimenti
				break;												// Interrompi il ciclo for
			}
		}
		
		return result;
	}
	
	/**
	 * Restituisce l'Object trovato nel database in base all'attributo tipato o, e con nome dell'attributo byParameter
	 * Metodo di supporto a getObjectFindByAttribute(...)
	 * @param o
	 * @param queryName
	 * @param byParameter
	 * @return l'Object che ha l'Object o come attributo.
	 */
	private Object getObjectFindBy(Object o, String queryName, String byParameter){
		try {
			return this.em.createNamedQuery(queryName, this.getThisClass()).setParameter(byParameter, o).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<?> getAll(){
		try{
			return this.em.createNamedQuery(this.trovaNomeDiQuestaClasse() + ".findAll", getThisClass()).getResultList();
		}catch (NoResultException error){
			return null;
		}
	}
	
	/**
	 * 
	 * @return l'oggetto Class della relativa sottoclasse
	 */
	abstract public Class<?> getThisClass();

	/**
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}

	/**
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}
}
