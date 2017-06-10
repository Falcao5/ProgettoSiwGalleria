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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="quadro")
@NamedQueries({
	@NamedQuery(name="Quadro.findAll", query="SELECT q FROM Quadro q"),
	@NamedQuery(name="Quadro.findById", query="SELECT q FROM Quadro q WHERE q.id = :id"),
	@NamedQuery(name="Quadro.findByTitolo", query="SELECT q FROM Quadro q WHERE q.titolo = :titolo"),
	@NamedQuery(name="Quadro.findByAnno", query="SELECT q FROM Quadro q WHERE q.anno = :anno")
})

public class Quadro extends Opera{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	@ManyToOne
	private String titolo;
	
	@Column
	@ManyToOne
	private Integer anno;
	
	@Column
	@ManyToOne
	private String tecnica;

	@Column
	@ManyToOne
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
	
	@Override
	public String toString() {
		return this.id + "";
	}
}
