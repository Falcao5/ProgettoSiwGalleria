/**
 * 
 * @author falcao5
 * @version 1.0
 * @category Persistence entities
 * 
 */

package it.uniroma3.spring.model;

import java.util.Date;

public class Autore {

	private String nome;
	private String cognome;
	private String nazionalita;
	private Date dataDiNascita;
	private Date dataDiMorte;
	/**
	 * @param nome
	 * @param cognome
	 * @param nazionalita
	 * @param dataDiNascita
	 * @param dataDiMorte
	 */
	public Autore(String nome, String cognome, String nazionalita, Date dataDiNascita, Date dataDiMorte) {
		this.nome = nome;
		this.cognome = cognome;
		this.nazionalita = nazionalita;
		this.dataDiNascita = dataDiNascita;
		this.dataDiMorte = dataDiMorte;
	}
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}
	
	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	/**
	 * @return the nazionalita
	 */
	public String getNazionalita() {
		return nazionalita;
	}
	
	/**
	 * @param nazionalita the nazionalita to set
	 */
	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}
	
	/**
	 * @return the dataDiNascita
	 */
	public Date getDataDiNascita() {
		return dataDiNascita;
	}
	
	/**
	 * @param dataDiNascita the dataDiNascita to set
	 */
	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	
	/**
	 * @return the dataDiMorte
	 */
	public Date getDataDiMorte() {
		return dataDiMorte;
	}
	
	/**
	 * @param dataDiMorte the dataDiMorte to set
	 */
	public void setDataDiMorte(Date dataDiMorte) {
		this.dataDiMorte = dataDiMorte;
	}
	
}
