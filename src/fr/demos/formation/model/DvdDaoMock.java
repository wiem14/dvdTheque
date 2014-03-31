package fr.demos.formation.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class DvdDaoMock  implements DvdDao{

	@Override
	public Dvd findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Dvd> findByTitre(String titre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Dvd> findByUser(User user) {
		// TODO Auto-generated method stub
		ArrayList<Dvd> liste = new ArrayList<>();
		String [] reals = {"real", "real2"};
		String[]  acts  = {"act", "act2"};
		String categ = "s1";
		//liste.add(new Dvd());
		//liste.add(new Dvd("titre1", "iSBN1", new Date(), "duree1",  Categorie.valueOf("s2") ));
		return liste;
	}

	@Override
	public void create(Dvd d) throws DAOException {
		// TODO Auto-generated method stub
		
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
