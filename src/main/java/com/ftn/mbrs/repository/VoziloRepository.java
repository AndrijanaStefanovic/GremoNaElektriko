package com.ftn.mbrs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.mbrs.model.Kartica;
import com.ftn.mbrs.model.Vozilo;

public interface VoziloRepository extends JpaRepository<Vozilo, Long>{

	public List<Vozilo> findByKartica(Kartica kartica);
}
