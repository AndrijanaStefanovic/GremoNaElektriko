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

import com.ftn.mbrs.model.MarkaVozila;
import com.ftn.mbrs.service.MarkaVozilaService;

@RestController
@RequestMapping("markaVozila")
public class MarkaVozilaController {

	@Autowired
	private MarkaVozilaService markaVozilaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<MarkaVozila> save(@Valid @RequestBody MarkaVozila markaVozila) {
		MarkaVozila savedMarkaVozila = markaVozilaService.save(markaVozila);
		return new ResponseEntity<MarkaVozila>(savedMarkaVozila, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<MarkaVozila> update(@Valid @RequestBody MarkaVozila markaVozila) {
		MarkaVozila updatedMarkaVozila = markaVozilaService.update(markaVozila);
		return new ResponseEntity<MarkaVozila>(updatedMarkaVozila, HttpStatus.OK);
	}
		
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/plain")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		String response = markaVozilaService.delete(id);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<MarkaVozila> findOne(@PathVariable Long id) {
		MarkaVozila markaVozila = markaVozilaService.findOne(id);
		return new ResponseEntity<MarkaVozila>(markaVozila, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MarkaVozila>> findAll() {
		List<MarkaVozila> markaVozilas = markaVozilaService.findAll();
		return new ResponseEntity<List<MarkaVozila>>(markaVozilas, HttpStatus.OK);
	}
}