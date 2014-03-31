package fr.demos.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name="user")
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="idUser")
	@XmlElement(name="id")
	private int id;
	private String login;
	private String mdp;
	
	
	
	
	protected User(){}
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", mdp=" + mdp + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (mdp == null) {
			if (other.mdp != null)
				return false;
		} else if (!mdp.equals(other.mdp))
			return false;
		return true;
	}


	public User(int id, String login, String mdp) {
		super();
		this.id = id;
		this.login = login;
		this.mdp = mdp;
	}
	
	public User(String login, String mdp) {
		
		this.login = login;
		this.mdp = mdp;
	}



	public int getId() {
		return id;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
	
	
	

}
