package com.ftn.mbrs.service;

import java.util.List;

import com.ftn.mbrs.model.Kartica;

public interface KarticaService {

	public Kartica save(Kartica kartica);
	
	public Kartica update(Kartica kartica);

	public String delete(Long id);
	
	public Kartica findOne(Long id);
	
	public List<Kartica> findAll();
}
