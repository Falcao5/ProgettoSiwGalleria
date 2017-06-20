/**
 * 
 * @author Marte Valerio Falcone & Francesco Lauzi
 * @version 1.0
 * @category Persistence entities
 * 
 */

package it.uniroma3.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="quadri")
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
	private Integer larghezza;
	
	@Column(nullable=false)
	private Integer altezza;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="AUTORE_ID", nullable=false)
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
	public Quadro(String titolo, Integer anno, String tecnica, Integer larghezza, Integer altezza, Autore autore) {
		this.titolo = titolo;
		this.anno = anno;
		this.tecnica = tecnica;
		this.altezza= altezza;
		this.larghezza=larghezza;
		this.autore = autore;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the larghezza
	 */
	public Integer getLarghezza() {
		return larghezza;
	}

	/**
	 * @param larghezza the larghezza to set
	 */
	public void setLarghezza(Integer larghezza) {
		this.larghezza = larghezza;
	}

	/**
	 * @return the altezza
	 */
	public Integer getAltezza() {
		return altezza;
	}

	/**
	 * @param altezza the altezza to set
	 */
	public void setAltezza(Integer altezza) {
		this.altezza = altezza;
	}

	/**
	 * @return the autore
	 */
	public Autore getAutore() {
		return autore;
	}

	/**
	 * @param autore the autore to set
	 */
	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	@Override
	public String toString() {
		return this.id + "";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anno == null) ? 0 : anno.hashCode());
		result = prime * result + ((autore == null) ? 0 : autore.hashCode());
		result = prime * result + ((larghezza == null) ? 0 : larghezza.hashCode());
		result = prime * result + ((altezza == null) ? 0 : altezza.hashCode());
		result = prime * result + ((tecnica == null) ? 0 : tecnica.hashCode());
		result = prime * result + ((titolo == null) ? 0 : titolo.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quadro other = (Quadro) obj;
		if (anno == null) {
			if (other.anno != null)
				return false;
		} else if (!anno.equals(other.anno))
			return false;
		if (autore == null) {
			if (other.autore != null)
				return false;
		} else if (!autore.equals(other.autore))
			return false;
		if (larghezza == null) {
			if (other.larghezza != null)
				return false;
		} else if (!larghezza.equals(other.larghezza))
			return false;
		if (altezza == null) {
			if (other.altezza != null)
				return false;
		} else if (!altezza.equals(other.altezza))
			return false;
		if (tecnica == null) {
			if (other.tecnica != null)
				return false;
		} else if (!tecnica.equals(other.tecnica))
			return false;
		if (titolo == null) {
			if (other.titolo != null)
				return false;
		} else if (!titolo.equals(other.titolo))
			return false;
		return true;
	}
}
