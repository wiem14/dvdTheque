package fr.demos.formation.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class RealisateurDaoMySQL implements RealisateurDao {

	
	private DataSource  ds = null;
	
	private static final String SQLFindAll="SELECT *  FROM realisateur";

	private static final String SQLCreateR="INSERT INTO realisateur (nomRealisateur, dvdId) VALUES(?,?)";
			
	
	
	public RealisateurDaoMySQL() throws RuntimeException {
		Context ic;
		try {
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("jdbc/dvdtheque"); //data source publiï¿½ ds l'admin de glassfish
		} catch (NamingException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	@Override
	public Acteur findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Realisateur r) throws DAOException {
		PreparedStatement stmt = null;
		try (Connection con = ds.getConnection()){
			stmt=con.prepareStatement(SQLCreateR);
			
			stmt.setString(1,r.getNom());
			stmt.setString(2,r.getDvd().getISBN());
			
			int n=stmt.executeUpdate();
			System.out.println(n+" enregistrements ont été mis a jour...");
			
		}catch (SQLException e){
			e.printStackTrace();
			throw new DAOException("Pb création Realisateur: " +e.getMessage(), e);
			
		}finally{
			try {
				if(stmt!=null) stmt.close();
			}catch(SQLException e){
				System.err.println("Erreur SQL: "+e.getMessage());
			}
			
		}
		
		
	}

	@Override
	public void delete(Realisateur r) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	
	
	@Override
	public List<Realisateur> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Realisateur> findByDvd(Dvd d) {
		  Connection con= null ;
	   		PreparedStatement pr_stmt=null;
	   		ResultSet result=null;
	   		List<Realisateur> liste = new ArrayList<Realisateur>();
	   		try{
	   			
	   			con     = ds.getConnection();
	   			pr_stmt = con.prepareStatement("select idRealisateur, nomRealisateur from realisateur where dvdId = ?");
	   			//System.out.print(d.getISBN());
	   			pr_stmt.setString(1, d.getISBN());
	   			result  = pr_stmt.executeQuery();       
	           while (result.next()) {
	               Long id = result.getLong(1);
	               String nomRealisateur = result.getString(2);
	               Realisateur a = new Realisateur(id, nomRealisateur, d);
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
	public Realisateur findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void update(Realisateur r) throws DAOException {
		// TODO Auto-generated method stub
		
	}

}
