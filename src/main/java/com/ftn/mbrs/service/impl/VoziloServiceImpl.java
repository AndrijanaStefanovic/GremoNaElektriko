package com.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.mbrs.model.Kartica;
import com.ftn.mbrs.model.Vozilo;
import com.ftn.mbrs.repository.KarticaRepository;
import com.ftn.mbrs.repository.VoziloRepository;
import com.ftn.mbrs.service.VoziloService;

@Service
public class VoziloServiceImpl implements VoziloService{

	@Autowired
	private VoziloRepository voziloRepository;
	
	@Autowired
	private KarticaRepository karticaRepository;
	
	@Override
	public Vozilo save(Vozilo vozilo, Long karticaId) {
		System.out.println("1");
		Kartica kartica = karticaRepository.getOne(karticaId);
		System.out.println("2");
		vozilo.setKartica(kartica);
		System.out.println("3");
		return voziloRepository.save(vozilo);
	}

	@Override
	public Vozilo update(Vozilo vozilo) {
		Vozilo temp = voziloRepository.getOne(vozilo.getId());
		temp.setRegistracioniBroj(vozilo.getRegistracioniBroj());
		return voziloRepository.save(temp);
	}

	@Override
	public void delete(Long id) {
		voziloRepository.deleteById(id);
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
