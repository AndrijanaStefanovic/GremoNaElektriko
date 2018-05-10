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
public class StavkaCenovnika implements Serializable {  

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
    private float cena;
    
	@ManyToOne(fetch = FetchType.EAGER)
    private TipPrikljucka tipPrikljucka;
    
	@Column
    private float porez;
    
	@ManyToOne(fetch = FetchType.EAGER)
    private Cenovnik cenovnik;
    

	public StavkaCenovnika() {}
	
	public StavkaCenovnika(float cena, TipPrikljucka tipPrikljucka, float porez, Cenovnik cenovnik){
		this.cena = cena;
		this.tipPrikljucka = tipPrikljucka;
		this.porez = porez;
		this.cenovnik = cenovnik;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

      public float getCena(){
           return cena;
      }
      
      public void setCena(float cena){
           this.cena = cena;
      }
      
      public TipPrikljucka getTipPrikljucka(){
           return tipPrikljucka;
      }
      
      public void setTipPrikljucka(TipPrikljucka tipPrikljucka){
           this.tipPrikljucka = tipPrikljucka;
      }
      
      public float getPorez(){
           return porez;
      }
      
      public void setPorez(float porez){
           this.porez = porez;
      }
      
      public Cenovnik getCenovnik(){
           return cenovnik;
      }
      
      public void setCenovnik(Cenovnik cenovnik){
           this.cenovnik = cenovnik;
      }
      

}
