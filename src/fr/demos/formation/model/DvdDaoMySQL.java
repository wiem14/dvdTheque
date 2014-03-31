package fr.demos.formation.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class DvdDaoMySQL implements DvdDao {
	
	private DataSource  ds = null;
	
	private static final String SQLFindAll = "SELECT idDvd,isbn, titre, dateDeSortie, categorie, duree FROM dvd WHERE idUser = ? ";
	private static final String SQLCreate  = "INSERT INTO dvd (isbn, titre, dateDeSortie, duree, categorie, idUser ) VALUES(?,?,?,?,?,?)";
	
	
	
	public DvdDaoMySQL() throws RuntimeException {
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
		Connection con= null ;
		PreparedStatement pr_stmt=null;
		ResultSet result=null;
		Collection<Dvd> liste = new ArrayList<Dvd>();
		try{
			
			con    		= ds.getConnection();
			pr_stmt     = con.prepareStatement(SQLFindAll);	
			pr_stmt.setInt(1,user.getId() );
			result      = pr_stmt.executeQuery();
			
			
			while(result.next()){
				String cat  = result.getString("categorie");
				Dvd d = new Dvd(result.getLong("idDvd"),result.getString("titre"),result.getString("isbn"), result.getDate("dateDeSortie"), result.getString("duree"), Categorie.valueOf(cat), user);
				liste.add(d);
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
	public void create(Dvd d) throws DAOException {
		
		java.sql.Date sqlDate  = new java.sql.Date(d.getDateDeSortie().getTime()); 
		PreparedStatement stmt = null;
		try (Connection con = ds.getConnection()){
			stmt=con.prepareStatement(SQLCreate);
			System.out.print(SQLCreate);
			stmt.setString(1,d.getISBN());
			stmt.setString(2,d.getTitre());
			stmt.setDate  (3, sqlDate);
			stmt.setString(4,d.getDuree());
			stmt.setString(5,d.getCategorie().name());
			System.out.print(d.getUser().getId());
			stmt.setInt   (6, d.getUser().getId());
			
			int n=stmt.executeUpdate();
			System.out.println(n+" enregistrements ont été mis a jour...");
			
		}catch (SQLException e){
			e.printStackTrace();
			throw new DAOException("Pb création DVD: " +e.getMessage(), e);
			
		}finally{
			try {
				if(stmt!=null) stmt.close();
			}catch(SQLException e){
				System.err.println("Erreur SQL: "+e.getMessage());
			}
			
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
