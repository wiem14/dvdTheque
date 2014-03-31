package fr.demos.formation.model;

import java.util.List;

public interface RealisateurDao {
	Acteur findById(String id);
	
	
	
	
	
	
	List<Realisateur> findAll();
	List<Realisateur> findByDvd(Dvd d);
	Realisateur findById(int id);
	void create(Realisateur r) throws DAOException;;
	void update(Realisateur r) throws DAOException;;
	void delete(Realisateur r) throws DAOException;;
}
