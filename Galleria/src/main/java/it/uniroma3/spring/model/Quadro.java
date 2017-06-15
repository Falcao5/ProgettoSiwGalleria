/**
 * 
 * @author Marte Valerio Falcone & Francesco Lauzi
 * @version 1.0
 * @category Persistence entities
 * 
 */

package it.uniroma3.spring.model;

import java.awt.Dimension;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//@Table(name="quadri")
//@NamedQueries({
//	@NamedQuery(name="Quadro.findAll", query="SELECT q FROM Quadro q"),
//	@NamedQuery(name="Quadro.findById", query="SELECT q FROM Quadro q WHERE q.id = :id"),
//	@NamedQuery(name="Quadro.findByTitolo", query="SELECT q FROM Quadro q WHERE q.titolo = :titolo"),
//	@NamedQuery(name="Quadro.findByAnno", query="SELECT q FROM Quadro q WHERE q.anno = :anno")
//})

@Table(name="quadri")
@Entity
public class Quadro{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, length=100)
	private String titolo;
	
	@Column(nullable=false)
	private Integer anno;
	
	@Column(nullable=false, length=200)
	private String tecnica;

	@Column(nullable=false)
	private Dimension dimensioni;
	
	@ManyToOne
	@JoinColumn(name="AUTORE_ID")
	private Autore autore;
	
	/**
	 * Constructor without parameters
	 */
	public Quadro(){
		
	}
	
	/**
	 * @param autore
	 * @param titolo
	 * @param anno
	 * @param tecnica
	 * @param dimensioni
	 */
	public Quadro(String titolo, Integer anno, String tecnica, Dimension dimensioni, Autore autore) {
		this.titolo = titolo;
		this.anno = anno;
		this.tecnica = tecnica;
		this.dimensioni = dimensioni;
//		this.autore = autore;
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
	
	/**
	 * @return the autore
	 */
//	public Autore getAutore() {
//		return autore;
//	}

	/**
	 * @param autore the autore to set
	 */
//	public void setAutore(Autore autore) {
//		this.autore = autore;
//	}

	@Override
	public String toString() {
		return this.id + "";
	}
}
