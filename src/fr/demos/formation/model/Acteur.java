package fr.demos.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Acteur {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name ="idActeur")
	private long id;
	@Column(name ="nomActeur")
	private String nom;
	@JoinColumn(name="dvdId")
	@ManyToOne
	private Dvd dvd;
	
	public Acteur() {
		
	}
	public Acteur(long id,String nom, Dvd dvd) {
		super();
		this.id = id;
		this.nom = nom;
		this.dvd = dvd;
	}
	public Acteur(String nom, Dvd dvd) {
		super();
		
		this.nom = nom;
		this.dvd = dvd;
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
	
	
	

}
