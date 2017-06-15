package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Amministratore;


public interface AmministratoreRepository extends CrudRepository<Amministratore, Long>{
	
	List<Amministratore> findByUsername(String username);
	
}
