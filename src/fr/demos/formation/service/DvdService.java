package fr.demos.formation.service;

import java.util.Collection;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import fr.demos.formation.annotation.Dao;
import fr.demos.formation.model.Dvd;
import fr.demos.formation.model.DvdDao;
import fr.demos.formation.model.User;

@WebService
public class DvdService {
	@Inject  @Dao
	private DvdDao dao;
	
	@WebMethod
	public Collection<Dvd> listeDvd(String pseudo){
		User user = new User(1,"login", "mdp"); //retrouver le user a partir du pseudo
		return dao.findByUser(user);
		
	}

}
