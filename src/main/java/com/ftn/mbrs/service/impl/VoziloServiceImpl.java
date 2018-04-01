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
		Kartica kartica = karticaRepository.getOne(karticaId);
		vozilo.setKartica(kartica);
		return voziloRepository.save(vozilo);
	}

	@Override
	public Vozilo update(Vozilo vozilo) {
		Vozilo tempVozilo = voziloRepository.getOne(vozilo.getId());
		Kartica tempKartica = karticaRepository.getOne(vozilo.getKartica().getId());
		tempVozilo.setRegistracioniBroj(vozilo.getRegistracioniBroj());
		tempVozilo.setKartica(tempKartica);
		return voziloRepository.save(tempVozilo);
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
