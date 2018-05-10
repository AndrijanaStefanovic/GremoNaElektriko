package com.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ftn.mbrs.model.Vozilo;
import com.ftn.mbrs.repository.VoziloRepository;

import com.ftn.mbrs.service.KarticaService;
import com.ftn.mbrs.model.Kartica;
import com.ftn.mbrs.repository.KarticaRepository;

@Service
public class KarticaServiceImpl implements KarticaService{

	@Autowired
	private KarticaRepository karticaRepository;

	@Autowired
	private VoziloRepository voziloRepository;
	
			
	
	@Override
	public Kartica save(Kartica kartica) {
		return karticaRepository.save(kartica);
	}

	//
	@Override
	public Kartica update(Kartica kartica) {		
		Kartica tempKartica = karticaRepository.getOne(kartica.getId());
		
		tempKartica.setImeVlasnika(kartica.getImeVlasnika());    	
		tempKartica.setPrezimeVlasnika(kartica.getPrezimeVlasnika());    	
		tempKartica.setKredit(kartica.getKredit());    	
    	 	
		
		return karticaRepository.save(tempKartica);
	}

	//
	@Override
	public String delete(Long id) {
		Kartica kartica = karticaRepository.getOne(id);
		
		List<Vozilo> vozilos = voziloRepository.findByKartica(kartica);
		if(!vozilos.isEmpty()) {
			return "ERROR";
		}    	
		
		karticaRepository.deleteById(id);
		return "OK";
	}

	@Override
	public Kartica findOne(Long id) {
		return karticaRepository.getOne(id);
	}

	@Override
	public List<Kartica> findAll() {
		return karticaRepository.findAll();
	}

}
