/**
 * @author Marte Valerio Falcone & Francesco Lauzi
 * 
 */

package it.uniroma3.spring.facade;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;


import it.uniroma3.spring.model.Autore;


public class AutoreFacade extends AbstractFacade<Autore> {

	public AutoreFacade(){
		super();
	}
	
	public AutoreFacade(EntityManager em){
		super(em);
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

	@Override
	public Class<?> getThisClass() {
		return this.getClass();
	}
}
