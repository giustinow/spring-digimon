package it.dstech.repository;


import org.springframework.data.repository.CrudRepository;

import it.dstech.model.Digimon;

public interface DigimonRepository extends CrudRepository<Digimon, Long> {
}
