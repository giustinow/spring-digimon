package it.dstech.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.dstech.model.Digimon;

public interface DigimonRepository extends CrudRepository<Digimon, Long> {
	
	@Query("select d from Digimon d order by hp DESC")
    List<Digimon> sortHp();
	@Query("select d from Digimon d order by atk DESC")
    List<Digimon> sortAtk();
	@Query("select d from Digimon d order by def DESC")
    List<Digimon> sortDef();
	@Query("select d from Digimon d order by res DESC")
    List<Digimon> sortRes();
}
