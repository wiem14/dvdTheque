package fr.demos.formation.model;

import java.util.List;

public interface UserDao {
	
	List<User> findAll();
	
	User findById(int id);
	User findByParam (String login, String mdp);
	User findByLogin (String login);
	void create(User a) throws DAOException;
	void update(User a) throws DAOException;
	void delete(User a) throws DAOException;

}
