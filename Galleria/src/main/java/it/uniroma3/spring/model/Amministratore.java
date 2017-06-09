/**
 * 
 * @author falcao5
 * @version 1.0
 * @category Persistence entities
 * 
 */

package it.uniroma3.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="amministratori")
@NamedQueries({
	@NamedQuery(name = "Amministratore.findByNome", query = "SELECT a FROM Amministratore a WHERE a.nome = :nome"),
	@NamedQuery(name="Amministratore.findById", query="SELECT a FROM Amministratore a WHERE a.id = :id")
})
public class Amministratore {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String nome;
	
	@Column(nullable=false)
	private String password;
	
	public Amministratore(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
  
  @Override
	public String toString() {
		return id + "";
	}

}
