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
public class Kartica implements Serializable {  

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
    private String imeVlasnika;
    
	@Column(nullable = false)
    private String prezimeVlasnika;
    
	@Column
    private float kredit;
    

	public Kartica() {}
	
	public Kartica(String imeVlasnika, String prezimeVlasnika, float kredit){
		this.imeVlasnika = imeVlasnika;
		this.prezimeVlasnika = prezimeVlasnika;
		this.kredit = kredit;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

      public String getImeVlasnika(){
           return imeVlasnika;
      }
      
      public void setImeVlasnika(String imeVlasnika){
           this.imeVlasnika = imeVlasnika;
      }
      
      public String getPrezimeVlasnika(){
           return prezimeVlasnika;
      }
      
      public void setPrezimeVlasnika(String prezimeVlasnika){
           this.prezimeVlasnika = prezimeVlasnika;
      }
      
      public float getKredit(){
           return kredit;
      }
      
      public void setKredit(float kredit){
           this.kredit = kredit;
      }
      

}
