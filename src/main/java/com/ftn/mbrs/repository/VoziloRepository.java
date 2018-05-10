package com.ftn.mbrs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.mbrs.model.Vozilo;
import com.ftn.mbrs.model.ModelVozila;
import com.ftn.mbrs.model.Kartica;

public interface VoziloRepository extends JpaRepository<Vozilo, Long> {

	public List<Vozilo> findByModelVozila(ModelVozila modelVozila);
	public List<Vozilo> findByKartica(Kartica kartica);

}