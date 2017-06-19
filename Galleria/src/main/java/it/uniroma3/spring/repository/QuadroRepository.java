package it.uniroma3.spring.repository;

import java.awt.Dimension;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Quadro;

public interface QuadroRepository extends CrudRepository<Quadro, Long> {
	
	Quadro findByTitolo(String titolo);
	
	List<Quadro> findByAnno(Integer anno);
	
	List<Quadro> findByTecnica(String tecnica);
	
//	List<Quadro> findByDimensioni(Dimension dimensioni);
	
}
