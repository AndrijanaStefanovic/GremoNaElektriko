package com.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.mbrs.model.Stanica;
import com.ftn.mbrs.repository.StanicaRepository;


import com.ftn.mbrs.service.RadnoVremeService;
import com.ftn.mbrs.model.RadnoVreme;
import com.ftn.mbrs.repository.RadnoVremeRepository;

@Service
public class RadnoVremeServiceImpl implements RadnoVremeService{

	@Autowired
	private RadnoVremeRepository radnoVremeRepository;

			
	@Autowired
	private StanicaRepository stanicaRepository;
	
	
	@Override
	public RadnoVreme save(RadnoVreme radnoVreme, Long stanicaId) {
		Stanica stanica =  stanicaRepository.getOne(stanicaId);
		radnoVreme.setStanica(stanica);
	
		return radnoVremeRepository.save(radnoVreme);
	}

	//
	@Override
	public RadnoVreme update(RadnoVreme radnoVreme) {		
		RadnoVreme tempRadnoVreme = radnoVremeRepository.getOne(radnoVreme.getId());
		
		tempRadnoVreme.setDanUNedelji(radnoVreme.getDanUNedelji());    	
		tempRadnoVreme.setVremeOtvaranja(radnoVreme.getVremeOtvaranja());    	
		tempRadnoVreme.setVremeZatvaranja(radnoVreme.getVremeZatvaranja());    	
    	 	
		Stanica tempStanica = stanicaRepository.getOne(radnoVreme.getStanica().getId());
		tempRadnoVreme.setStanica(tempStanica);
		
		return radnoVremeRepository.save(tempRadnoVreme);
	}

	//
	@Override
	public String delete(Long id) {
		RadnoVreme radnoVreme = radnoVremeRepository.getOne(id);
		
		
		radnoVremeRepository.deleteById(id);
		return "OK";
	}

	@Override
	public RadnoVreme findOne(Long id) {
		return radnoVremeRepository.getOne(id);
	}

	@Override
	public List<RadnoVreme> findAll() {
		return radnoVremeRepository.findAll();
	}

}
