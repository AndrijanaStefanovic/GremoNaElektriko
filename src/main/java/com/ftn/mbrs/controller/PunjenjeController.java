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

import com.ftn.mbrs.model.Punjenje;
import com.ftn.mbrs.service.PunjenjeService;

@RestController
@RequestMapping("punjenje")
public class PunjenjeController {

	@Autowired
	private PunjenjeService punjenjeService;
	
	@RequestMapping(value = "/{voziloId}/{tipPrikljuckaId}/{stanicaId}", method = RequestMethod.POST)
	public ResponseEntity<Punjenje> save(@Valid @RequestBody Punjenje punjenje, @PathVariable Long voziloId, @PathVariable Long tipPrikljuckaId, @PathVariable Long stanicaId) {
		Punjenje savedPunjenje = punjenjeService.save(punjenje, voziloId, tipPrikljuckaId, stanicaId);
		return new ResponseEntity<Punjenje>(savedPunjenje, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Punjenje> update(@Valid @RequestBody Punjenje punjenje) {
		Punjenje updatedPunjenje = punjenjeService.update(punjenje);
		return new ResponseEntity<Punjenje>(updatedPunjenje, HttpStatus.OK);
	}
		
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/plain")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		String response = punjenjeService.delete(id);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Punjenje> findOne(@PathVariable Long id) {
		Punjenje punjenje = punjenjeService.findOne(id);
		return new ResponseEntity<Punjenje>(punjenje, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Punjenje>> findAll() {
		List<Punjenje> punjenjes = punjenjeService.findAll();
		return new ResponseEntity<List<Punjenje>>(punjenjes, HttpStatus.OK);
	}
}