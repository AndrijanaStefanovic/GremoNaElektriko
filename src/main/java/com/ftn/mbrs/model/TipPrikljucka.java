package com.ftn.mbrs.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipPrikljucka implements Serializable {  

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
    private String naziv;
    
	@Column
    private float kW;
    

	public TipPrikljucka() {}
	
	public TipPrikljucka(String naziv, float kW){
		this.naziv = naziv;
		this.kW = kW;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

      public String getNaziv(){
           return naziv;
      }
      
      public void setNaziv(String naziv){
           this.naziv = naziv;
      }
      
      public float getKW(){
           return kW;
      }
      
      public void setKW(float kW){
           this.kW = kW;
      }
      

}
