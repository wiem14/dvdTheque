package fr.demos.formation.model;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

import fr.demos.formation.annotation.Dao;
@Dao
public class DvdDaoJPA implements DvdDao {
	//obtention d'un manager d'entity sur un context de persistance
	//de durée transactionnelle
	@PersistenceContext 
	private EntityManager em;
	//utilisation du gestionnaire de transaction du serveur d'application
	//(API JTA) Java Transactionnel API
	@Resource 
	private UserTransaction ut;

	@Override
	public Dvd findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Dvd> findByTitre(String titre) {
		
		return null;
	}

	@Override
	public Collection<Dvd> findByUser(User user) {
		String query = "select d from Dvd d where d.user = ?1";
		// préparation d'un objet requête
		TypedQuery<Dvd> q = em.createQuery(query,Dvd.class);
		// affectation du paramètre ?1 à partir d'une variable critère
		q.setParameter(1,user);
		// obtention du résultat
		Collection<Dvd> list = q.getResultList();
		return list;
	}
	/*
	 * pour inserer les acteurs de dvd et garantir la non redondance des données
	 * em.persist(d.getActeur());
	 * em.persist(d.dvd);
	 */
	/*
	 * (non-Javadoc)
	 * @see fr.demos.formation.model.DvdDao#create(fr.demos.formation.model.Dvd)
	 */
	@Override
	public void create(Dvd d) throws DAOException {
		try {
			ut.begin();
			em.persist(d);
			ut.commit(); //le commit entraine le flush
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Pb insertion dvd : " + d.getTitre(), e);		
		}			
		
	}

	@Override
	public void delete(Dvd d) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Dvd d) throws DAOException {
		// TODO Auto-generated method stub
		
	}

}
