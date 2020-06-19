package it.dstech.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.model.Allenatore;
import it.dstech.model.Digimon;
import it.dstech.repository.DigimonRepository;

@Service
@Transactional
public class ServiceDigimon {
	@Autowired DigimonRepository repo;
	
	public Digimon findDigimon(Long id) {
		return repo.findById(id).get();
	}
	public void saveAllenatore(Digimon digimon, Allenatore allenatore) {
		digimon.setAllenatore(allenatore);
	}
	public void save(Digimon digimon) {
		repo.save(digimon);
	}
	public boolean checkAllenatore(Digimon digimon) {
		if(digimon.getAllenatore() != null) {
			return true;
		}return false;
	}
	public List<Digimon> listAll() {
		return (List<Digimon>) repo.findAll();
	}
	
	public Digimon get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
