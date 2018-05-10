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
public class Punjenje implements Serializable {  

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
    private Date pocetakPunjenja;
    
	@Column(nullable = false)
    private Date krajPunjenja;
    
	@ManyToOne(fetch = FetchType.EAGER)
    private Vozilo vozilo;
    
	@ManyToOne(fetch = FetchType.EAGER)
    private TipPrikljucka tipPrikljucka;
    
	@ManyToOne(fetch = FetchType.EAGER)
    private Stanica stanica;
    

	public Punjenje() {}
	
	public Punjenje(Date pocetakPunjenja, Date krajPunjenja, Vozilo vozilo, TipPrikljucka tipPrikljucka, Stanica stanica){
		this.pocetakPunjenja = pocetakPunjenja;
		this.krajPunjenja = krajPunjenja;
		this.vozilo = vozilo;
		this.tipPrikljucka = tipPrikljucka;
		this.stanica = stanica;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

      public Date getPocetakPunjenja(){
           return pocetakPunjenja;
      }
      
      public void setPocetakPunjenja(Date pocetakPunjenja){
           this.pocetakPunjenja = pocetakPunjenja;
      }
      
      public Date getKrajPunjenja(){
           return krajPunjenja;
      }
      
      public void setKrajPunjenja(Date krajPunjenja){
           this.krajPunjenja = krajPunjenja;
      }
      
      public Vozilo getVozilo(){
           return vozilo;
      }
      
      public void setVozilo(Vozilo vozilo){
           this.vozilo = vozilo;
      }
      
      public TipPrikljucka getTipPrikljucka(){
           return tipPrikljucka;
      }
      
      public void setTipPrikljucka(TipPrikljucka tipPrikljucka){
           this.tipPrikljucka = tipPrikljucka;
      }
      
      public Stanica getStanica(){
           return stanica;
      }
      
      public void setStanica(Stanica stanica){
           this.stanica = stanica;
      }
      

}
