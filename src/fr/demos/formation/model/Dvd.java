package fr.demos.formation.model;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
//transformer la classe dvd en xml via la bib jaxb
@XmlRootElement(name="dvd")
public class Dvd {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name ="idDvd")
	@XmlElement(name="id")
	private long idDvd;
	@Column(name ="titre", updatable=false)
	@XmlElement(name="titre")
	private String titre;
	@Column(name="isbn", updatable=false)
	@XmlElement(name="isbn")
	private String ISBN;
	@Temporal(TemporalType.DATE)
	@Column(name ="dateDeSortie")
	@XmlElement(name="dateDeSortie")
	private Date dateDeSortie;
	@Column(name ="duree")
	@XmlElement(name="duree")
	private String duree;
	@CollectionTable(name="realisateurMapp")
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> realisateurs;
	@CollectionTable(name="acteurMapp")
	@ElementCollection(fetch=FetchType.EAGER)  //par defaut FetchType = lazy cad il ramene pas les valeurs des autres tables
	private List<String> acteurs;
	@Enumerated(EnumType.STRING)
	@XmlElement(name="categorie")
	private Categorie categorie;
	@JoinColumn(name="IdUser")  //le nom de la colone dans la table DVD
	@ManyToOne()
	@XmlElement(name="user")
	private User user;
	
	protected Dvd(){}


	public Dvd(long idDvd, String titre, String iSBN, Date dateDeSortie, String duree, Categorie categorie, User user) {
		super();
		this.idDvd = idDvd;
		this.titre = titre;
		ISBN = iSBN;
		this.dateDeSortie = dateDeSortie;
		this.duree = duree;
		this.categorie = categorie;
		this.user = user;
		
	}
	public Dvd( String titre, String iSBN, Date dateDeSortie, String duree, Categorie categorie, User user) {
		super();
		
		this.titre = titre;
		ISBN = iSBN;
		this.dateDeSortie = dateDeSortie;
		this.duree = duree;
		this.categorie = categorie;
		this.user = user;
		
	}
	public Dvd(String titre, String iSBN, User user) {
		super();
		this.titre = titre;
		ISBN = iSBN;
		this.user = user;
		
	}
	



public Dvd(String titre, String iSBN, Date dateDeSortie,
			String duree, List<String> realisateurs, List<String> acteurs,
			Categorie categorie, User user) {
		super();
		
		this.titre = titre;
		ISBN = iSBN;
		this.dateDeSortie = dateDeSortie;
		this.duree = duree;
		this.realisateurs = realisateurs;
		this.acteurs = acteurs;
		this.categorie = categorie;
		this.user = user;
	}


/*
	@Override
	public String toString() {
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
		System.out.print(formater.format(dateDeSortie));
		return "Dvd [titre=" + titre + "; ISBN=" + ISBN + "; Date de sortie="
				+ formater.format(dateDeSortie)+"; duree=" + duree + "; realisateurs="
				+ AfficheTableau(realisateurs) + "; acteurs=" + AfficheTableau(acteurs) + "; categorie="
				+ categorie.getCatType() + "]";
	}
*/

	public String toString() {
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
		System.out.print(formater.format(dateDeSortie));
		return "Dvd [titre=" + titre + "; ISBN=" + ISBN + "; Date de sortie="
				+ formater.format(dateDeSortie)+"; duree=" + duree + "; categorie="
						+ categorie.getCatType() +"]";
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dvd other = (Dvd) obj;
		if (ISBN == null) {
			if (other.ISBN != null)
				return false;
		} else if (!ISBN.equals(other.ISBN))
			return false;
		if (acteurs == null) {
			if (other.acteurs != null)
				return false;
		} else if (!acteurs.equals(other.acteurs))
			return false;
		if (categorie != other.categorie)
			return false;
		if (dateDeSortie == null) {
			if (other.dateDeSortie != null)
				return false;
		} else if (!dateDeSortie.equals(other.dateDeSortie))
			return false;
		if (duree == null) {
			if (other.duree != null)
				return false;
		} else if (!duree.equals(other.duree))
			return false;
		if (idDvd != other.idDvd)
			return false;
		if (realisateurs == null) {
			if (other.realisateurs != null)
				return false;
		} else if (!realisateurs.equals(other.realisateurs))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}


	public String AfficheDate(){
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
		return formater.format(dateDeSortie);
	}
	public String AfficheTableau (String[] tableau){
		String res ="";
		for (String string : tableau) {
			res += string +",";
		}
		return removeLastChar(res); //.substring(0,res.length()-1);
	}
	public String removeLastChar(String str) {
			System.out.print(str.charAt(str.length()-1));
		  if (str.length() > 0 && str.charAt(str.length()-1)== ',') {
		    str = str.substring(0, str.length()-1);
		  }
		  return str;
		}
	
	public void ajouterActeur(Acteur a) {
	       if (acteurs == null) acteurs = new ArrayList<String>();
	       acteurs.add(a.getNom());
	       a.setDvd(this);
	   }
	
	public void ajouterRealisateur(Realisateur r) {
	       if (realisateurs == null) realisateurs = new ArrayList<String>();
	       realisateurs.add(r.getNom());
	       r.setDvd(this);
	   }
	
	
	
	public long getIdDvd() {
		return idDvd;
	}


	public String getTitre() {
		return titre;
	}


	public String getISBN() {
		return ISBN;
	}


	public Date getDateDeSortie() {
		return dateDeSortie;
	}


	public String getDuree() {
		return duree;
	}



	public List<String> getRealisateurs() {
		return realisateurs;
	}




	public List<String> getActeurs() {
		return acteurs;
	}
	
	




	public void setRealisateurs(List<String> realisateurs) {
		this.realisateurs = realisateurs;
	}



	public void setActeurs(List<String> acteurs) {
		this.acteurs = acteurs;
	}



	public Categorie getCategorie() {
		return categorie;
	}



	public User getUser() {
		return user;
	}



	
	

}
