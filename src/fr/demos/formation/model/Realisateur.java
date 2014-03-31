package fr.demos.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Realisateur {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name ="idRealisateur")
	private Long id;
	@Column(name ="nomRealisateur")
	private String nom;
	@JoinColumn(name="dvdId")
	@ManyToOne
	private Dvd dvd;
	
	public Realisateur() {
		
	}
	public Realisateur(Long id, String nom, Dvd dvd) {
		super();
		this.id = id;
		this.nom = nom;
		this.dvd = dvd;
	}
	public Realisateur( String nom, Dvd dvd) {
		super();
		
		this.nom = nom;
		this.dvd = dvd;
	}
	
	
	public Dvd getDvd() {
		return dvd;
	}
	public void setDvd(Dvd dvd) {
		this.dvd = dvd;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return  nom ;
	}
	public Long getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	
	

}
