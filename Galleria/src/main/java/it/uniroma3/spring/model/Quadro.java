/**
 * 
 * @author falcao5
 * @version 1.0
 * @category Persistence entities
 * 
 */

package it.uniroma3.spring.model;

import java.awt.Dimension;

public class Quadro extends Opera{
	
	private String titolo;
	private Integer anno;
	private String tecnica;
	private Dimension dimensioni;
	
	/**
	 * @param autore
	 * @param titolo
	 * @param anno
	 * @param tecnica
	 * @param dimensioni
	 */
	public Quadro(Autore autore, String titolo, Integer anno, String tecnica, Dimension dimensioni) {
		super(autore);
		this.titolo = titolo;
		this.anno = anno;
		this.tecnica = tecnica;
		this.dimensioni = dimensioni;
	}

	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * @return the anno
	 */
	public Integer getAnno() {
		return anno;
	}

	/**
	 * @param anno the anno to set
	 */
	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	/**
	 * @return the tecnica
	 */
	public String getTecnica() {
		return tecnica;
	}

	/**
	 * @param tecnica the tecnica to set
	 */
	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	/**
	 * @return the dimensioni
	 */
	public Dimension getDimensioni() {
		return dimensioni;
	}

	/**
	 * @param dimensioni the dimensioni to set
	 */
	public void setDimensioni(Dimension dimensioni) {
		this.dimensioni = dimensioni;
	}
	
}
