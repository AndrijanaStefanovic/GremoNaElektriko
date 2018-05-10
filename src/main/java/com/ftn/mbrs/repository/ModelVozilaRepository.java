package com.ftn.mbrs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.mbrs.model.ModelVozila;
import com.ftn.mbrs.model.TipPrikljucka;
import com.ftn.mbrs.model.MarkaVozila;

public interface ModelVozilaRepository extends JpaRepository<ModelVozila, Long> {

	public List<ModelVozila> findByTipPrikljucka(TipPrikljucka tipPrikljucka);
	public List<ModelVozila> findByMarkaVozila(MarkaVozila markaVozila);

}