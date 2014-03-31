package fr.demos.formation.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDaoMySQL implements UserDao {
	
private DataSource  ds = null;
	
	private static final String SQLCreate  = "INSERT INTO user (login, mdp) VALUES (?,?);";
	private static final String SQLFindByParam  = "SELECT * FROM user WHERE login = ? AND mdp = ?";
	private static final String SQLFindByLogin  = "SELECT * FROM user WHERE login = ? ";
			
	
	
	public UserDaoMySQL() throws RuntimeException {
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
	public void create(User r) throws DAOException {
		PreparedStatement stmt = null;
		try (Connection con = ds.getConnection()){
			stmt=con.prepareStatement(SQLCreate);
			
			stmt.setString(1,r.getLogin());
			stmt.setString(2,r.getMdp());
			
			int n=stmt.executeUpdate();
			System.out.println(n+" enregistrement(s) ont été mis a jour...");
			
		}catch (SQLException e){
			e.printStackTrace();
			throw new DAOException("Pb création User: " +e.getMessage(), e);
			
		}finally{
			try {
				if(stmt!=null) stmt.close();
			}catch(SQLException e){
				System.err.println("Erreur SQL: "+e.getMessage());
			}
			
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

	@Override
	public User findByParam(String login, String mdp) {
		
		try (Connection con = ds.getConnection() ) {
			User user = null;
			PreparedStatement stmt=con.prepareStatement(SQLFindByParam);
			stmt.setString(1, login);
			stmt.setString(2, mdp);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()){
				user = new User (rs.getInt(1),login, mdp);
				return user;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findByLogin(String login) {
		try (Connection con = ds.getConnection() ) {
			User user = null;
			PreparedStatement stmt=con.prepareStatement(SQLFindByLogin);
			stmt.setString(1, login);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()){
				user = new User (rs.getInt(1),login, rs.getString(3));
				return user;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	
}
