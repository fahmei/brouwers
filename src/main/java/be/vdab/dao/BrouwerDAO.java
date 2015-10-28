package be.vdab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Brouwer;

public interface BrouwerDAO extends JpaRepository<Brouwer, Long>{
	
	List<Brouwer> findByNaamContaining(String beginNaam);
	List<Brouwer> findByNaamStartingWith(Character gekozenLetter);
	
}
