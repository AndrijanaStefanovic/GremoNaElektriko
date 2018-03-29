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

import com.ftn.mbrs.model.Kartica;
import com.ftn.mbrs.service.KarticaService;

@RestController
@RequestMapping("kartica")
public class KarticaController {
	
	@Autowired
	private KarticaService karticaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Kartica> save(@Valid @RequestBody Kartica kartica) {
		Kartica savedKartica = karticaService.save(kartica);
		return new ResponseEntity<Kartica>(savedKartica, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Kartica> update(@Valid @RequestBody Kartica kartica) {
		Kartica updatedKartica = karticaService.update(kartica);
		return new ResponseEntity<Kartica>(updatedKartica, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Long> delete(@PathVariable Long id) {
		karticaService.delete(id);
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Kartica> findOne(@PathVariable Long id) {
		Kartica kartica = karticaService.findOne(id);
		return new ResponseEntity<Kartica>(kartica, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Kartica>> findAll() {
		List<Kartica> kartice = karticaService.findAll();
		return new ResponseEntity<List<Kartica>>(kartice, HttpStatus.OK);
	}



}
