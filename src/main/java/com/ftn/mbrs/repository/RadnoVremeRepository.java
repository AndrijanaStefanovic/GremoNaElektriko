package com.ftn.mbrs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.mbrs.model.RadnoVreme;
import com.ftn.mbrs.model.Stanica;

public interface RadnoVremeRepository extends JpaRepository<RadnoVreme, Long> {

	public List<RadnoVreme> findByStanica(Stanica stanica);

}