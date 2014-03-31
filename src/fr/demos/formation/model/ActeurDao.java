package fr.demos.formation.model;

import java.util.List;



public interface ActeurDao {
	
	
	List<Acteur> findAll();
	List<Acteur> findByDvd(Dvd d);
	Acteur findById(int id);
	void create(Acteur a) throws DAOException;
	void update(Acteur a) throws DAOException;
	void delete(Acteur a) throws DAOException;

}
