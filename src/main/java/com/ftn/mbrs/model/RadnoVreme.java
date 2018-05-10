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
public class RadnoVreme implements Serializable {  

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
    private int danUNedelji;
    
	@Column(nullable = false)
    private Date vremeOtvaranja;
    
	@Column(nullable = false)
    private Date vremeZatvaranja;
    
	@ManyToOne(fetch = FetchType.EAGER)
    private Stanica stanica;
    

	public RadnoVreme() {}
	
	public RadnoVreme(int danUNedelji, Date vremeOtvaranja, Date vremeZatvaranja, Stanica stanica){
		this.danUNedelji = danUNedelji;
		this.vremeOtvaranja = vremeOtvaranja;
		this.vremeZatvaranja = vremeZatvaranja;
		this.stanica = stanica;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

      public int getDanUNedelji(){
           return danUNedelji;
      }
      
      public void setDanUNedelji(int danUNedelji){
           this.danUNedelji = danUNedelji;
      }
      
      public Date getVremeOtvaranja(){
           return vremeOtvaranja;
      }
      
      public void setVremeOtvaranja(Date vremeOtvaranja){
           this.vremeOtvaranja = vremeOtvaranja;
      }
      
      public Date getVremeZatvaranja(){
           return vremeZatvaranja;
      }
      
      public void setVremeZatvaranja(Date vremeZatvaranja){
           this.vremeZatvaranja = vremeZatvaranja;
      }
      
      public Stanica getStanica(){
           return stanica;
      }
      
      public void setStanica(Stanica stanica){
           this.stanica = stanica;
      }
      

}
