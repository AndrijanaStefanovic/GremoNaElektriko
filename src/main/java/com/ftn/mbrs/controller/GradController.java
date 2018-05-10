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

import com.ftn.mbrs.model.Grad;
import com.ftn.mbrs.service.GradService;

@RestController
@RequestMapping("grad")
public class GradController {

	@Autowired
	private GradService gradService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Grad> save(@Valid @RequestBody Grad grad) {
		Grad savedGrad = gradService.save(grad);
		return new ResponseEntity<Grad>(savedGrad, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Grad> update(@Valid @RequestBody Grad grad) {
		Grad updatedGrad = gradService.update(grad);
		return new ResponseEntity<Grad>(updatedGrad, HttpStatus.OK);
	}
		
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/plain")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		String response = gradService.delete(id);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Grad> findOne(@PathVariable Long id) {
		Grad grad = gradService.findOne(id);
		return new ResponseEntity<Grad>(grad, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Grad>> findAll() {
		List<Grad> grads = gradService.findAll();
		return new ResponseEntity<List<Grad>>(grads, HttpStatus.OK);
	}
}