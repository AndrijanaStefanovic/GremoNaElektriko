package com.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.mbrs.model.Kartica;
import com.ftn.mbrs.model.Vozilo;
import com.ftn.mbrs.repository.KarticaRepository;
import com.ftn.mbrs.repository.VoziloRepository;
import com.ftn.mbrs.service.KarticaService;

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

	@Override
	public Kartica update(Kartica kartica) {
		Kartica temp = karticaRepository.getOne(kartica.getId());
		temp.setImeVlasnika(kartica.getImeVlasnika());
		temp.setPrezimeVlasnika(kartica.getPrezimeVlasnika());
		temp.setKredit(kartica.getKredit());
		temp.setDate(kartica.getDate());
		return karticaRepository.save(temp);
	}

	@Override
	public void delete(Long id) {
		Kartica kartica = karticaRepository.getOne(id);
		List<Vozilo> vozila = voziloRepository.findByKartica(kartica);
		for (Vozilo vozilo : vozila) {
			voziloRepository.delete(vozilo);
		}
		karticaRepository.deleteById(id);
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
