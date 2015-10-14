package be.vdab.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Adres;

@Repository
class BrouwerDAOImpl implements BrouwerDAO {

	private final Map<Long, Brouwer> brouwers = new ConcurrentHashMap<>();
	
	
	public BrouwerDAOImpl() {
		brouwers.put(1L, new Brouwer(1L, "brouwer1", new Adres("straat", "12a", 1000, "Brussel"), null));
		brouwers.put(2L, new Brouwer(2L, "brouwer2", new Adres("straat", "19a", 1000, "Brussel"), 50000));
		brouwers.put(3L, new Brouwer(3L, "brouwer3", new Adres("straat", "13a", 1000, "Brussel"), null));
	}

	@Override
	public void create(Brouwer brouwer) {
		brouwers.put(brouwer.getBrouwerNr(), brouwer);
	}

	@Override
	public List<Brouwer> findAll() { 
		return new ArrayList<>(brouwers.values());
	}

	@Override
	public List<Brouwer> findByNaam(String beginNaam) {
		List<Brouwer> gevondenBrouwers = new ArrayList<>();
		
		for(Brouwer brouwer: brouwers.values()){
			if(brouwer.getNaam().contains(beginNaam)){
				gevondenBrouwers.add(brouwer);
			}
		}
		return gevondenBrouwers;
	}

}
