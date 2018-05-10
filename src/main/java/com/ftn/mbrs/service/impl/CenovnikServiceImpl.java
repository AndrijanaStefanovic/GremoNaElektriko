package com.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ftn.mbrs.model.StavkaCenovnika;
import com.ftn.mbrs.repository.StavkaCenovnikaRepository;

import com.ftn.mbrs.service.CenovnikService;
import com.ftn.mbrs.model.Cenovnik;
import com.ftn.mbrs.repository.CenovnikRepository;

@Service
public class CenovnikServiceImpl implements CenovnikService{

	@Autowired
	private CenovnikRepository cenovnikRepository;

	@Autowired
	private StavkaCenovnikaRepository stavkaCenovnikaRepository;
	
			
	
	@Override
	public Cenovnik save(Cenovnik cenovnik) {
		return cenovnikRepository.save(cenovnik);
	}

	//
	@Override
	public Cenovnik update(Cenovnik cenovnik) {		
		Cenovnik tempCenovnik = cenovnikRepository.getOne(cenovnik.getId());
		
		tempCenovnik.setDatum(cenovnik.getDatum());    	
    	 	
		
		return cenovnikRepository.save(tempCenovnik);
	}

	//
	@Override
	public String delete(Long id) {
		Cenovnik cenovnik = cenovnikRepository.getOne(id);
		
		List<StavkaCenovnika> stavkaCenovnikas = stavkaCenovnikaRepository.findByCenovnik(cenovnik);
		if(!stavkaCenovnikas.isEmpty()) {
			return "ERROR";
		}    	
		
		cenovnikRepository.deleteById(id);
		return "OK";
	}

	@Override
	public Cenovnik findOne(Long id) {
		return cenovnikRepository.getOne(id);
	}

	@Override
	public List<Cenovnik> findAll() {
		return cenovnikRepository.findAll();
	}

}
