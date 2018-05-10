package com.ftn.mbrs.service;

import java.util.List;

import com.ftn.mbrs.model.MarkaVozila;

public interface MarkaVozilaService {

	public MarkaVozila save(MarkaVozila markaVozila);
	
	public MarkaVozila update(MarkaVozila markaVozila);

	public String delete(Long id);
	
	public MarkaVozila findOne(Long id);
	
	public List<MarkaVozila> findAll();
}
