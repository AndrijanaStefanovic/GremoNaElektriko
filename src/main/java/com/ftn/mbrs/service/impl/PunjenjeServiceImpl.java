package com.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.mbrs.model.Vozilo;
import com.ftn.mbrs.repository.VoziloRepository;
import com.ftn.mbrs.model.TipPrikljucka;
import com.ftn.mbrs.repository.TipPrikljuckaRepository;
import com.ftn.mbrs.model.Stanica;
import com.ftn.mbrs.repository.StanicaRepository;


import com.ftn.mbrs.service.PunjenjeService;
import com.ftn.mbrs.model.Punjenje;
import com.ftn.mbrs.repository.PunjenjeRepository;

@Service
public class PunjenjeServiceImpl implements PunjenjeService{

	@Autowired
	private PunjenjeRepository punjenjeRepository;

			
	@Autowired
	private VoziloRepository voziloRepository;
	
	@Autowired
	private TipPrikljuckaRepository tipPrikljuckaRepository;
	
	@Autowired
	private StanicaRepository stanicaRepository;
	
	
	@Override
	public Punjenje save(Punjenje punjenje, Long voziloId, Long tipPrikljuckaId, Long stanicaId) {
		Vozilo vozilo =  voziloRepository.getOne(voziloId);
		punjenje.setVozilo(vozilo);
	
		TipPrikljucka tipPrikljucka =  tipPrikljuckaRepository.getOne(tipPrikljuckaId);
		punjenje.setTipPrikljucka(tipPrikljucka);
	
		Stanica stanica =  stanicaRepository.getOne(stanicaId);
		punjenje.setStanica(stanica);
	
		return punjenjeRepository.save(punjenje);
	}

	//
	@Override
	public Punjenje update(Punjenje punjenje) {		
		Punjenje tempPunjenje = punjenjeRepository.getOne(punjenje.getId());
		
		tempPunjenje.setPocetakPunjenja(punjenje.getPocetakPunjenja());    	
		tempPunjenje.setKrajPunjenja(punjenje.getKrajPunjenja());    	
    	 	
		Vozilo tempVozilo = voziloRepository.getOne(punjenje.getVozilo().getId());
		tempPunjenje.setVozilo(tempVozilo);
		TipPrikljucka tempTipPrikljucka = tipPrikljuckaRepository.getOne(punjenje.getTipPrikljucka().getId());
		tempPunjenje.setTipPrikljucka(tempTipPrikljucka);
		Stanica tempStanica = stanicaRepository.getOne(punjenje.getStanica().getId());
		tempPunjenje.setStanica(tempStanica);
		
		return punjenjeRepository.save(tempPunjenje);
	}

	//
	@Override
	public String delete(Long id) {
		Punjenje punjenje = punjenjeRepository.getOne(id);
		
		
		punjenjeRepository.deleteById(id);
		return "OK";
	}

	@Override
	public Punjenje findOne(Long id) {
		return punjenjeRepository.getOne(id);
	}

	@Override
	public List<Punjenje> findAll() {
		return punjenjeRepository.findAll();
	}

}
