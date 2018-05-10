package com.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.mbrs.model.TipPrikljucka;
import com.ftn.mbrs.repository.TipPrikljuckaRepository;
import com.ftn.mbrs.model.Cenovnik;
import com.ftn.mbrs.repository.CenovnikRepository;


import com.ftn.mbrs.service.StavkaCenovnikaService;
import com.ftn.mbrs.model.StavkaCenovnika;
import com.ftn.mbrs.repository.StavkaCenovnikaRepository;

@Service
public class StavkaCenovnikaServiceImpl implements StavkaCenovnikaService{

	@Autowired
	private StavkaCenovnikaRepository stavkaCenovnikaRepository;

			
	@Autowired
	private TipPrikljuckaRepository tipPrikljuckaRepository;
	
	@Autowired
	private CenovnikRepository cenovnikRepository;
	
	
	@Override
	public StavkaCenovnika save(StavkaCenovnika stavkaCenovnika, Long tipPrikljuckaId, Long cenovnikId) {
		TipPrikljucka tipPrikljucka =  tipPrikljuckaRepository.getOne(tipPrikljuckaId);
		stavkaCenovnika.setTipPrikljucka(tipPrikljucka);
	
		Cenovnik cenovnik =  cenovnikRepository.getOne(cenovnikId);
		stavkaCenovnika.setCenovnik(cenovnik);
	
		return stavkaCenovnikaRepository.save(stavkaCenovnika);
	}

	//
	@Override
	public StavkaCenovnika update(StavkaCenovnika stavkaCenovnika) {		
		StavkaCenovnika tempStavkaCenovnika = stavkaCenovnikaRepository.getOne(stavkaCenovnika.getId());
		
		tempStavkaCenovnika.setCena(stavkaCenovnika.getCena());    	
		tempStavkaCenovnika.setPorez(stavkaCenovnika.getPorez());    	
    	 	
		TipPrikljucka tempTipPrikljucka = tipPrikljuckaRepository.getOne(stavkaCenovnika.getTipPrikljucka().getId());
		tempStavkaCenovnika.setTipPrikljucka(tempTipPrikljucka);
		Cenovnik tempCenovnik = cenovnikRepository.getOne(stavkaCenovnika.getCenovnik().getId());
		tempStavkaCenovnika.setCenovnik(tempCenovnik);
		
		return stavkaCenovnikaRepository.save(tempStavkaCenovnika);
	}

	//
	@Override
	public String delete(Long id) {
		StavkaCenovnika stavkaCenovnika = stavkaCenovnikaRepository.getOne(id);
		
		
		stavkaCenovnikaRepository.deleteById(id);
		return "OK";
	}

	@Override
	public StavkaCenovnika findOne(Long id) {
		return stavkaCenovnikaRepository.getOne(id);
	}

	@Override
	public List<StavkaCenovnika> findAll() {
		return stavkaCenovnikaRepository.findAll();
	}

}
