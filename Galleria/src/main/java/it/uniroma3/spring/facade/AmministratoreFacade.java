/**
 * @author Marte Valerio Falcone & Francesco Lauzi
 * 
 */
package it.uniroma3.spring.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import it.uniroma3.spring.model.Amministratore;

@Stateless
@EJB(name="ejb/AmministratoreFacade", beanInterface=AmministratoreFacade.class, beanName="AmministratoreFacade")
public class AmministratoreFacade extends AbstractFacade{

	public AmministratoreFacade(){
		
	}
	
	public Amministratore createAmministratore(String nome, String password){
		Amministratore a= new Amministratore();
		a.setNome(nome);
		a.setPassword(password);
		this.em.persist(a);
		return a;
	}
	
	/**
	 * Cerca nel database un Amministraotre in base a un attributo. Questo attributo ha il tipo di o, e il nome dell'attributo è attributeName
	 * @param o Oggetto in base al quale ricercare l'Amministratore
	 * @param attribute String in base al quale ricercare l'Amministratore
	 * @return	L'Amministratore trovato con il parametro attributeName
	 * @return	null se non esistono Amministratore nel database con quell'attributeName
	 */
	public Amministratore getAmministratore(Object o, String attributeName){
		return (Amministratore)this.getObjectFindByAttribute(o, attributeName);
	}

	@Override
	public Class<?> getThisClass() {
		return this.getClass();
	}
	
}
