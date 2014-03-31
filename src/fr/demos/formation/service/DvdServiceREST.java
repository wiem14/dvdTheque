package fr.demos.formation.service;

import java.util.List;

import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import fr.demos.formation.annotation.Dao;
import fr.demos.formation.model.Dvd;
import fr.demos.formation.model.DvdDao;
import fr.demos.formation.model.User;
/*
La méthode HTTP décrit ce que l'on veut faire :

• GET : récupérer une ressource

• POST : créer une nouvelle ressource (ajouter un élément à une collection, créer un nouvel élément)

• PUT : mettre à jour une ressource

• DELETE : supprimer une ressource
*/

@Path("dvds")
public class DvdServiceREST {
	@Inject  @Dao
	private DvdDao dao;
	
	
	// appel en GET avec url = /dvds
	@GET
	@Produces("text/xml")
	public List<Dvd> getListeDVDS(){
		// recherche de la liste de dvds
		User user = new User(1,"login", "mdp");
		List<Dvd> liste = (List<Dvd>) dao.findByUser(user);
		return liste;
	}
	
	// appel en POST avec url = /dvds et body contenant un dvd décrit en XML
	 @POST
	 @Consumes("text/xml")

	 public void add(Dvd d){
		 dao.create(d);
	 // sauvegarde du dvd

	 }
	

}
