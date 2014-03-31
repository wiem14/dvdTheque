package fr.demos.formation.model;


import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

public class UserDaoJPA implements UserDao {
	
		@PersistenceContext 
		private EntityManager em;
		@Resource 
		private UserTransaction ut;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByParam(String login, String mdp) {
		User user = null;
		String query = "select u from User u where u.login = ?1 and u.mdp = ?2";
		TypedQuery<User> q = em.createQuery(query,User.class);
		q.setParameter(1,login);
		q.setParameter(2,mdp);
		Collection<User> list = q.getResultList();
		int n = list.size();
		if ( n==1 ){
			for (User user2 : list) {
				user = user2;
				break;
			}
		} 
		return user;
	}

	@Override
	public User findByLogin(String login) {
		User user = null;
		String query = "select u from User u where u.login = ?1";
		TypedQuery<User> q = em.createQuery(query,User.class);
		q.setParameter(1,login);
		
		Collection<User> list = q.getResultList();
		int n = list.size();
		if ( n==1 ){
			for (User user2 : list) {
				user = user2;
				break;
			}
		} 
		return user;
	}

	@Override
	public void create(User a) throws DAOException {
		try {
			ut.begin();
			em.persist(a);
			ut.commit(); //le commit entraine le flush
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Pb création compte : " + a.getLogin(), e);		
		}	
		
	}

	@Override
	public void update(User a) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User a) throws DAOException {
		// TODO Auto-generated method stub
		
	}

}
