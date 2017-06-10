/**
 * 
 * @author Marte Valerio Falcone & Francesco Lauzi
 * @version 1.0
 * @category Persistence entities
 * 
 */

package it.uniroma3.spring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="autori")
@NamedQueries({
	@NamedQuery(name = "Autore.findAll", query = "SELECT a FROM Autore a"),
	@NamedQuery(name="Autore.findById", query="SELECT a FROM Autore a WHERE a.id = :id"),
	@NamedQuery(name="Autore.findByNome", query="SELECT a FROM Autore a WHERE a.nome = :nome"),
	@NamedQuery(name="Autore.findByCognome", query="SELECT a FROM Autore a WHERE a.cognome = :cognome"),
	@NamedQuery(name="Autore.findByNazionalita", query="SELECT a FROM Autore a WHERE a.nazionalita = :nazionalita"),
	@NamedQuery(name="Autore.findByDataDiNascita", query="SELECT a FROM Autore a WHERE a.dataDiNascita = :dataDiNascita"),
	@NamedQuery(name="Autore.findByDataDiMorte", query="SELECT a FROM Autore a WHERE a.dataDiMorte = :dataDiMorte")
})
public class Autore {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, length=50)
	private String nome;
	
	@Column(nullable=false, length=50)
	private String cognome;
	
	@Column(nullable=true, length=200)
	private String nazionalita;

	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dataDiNascita;

	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dataDiMorte;
	
	@OneToMany(mappedBy="autore")
	private List<Quadro> quadri;
	
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
	
	@Override
	public String toString() {
		return this.id + "";
	}

}
