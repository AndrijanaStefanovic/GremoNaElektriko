package com.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.mbrs.model.Grad;
import com.ftn.mbrs.repository.GradRepository;

import com.ftn.mbrs.model.Punjenje;
import com.ftn.mbrs.repository.PunjenjeRepository;
import com.ftn.mbrs.model.RadnoVreme;
import com.ftn.mbrs.repository.RadnoVremeRepository;

import com.ftn.mbrs.service.StanicaService;
import com.ftn.mbrs.model.Stanica;
import com.ftn.mbrs.repository.StanicaRepository;

@Service
public class StanicaServiceImpl implements StanicaService{

	@Autowired
	private StanicaRepository stanicaRepository;

	@Autowired
	private PunjenjeRepository punjenjeRepository;
	
	@Autowired
	private RadnoVremeRepository radnoVremeRepository;
	
			
	@Autowired
	private GradRepository gradRepository;
	
	
	@Override
	public Stanica save(Stanica stanica, Long gradId) {
		Grad grad =  gradRepository.getOne(gradId);
		stanica.setGrad(grad);
	
		return stanicaRepository.save(stanica);
	}

	//
	@Override
	public Stanica update(Stanica stanica) {		
		Stanica tempStanica = stanicaRepository.getOne(stanica.getId());
		
		tempStanica.setAdresa(stanica.getAdresa());    	
    	 	
		Grad tempGrad = gradRepository.getOne(stanica.getGrad().getId());
		tempStanica.setGrad(tempGrad);
		
		return stanicaRepository.save(tempStanica);
	}

	//
	@Override
	public String delete(Long id) {
		Stanica stanica = stanicaRepository.getOne(id);
		
		List<Punjenje> punjenjes = punjenjeRepository.findByStanica(stanica);
		if(!punjenjes.isEmpty()) {
			return "ERROR";
		}    	
		List<RadnoVreme> radnoVremes = radnoVremeRepository.findByStanica(stanica);
		if(!radnoVremes.isEmpty()) {
			return "ERROR";
		}    	
		
		stanicaRepository.deleteById(id);
		return "OK";
	}

	@Override
	public Stanica findOne(Long id) {
		return stanicaRepository.getOne(id);
	}

	@Override
	public List<Stanica> findAll() {
		return stanicaRepository.findAll();
	}

}
