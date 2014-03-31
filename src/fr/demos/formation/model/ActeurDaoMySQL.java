package fr.demos.formation.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ActeurDaoMySQL implements ActeurDao {

private DataSource  ds = null;
	
	private static final String SQLFindAll="SELECT * FROM acteur";

	private static final String SQLCreateA="INSERT INTO acteur (nomActeur, dvdId) VALUES (?,?);";
			
	
	
	public ActeurDaoMySQL() throws RuntimeException {
		Context ic;
		try {
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("jdbc/dvdtheque"); //data source publié ds l'admin de glassfish
		} catch (NamingException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	@Override
	public Acteur findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Acteur a) throws DAOException {

		PreparedStatement stmt = null;
		try (Connection con = ds.getConnection()){
			stmt=con.prepareStatement(SQLCreateA);
			
			stmt.setString(1,a.getNom());
			stmt.setString(2,a.getDvd().getISBN());
			//System.out.println(SQLCreateA);
			int n= stmt.executeUpdate();
			System.out.println(n+" enregistrements ont été mis à jour...");
			
		}catch (SQLException e){
			e.printStackTrace();
			throw new DAOException("Pb création Auteur: " +e.getMessage(), e);
			
		}finally{
			try {
				if(stmt!=null) stmt.close();
			}catch(SQLException e){
				System.err.println("Erreur SQL: "+e.getMessage());
			}
			
		}
		
	}

	@Override
	public void delete(Acteur a) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public List<Acteur> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Acteur> findByDvd(Dvd d) {
	
	        Connection con= null ;
	   		PreparedStatement pr_stmt=null;
	   		ResultSet result=null;
	   		List<Acteur> liste = new ArrayList<Acteur>();
	   		try{
	   			
	   			con     = ds.getConnection();
	   			pr_stmt = con.prepareStatement("select idActeur, nomActeur from acteur where dvdId = ?");
	   			
	   			pr_stmt.setString(1, d.getISBN());
	   			result  = pr_stmt.executeQuery();       
	           while (result.next()) {
	               Long id = result.getLong(1);
	               String nomActeur = result.getString(2);
	               Acteur a = new Acteur(id, nomActeur, d);
	               liste.add(a);
	           }
	   		}catch(SQLException e){
				throw new DAOException(e.getMessage());
			}finally{ // libère les ressources...
				try {
					if(result!=null) result.close();
				}catch(SQLException e){
					throw new DAOException(e.getMessage());
				}
				try {
					if(pr_stmt!=null) pr_stmt.close();
				}catch(SQLException e){
					throw new DAOException(e.getMessage());
				}
				try {
					if(con!=null) con.close(); //Systeme de pool 
				}catch(SQLException e){
					throw new DAOException(e.getMessage(), e);
				}
			}
	   		return liste;	
		
	}
	
	@Override
	public void update(Acteur a) throws DAOException {
		// TODO Auto-generated method stub
		
	}

}
