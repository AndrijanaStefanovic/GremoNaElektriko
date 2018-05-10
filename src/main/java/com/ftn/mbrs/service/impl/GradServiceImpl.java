package com.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ftn.mbrs.model.Stanica;
import com.ftn.mbrs.repository.StanicaRepository;

import com.ftn.mbrs.service.GradService;
import com.ftn.mbrs.model.Grad;
import com.ftn.mbrs.repository.GradRepository;

@Service
public class GradServiceImpl implements GradService{

	@Autowired
	private GradRepository gradRepository;

	@Autowired
	private StanicaRepository stanicaRepository;
	
			
	
	@Override
	public Grad save(Grad grad) {
		return gradRepository.save(grad);
	}

	//
	@Override
	public Grad update(Grad grad) {		
		Grad tempGrad = gradRepository.getOne(grad.getId());
		
		tempGrad.setNaziv(grad.getNaziv());    	
    	 	
		
		return gradRepository.save(tempGrad);
	}

	//
	@Override
	public String delete(Long id) {
		Grad grad = gradRepository.getOne(id);
		
		List<Stanica> stanicas = stanicaRepository.findByGrad(grad);
		if(!stanicas.isEmpty()) {
			return "ERROR";
		}    	
		
		gradRepository.deleteById(id);
		return "OK";
	}

	@Override
	public Grad findOne(Long id) {
		return gradRepository.getOne(id);
	}

	@Override
	public List<Grad> findAll() {
		return gradRepository.findAll();
	}

}
