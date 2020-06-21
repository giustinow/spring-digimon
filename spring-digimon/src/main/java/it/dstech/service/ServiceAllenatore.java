package it.dstech.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.model.Allenatore;
import it.dstech.model.Digimon;
import it.dstech.repository.AllenatoreRepository;

@Service
@Transactional
public class ServiceAllenatore {
	@Autowired AllenatoreRepository repo;

	public boolean checkPresenzaDigimonAllenatore(Digimon digimon, Long id) {
		List<Digimon> lista = findAllenatore(id).getLista();
		if(lista.contains(digimon)) {
			return true;
		}return false;
	}
	public boolean checkEsistenza(Long id) {
		if(!repo.findById(id).isEmpty()) {
			return true;
		}return false;
	}
	public void save(Allenatore allenatore) {
		repo.save(allenatore);
	}
	public void saveDigimon(Digimon digimon, Long id) {
		Allenatore utente = repo.findById(id).get();
		utente.getLista().add(digimon);
	}
	public void removeDigimon(Digimon digimon, Long id) {
		Allenatore utente = repo.findById(id).get();
		utente.getLista().remove(digimon);
		digimon.setAllenatore(null);
	}
	
	public List<Digimon> listaDigimonAllenatore(Long id){
		Allenatore utente = findAllenatore(id);
		return utente.getLista();
	}
	public List<Allenatore> listAll() {
		return (List<Allenatore>) repo.findAll();
	}
	
	public Allenatore get(Long id) {
		return repo.findById(id).get();
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
	public Allenatore findAllenatore(Long id) {
		return repo.findById(id).get();
	}
}
