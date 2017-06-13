package it.uniroma3.spring.facade;

import java.util.List;

import javax.persistence.EntityManager;

import it.uniroma3.service.GalleriaService;

public abstract class AbstractFacade<T> {
	
	private GalleriaService<T> service = new GalleriaService<T>();
	
	protected EntityManager em;
	
	public AbstractFacade(){
		this.em = this.service.getEm();
	}
	
	/**
	 * Cerca nel database un Object in base a un attributo. Questo attributo ha il tipo di o, e il nome dell'attributo è attributeName 
	 * @param o Oggetto in base al quale ricercare l'Object
	 * @param nome dell'attributo in base al quale effettuare la ricerca
	 * @return	L'oggetto x di tipo T, con il campo attributeName uguale all'oggetto o
	 * @return	null se non esistono Object nel database con quell'attributeName
	 */
	public T getObjectFindByAttribute(Object o, String attributeName){
		String className = this.trovaNomeDiQuestaClasse();
		return this.service.getObjectFindByAttribute(o, attributeName, className, this.getThisClass());
	}
	
	/**
	 * 
	 * @return la lista di tutti gli oggetti di tipo T
	 */
	public List<T> getAll(){
		String className = trovaNomeDiQuestaClasse();
		return this.service.getAll(className, this.getThisClass());
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
