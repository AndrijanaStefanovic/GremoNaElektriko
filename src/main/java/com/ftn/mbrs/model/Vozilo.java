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
public class Vozilo implements Serializable {  

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
    private String registracioniBroj;
    
	@ManyToOne(fetch = FetchType.EAGER)
    private ModelVozila modelVozila;
    
	@ManyToOne(fetch = FetchType.EAGER)
    private Kartica kartica;
    

	public Vozilo() {}
	
	public Vozilo(String registracioniBroj, ModelVozila modelVozila, Kartica kartica){
		this.registracioniBroj = registracioniBroj;
		this.modelVozila = modelVozila;
		this.kartica = kartica;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

      public String getRegistracioniBroj(){
           return registracioniBroj;
      }
      
      public void setRegistracioniBroj(String registracioniBroj){
           this.registracioniBroj = registracioniBroj;
      }
      
      public ModelVozila getModelVozila(){
           return modelVozila;
      }
      
      public void setModelVozila(ModelVozila modelVozila){
           this.modelVozila = modelVozila;
      }
      
      public Kartica getKartica(){
           return kartica;
      }
      
      public void setKartica(Kartica kartica){
           this.kartica = kartica;
      }
      

}
