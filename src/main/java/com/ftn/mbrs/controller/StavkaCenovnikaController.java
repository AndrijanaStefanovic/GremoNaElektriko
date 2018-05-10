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

import com.ftn.mbrs.model.StavkaCenovnika;
import com.ftn.mbrs.service.StavkaCenovnikaService;

@RestController
@RequestMapping("stavkaCenovnika")
public class StavkaCenovnikaController {

	@Autowired
	private StavkaCenovnikaService stavkaCenovnikaService;
	
	@RequestMapping(value = "/{tipPrikljuckaId}{cenovnikId}", method = RequestMethod.POST)
	public ResponseEntity<StavkaCenovnika> save(@Valid @RequestBody StavkaCenovnika stavkaCenovnika, @PathVariable Long tipPrikljuckaId, @PathVariable Long cenovnikId) {
		StavkaCenovnika savedStavkaCenovnika = stavkaCenovnikaService.save(stavkaCenovnika, tipPrikljuckaId, cenovnikId);
		return new ResponseEntity<StavkaCenovnika>(savedStavkaCenovnika, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<StavkaCenovnika> update(@Valid @RequestBody StavkaCenovnika stavkaCenovnika) {
		StavkaCenovnika updatedStavkaCenovnika = stavkaCenovnikaService.update(stavkaCenovnika);
		return new ResponseEntity<StavkaCenovnika>(updatedStavkaCenovnika, HttpStatus.OK);
	}
		
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/plain")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		String response = stavkaCenovnikaService.delete(id);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<StavkaCenovnika> findOne(@PathVariable Long id) {
		StavkaCenovnika stavkaCenovnika = stavkaCenovnikaService.findOne(id);
		return new ResponseEntity<StavkaCenovnika>(stavkaCenovnika, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StavkaCenovnika>> findAll() {
		List<StavkaCenovnika> stavkaCenovnikas = stavkaCenovnikaService.findAll();
		return new ResponseEntity<List<StavkaCenovnika>>(stavkaCenovnikas, HttpStatus.OK);
	}
}