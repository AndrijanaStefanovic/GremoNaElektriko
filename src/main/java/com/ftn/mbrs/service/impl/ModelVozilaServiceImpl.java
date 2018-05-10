package com.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.mbrs.model.TipPrikljucka;
import com.ftn.mbrs.repository.TipPrikljuckaRepository;
import com.ftn.mbrs.model.MarkaVozila;
import com.ftn.mbrs.repository.MarkaVozilaRepository;

import com.ftn.mbrs.model.Vozilo;
import com.ftn.mbrs.repository.VoziloRepository;

import com.ftn.mbrs.service.ModelVozilaService;
import com.ftn.mbrs.model.ModelVozila;
import com.ftn.mbrs.repository.ModelVozilaRepository;

@Service
public class ModelVozilaServiceImpl implements ModelVozilaService{

	@Autowired
	private ModelVozilaRepository modelVozilaRepository;

	@Autowired
	private VoziloRepository voziloRepository;
	
			
	@Autowired
	private TipPrikljuckaRepository tipPrikljuckaRepository;
	
	@Autowired
	private MarkaVozilaRepository markaVozilaRepository;
	
	
	@Override
	public ModelVozila save(ModelVozila modelVozila, Long tipPrikljuckaId, Long markaVozilaId) {
		TipPrikljucka tipPrikljucka =  tipPrikljuckaRepository.getOne(tipPrikljuckaId);
		modelVozila.setTipPrikljucka(tipPrikljucka);
	
		MarkaVozila markaVozila =  markaVozilaRepository.getOne(markaVozilaId);
		modelVozila.setMarkaVozila(markaVozila);
	
		return modelVozilaRepository.save(modelVozila);
	}

	//
	@Override
	public ModelVozila update(ModelVozila modelVozila) {		
		ModelVozila tempModelVozila = modelVozilaRepository.getOne(modelVozila.getId());
		
		tempModelVozila.setNaziv(modelVozila.getNaziv());    	
    	 	
		TipPrikljucka tempTipPrikljucka = tipPrikljuckaRepository.getOne(modelVozila.getTipPrikljucka().getId());
		tempModelVozila.setTipPrikljucka(tempTipPrikljucka);
		MarkaVozila tempMarkaVozila = markaVozilaRepository.getOne(modelVozila.getMarkaVozila().getId());
		tempModelVozila.setMarkaVozila(tempMarkaVozila);
		
		return modelVozilaRepository.save(tempModelVozila);
	}

	//
	@Override
	public String delete(Long id) {
		ModelVozila modelVozila = modelVozilaRepository.getOne(id);
		
		List<Vozilo> vozilos = voziloRepository.findByModelVozila(modelVozila);
		if(!vozilos.isEmpty()) {
			return "ERROR";
		}    	
		
		modelVozilaRepository.deleteById(id);
		return "OK";
	}

	@Override
	public ModelVozila findOne(Long id) {
		return modelVozilaRepository.getOne(id);
	}

	@Override
	public List<ModelVozila> findAll() {
		return modelVozilaRepository.findAll();
	}

}
