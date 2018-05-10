package com.ftn.mbrs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.mbrs.model.Vozilo;
import com.ftn.mbrs.service.VoziloService;

@RestController
@RequestMapping("vozilo")
public class VoziloController {

	@Autowired
	private VoziloService voziloService;
	
	@RequestMapping(value = "/{modelVozilaId}/{karticaId}", method = RequestMethod.POST)
	public ResponseEntity<Vozilo> save(@Valid @RequestBody Vozilo vozilo, @PathVariable Long modelVozilaId, @PathVariable Long karticaId) {
		Vozilo savedVozilo = voziloService.save(vozilo, modelVozilaId, karticaId);
		return new ResponseEntity<Vozilo>(savedVozilo, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Vozilo> update(@Valid @RequestBody Vozilo vozilo) {
		Vozilo updatedVozilo = voziloService.update(vozilo);
		return new ResponseEntity<Vozilo>(updatedVozilo, HttpStatus.OK);
	}
		
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/plain")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		String response = voziloService.delete(id);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vozilo> findOne(@PathVariable Long id) {
		Vozilo vozilo = voziloService.findOne(id);
		return new ResponseEntity<Vozilo>(vozilo, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Vozilo>> findAll() {
		List<Vozilo> vozilos = voziloService.findAll();
		return new ResponseEntity<List<Vozilo>>(vozilos, HttpStatus.OK);
	}
}