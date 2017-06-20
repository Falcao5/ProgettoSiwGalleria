
/**
 * 
 * @author Marte Valerio Falcone & Francesco Lauzi
 * @version 1.0
 * @category Persistence entities
 * 
 */

package it.uniroma3.spring.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="autori")
public class Autore {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AUTORE_ID")
	private Long id;
	
	@Column(nullable=false, length=50)
	private String nome;
	
	@Column(nullable=false, length=50, unique=true)
	private String cognome;
	
	@Column(nullable=true, length=200)
	private String nazionalita;

	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataDiNascita;

	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataDiMorte;
	
	@OneToMany(mappedBy="autore", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	
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
		this.quadri = new LinkedList<>();
	}
	
	public Autore(){
		this.quadri = new LinkedList<>();
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
	
	/**
	 * @return the quadri
	 */
	public List<Quadro> getQuadri() {
		return quadri;
	}

	/**
	 * @param quadri the quadri to set
	 */
	public void setQuadri(List<Quadro> quadri) {
		this.quadri = quadri;
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
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((dataDiMorte == null) ? 0 : dataDiMorte.hashCode());
		result = prime * result + ((dataDiNascita == null) ? 0 : dataDiNascita.hashCode());
		result = prime * result + ((nazionalita == null) ? 0 : nazionalita.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Autore other = (Autore) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (dataDiMorte == null) {
			if (other.dataDiMorte != null)
				return false;
		} else if (!dataDiMorte.equals(other.dataDiMorte))
			return false;
		if (dataDiNascita == null) {
			if (other.dataDiNascita != null)
				return false;
		} else if (!dataDiNascita.equals(other.dataDiNascita))
			return false;
		if (nazionalita == null) {
			if (other.nazionalita != null)
				return false;
		} else if (!nazionalita.equals(other.nazionalita))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
