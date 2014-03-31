package fr.demos.formation.model;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

public class ActeurDaoJPA implements ActeurDao {
	//obtention d'un manager d'entity sur un context de persistance
		//de durée transactionnelle
		@PersistenceContext 
		private EntityManager em;
		//utilisation du gestionnaire de transaction du serveur d'application
		//(API JTA) Java Transactionnel API
		@Resource 
		private UserTransaction ut;
	@Override
	public List<Acteur> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Acteur> findByDvd(Dvd d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Acteur findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Acteur a) throws DAOException {
		try {
			ut.begin();
			em.persist(a);
			ut.commit(); //le commit entraine le flush
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Pb insertion dvd : " + a.getNom(), e);		
		}		
		
	}

	@Override
	public void update(Acteur a) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Acteur a) throws DAOException {
		// TODO Auto-generated method stub
		
	}

}
