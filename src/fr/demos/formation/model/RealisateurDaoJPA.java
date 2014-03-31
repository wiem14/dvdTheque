package fr.demos.formation.model;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

public class RealisateurDaoJPA implements RealisateurDao {
	//obtention d'un manager d'entity sur un context de persistance
			//de durée transactionnelle
			@PersistenceContext 
			private EntityManager em;
			//utilisation du gestionnaire de transaction du serveur d'application
			//(API JTA) Java Transactionnel API
			@Resource 
			private UserTransaction ut;
	@Override
	public Acteur findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Realisateur> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Realisateur> findByDvd(Dvd d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Realisateur findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Realisateur r) throws DAOException {
		try {
			ut.begin();
			em.persist(r);
			ut.commit(); //le commit entraine le flush
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Pb insertion dvd : " + r.getNom(), e);		
		}		
		
	}

	@Override
	public void update(Realisateur r) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Realisateur r) throws DAOException {
		// TODO Auto-generated method stub
		
	}

}
