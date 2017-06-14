package it.uniroma3.spring.facade;

import java.awt.Dimension;

import it.uniroma3.spring.model.Quadro;

import it.uniroma3.spring.model.Autore;


public class QuadroFacade extends AbstractFacade<Quadro>{

	public QuadroFacade(){
		super();
	}
	
	public Quadro createQuadro(String titolo, Integer anno, String tecnica, Dimension dimensioni, Autore autoreDellOpera){
		Quadro q=new Quadro();
		q.setTitolo(titolo);
		q.setAnno(anno);
		q.setTecnica(tecnica);
		q.setDimensioni(dimensioni);
//		q.setAutore(autoreDellOpera);
		this.em.persist(q);
		return q;
	}
	
	@Override
	public Class<?> getThisClass() {
		return this.getClass();
	}
}
