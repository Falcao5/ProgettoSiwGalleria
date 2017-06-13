/**
 * @author Marte Valerio Falcone & Francesco Lauzi
 * 
 */
package it.uniroma3.spring.facade;

import it.uniroma3.spring.model.Amministratore;


public class AmministratoreFacade extends AbstractFacade<Amministratore>{
	
	public AmministratoreFacade(){
		super();
	}
	
	public Amministratore createAmministratore(String nome, String password){
		Amministratore a = new Amministratore();
		a.setNome(nome);
		a.setPassword(password);
		super.em.persist(a);
		return a;
	}
	
	@Override
	public Class<?> getThisClass() {
		return this.getClass();
	}
	
}
