package com.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.mbrs.model.ModelVozila;
import com.ftn.mbrs.repository.ModelVozilaRepository;
import com.ftn.mbrs.model.Kartica;
import com.ftn.mbrs.repository.KarticaRepository;

import com.ftn.mbrs.model.Punjenje;
import com.ftn.mbrs.repository.PunjenjeRepository;

import com.ftn.mbrs.service.VoziloService;
import com.ftn.mbrs.model.Vozilo;
import com.ftn.mbrs.repository.VoziloRepository;

@Service
public class VoziloServiceImpl implements VoziloService{

	@Autowired
	private VoziloRepository voziloRepository;

	@Autowired
	private PunjenjeRepository punjenjeRepository;
	
			
	@Autowired
	private ModelVozilaRepository modelVozilaRepository;
	
	@Autowired
	private KarticaRepository karticaRepository;
	
	
	@Override
	public Vozilo save(Vozilo vozilo, Long modelVozilaId, Long karticaId) {
		ModelVozila modelVozila =  modelVozilaRepository.getOne(modelVozilaId);
		vozilo.setModelVozila(modelVozila);
	
		Kartica kartica =  karticaRepository.getOne(karticaId);
		vozilo.setKartica(kartica);
	
		return voziloRepository.save(vozilo);
	}

	//
	@Override
	public Vozilo update(Vozilo vozilo) {		
		Vozilo tempVozilo = voziloRepository.getOne(vozilo.getId());
		
		tempVozilo.setRegistracioniBroj(vozilo.getRegistracioniBroj());    	
    	 	
		ModelVozila tempModelVozila = modelVozilaRepository.getOne(vozilo.getModelVozila().getId());
		tempVozilo.setModelVozila(tempModelVozila);
		Kartica tempKartica = karticaRepository.getOne(vozilo.getKartica().getId());
		tempVozilo.setKartica(tempKartica);
		
		return voziloRepository.save(tempVozilo);
	}

	//
	@Override
	public String delete(Long id) {
		Vozilo vozilo = voziloRepository.getOne(id);
		
		List<Punjenje> punjenjes = punjenjeRepository.findByVozilo(vozilo);
		if(!punjenjes.isEmpty()) {
			return "ERROR";
		}    	
		
		voziloRepository.deleteById(id);
		return "OK";
	}

	@Override
	public Vozilo findOne(Long id) {
		return voziloRepository.getOne(id);
	}

	@Override
	public List<Vozilo> findAll() {
		return voziloRepository.findAll();
	}

}
