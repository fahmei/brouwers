package be.vdab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.BrouwerDAO;
import be.vdab.entities.Brouwer;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
class BrouwerServiceImpl implements BrouwerService {

	private final BrouwerDAO brouwerDAO;
	
	//CONSTRUCTORS
	@Autowired	
	BrouwerServiceImpl(BrouwerDAO brouwerDAO) {
		this.brouwerDAO = brouwerDAO;
	}

	//UPDATE METHODS
	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public void create(Brouwer brouwer) {
		brouwerDAO.save(brouwer);
	}

	
	//LEZEN METHODS
	@Override
	public Page<Brouwer> findAll(Pageable pageable) {
		return brouwerDAO.findAll(pageable);
	}

	@Override
	public List<Brouwer> findByNaam(String beginNaam) {
		return brouwerDAO.findByNaamContaining(beginNaam);
	}

	@Override
	public List<Brouwer> findByFirstLetter(Character gekozenLetter) {
		return brouwerDAO.findByNaamStartingWith(gekozenLetter);
	}

}
