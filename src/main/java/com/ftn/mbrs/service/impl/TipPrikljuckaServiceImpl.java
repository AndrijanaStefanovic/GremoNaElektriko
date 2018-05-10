package com.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ftn.mbrs.model.ModelVozila;
import com.ftn.mbrs.repository.ModelVozilaRepository;
import com.ftn.mbrs.model.StavkaCenovnika;
import com.ftn.mbrs.repository.StavkaCenovnikaRepository;
import com.ftn.mbrs.model.Punjenje;
import com.ftn.mbrs.repository.PunjenjeRepository;

import com.ftn.mbrs.service.TipPrikljuckaService;
import com.ftn.mbrs.model.TipPrikljucka;
import com.ftn.mbrs.repository.TipPrikljuckaRepository;

@Service
public class TipPrikljuckaServiceImpl implements TipPrikljuckaService{

	@Autowired
	private TipPrikljuckaRepository tipPrikljuckaRepository;

	@Autowired
	private ModelVozilaRepository modelVozilaRepository;
	
	@Autowired
	private StavkaCenovnikaRepository stavkaCenovnikaRepository;
	
	@Autowired
	private PunjenjeRepository punjenjeRepository;
	
			
	
	@Override
	public TipPrikljucka save(TipPrikljucka tipPrikljucka) {
		return tipPrikljuckaRepository.save(tipPrikljucka);
	}

	//
	@Override
	public TipPrikljucka update(TipPrikljucka tipPrikljucka) {		
		TipPrikljucka tempTipPrikljucka = tipPrikljuckaRepository.getOne(tipPrikljucka.getId());
		
		tempTipPrikljucka.setNaziv(tipPrikljucka.getNaziv());    	
		tempTipPrikljucka.setKW(tipPrikljucka.getKW());    	
    	 	
		
		return tipPrikljuckaRepository.save(tempTipPrikljucka);
	}

	//
	@Override
	public String delete(Long id) {
		TipPrikljucka tipPrikljucka = tipPrikljuckaRepository.getOne(id);
		
		List<ModelVozila> modelVozilas = modelVozilaRepository.findByTipPrikljucka(tipPrikljucka);
		if(!modelVozilas.isEmpty()) {
			return "ERROR";
		}    	
		List<StavkaCenovnika> stavkaCenovnikas = stavkaCenovnikaRepository.findByTipPrikljucka(tipPrikljucka);
		if(!stavkaCenovnikas.isEmpty()) {
			return "ERROR";
		}    	
		List<Punjenje> punjenjes = punjenjeRepository.findByTipPrikljucka(tipPrikljucka);
		if(!punjenjes.isEmpty()) {
			return "ERROR";
		}    	
		
		tipPrikljuckaRepository.deleteById(id);
		return "OK";
	}

	@Override
	public TipPrikljucka findOne(Long id) {
		return tipPrikljuckaRepository.getOne(id);
	}

	@Override
	public List<TipPrikljucka> findAll() {
		return tipPrikljuckaRepository.findAll();
	}

}
