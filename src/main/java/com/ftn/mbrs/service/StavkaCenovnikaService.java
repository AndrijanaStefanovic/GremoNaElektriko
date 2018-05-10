package com.ftn.mbrs.service;

import java.util.List;

import com.ftn.mbrs.model.StavkaCenovnika;

public interface StavkaCenovnikaService {

	public StavkaCenovnika save(StavkaCenovnika stavkaCenovnika, Long tipPrikljuckaId, Long cenovnikId);
	
	public StavkaCenovnika update(StavkaCenovnika stavkaCenovnika);

	public String delete(Long id);
	
	public StavkaCenovnika findOne(Long id);
	
	public List<StavkaCenovnika> findAll();
}
