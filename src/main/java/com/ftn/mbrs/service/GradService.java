package com.ftn.mbrs.service;

import java.util.List;

import com.ftn.mbrs.model.Grad;

public interface GradService {

	public Grad save(Grad grad);
	
	public Grad update(Grad grad);

	public String delete(Long id);
	
	public Grad findOne(Long id);
	
	public List<Grad> findAll();
}
