package com.ftn.mbrs.service;

import java.util.List;

import com.ftn.mbrs.model.TipPrikljucka;

public interface TipPrikljuckaService {

	public TipPrikljucka save(TipPrikljucka tipPrikljucka);
	
	public TipPrikljucka update(TipPrikljucka tipPrikljucka);

	public String delete(Long id);
	
	public TipPrikljucka findOne(Long id);
	
	public List<TipPrikljucka> findAll();
}
