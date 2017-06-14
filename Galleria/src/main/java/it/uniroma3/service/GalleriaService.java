package it.uniroma3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

@Service
public class GalleriaService<T>{
	
	@PersistenceContext(unitName="galleria")
	protected EntityManager em;
	
	public GalleriaService(){
		
	}
	
	private String primaLetteraToUpperCase(String stringa){
		String primaLettera = stringa.substring(0, 1).toUpperCase();	// Primo carattere maiuscolo 	  (S)
		String resto = stringa.substring(1);						// Nome dell'attributo minuscolo 	(tringa)
		return primaLettera + resto;
	}
	
	private String queryBuilder(String attributeName, String className){
		// String queryName = "ClassName.findByAttributoName"
		String queryName = primaLetteraToUpperCase(className) + ".findBy" + primaLetteraToUpperCase(attributeName);
		
		return queryName;
	}
	
	/**
	 * Cerca nel database un Object in base a un attributo. Questo attributo ha il tipo di o, e il nome dell'attributo è attributeName 
	 * @param o Oggetto in base al quale ricercare l'Object
	 * @param nome dell'attributo in base al quale effettuare la ricerca
	 * @return	L'oggetto x di tipo T, con il campo attributeName uguale all'oggetto o
	 * @return	null se non esistono Object nel database con quell'attributeName
	 */
	public T getObjectFindByAttribute(Object o, String attributeName, String className, Class<?> c){
		String queryName = queryBuilder(attributeName, className);
		return (T)this.getObjectFindBy(o, queryName, attributeName, c);
	}
	
	/**
	 * Restituisce l'Object trovato nel database in base all'attributo tipato o, e con nome dell'attributo byParameter
	 * Metodo di supporto a getObjectFindByAttribute(...)
	 * @param o
	 * @param queryName
	 * @param byParameter
	 * @return l'Object che ha l'Object o come attributo.
	 */
	@SuppressWarnings("unchecked")
	private T getObjectFindBy(Object o, String queryName, String byParameter, Class<?> c){
		try {
			return (T)this.em.createNamedQuery(queryName, c).setParameter(byParameter, o).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll(String className, Class<?> c){

		try{
			return (List<T>) this.em.createNamedQuery(className + ".findAll", c).getResultList();
		}catch (NoResultException error){
			return null;
		}
		
	}
	
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
