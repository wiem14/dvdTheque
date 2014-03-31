package fr.demos.formation.model;

import java.util.Collection;

public interface DvdDao {
	
	Dvd findById(String id);
	Collection<Dvd> findByTitre(String titre);
	Collection<Dvd> findByUser(User user);
	void create(Dvd d) throws DAOException;
	void delete(Dvd d) throws DAOException;
	void update(Dvd d) throws DAOException;
	
	
	

}
