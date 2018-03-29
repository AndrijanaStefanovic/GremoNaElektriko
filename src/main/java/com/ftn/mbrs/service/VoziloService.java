package com.ftn.mbrs.service;

import java.util.List;

import com.ftn.mbrs.model.Vozilo;

public interface VoziloService {

	public Vozilo save(Vozilo vozilo, Long karticaId);
	
	public Vozilo update(Vozilo vozilo);

	public void delete(Long id);
	
	public Vozilo findOne(Long id);
	
	public List<Vozilo> findAll();
}
