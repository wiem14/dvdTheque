package fr.demos.formation.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.formation.model.DAOException;
import fr.demos.formation.model.DvdDaoJPA;
import fr.demos.formation.model.User;
import fr.demos.formation.model.UserDaoJPA;
import fr.demos.formation.model.UserDaoMySQL;

/**
 * Servlet implementation class Compte
 */
@WebServlet("/compte")
public class Compte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private UserDaoMySQL userDao = new UserDaoMySQL();
	@Inject  
	private UserDaoJPA userDao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Compte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/Compte.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String info   = request.getPathInfo();
		//System.out.print("POST = "+ info);
		String action = request.getParameter("submit");
		//request.setCharacterEncoding("UTF-8");
		HashMap<String, String> errorMap = new HashMap<>();
		
		String login          = "";
		String mdp            = "";
		
		if (action != null && action.equals("Valider")) {
			
			login = request.getParameter("login").trim();
			mdp   = request.getParameter("mdp").trim();
			if (login == null || login.equals("")) {
				errorMap.put("login", "Login obligatoire");
			}
			if (mdp == null || mdp.equals("")) {
				
				errorMap.put("mdp", "Mdp obligatoire");	
			}
			//verifier que le login n'existe pas deja
			User user = null;
			user = userDao.findByLogin(login);
			if (user != null){
				errorMap.put("login", "Login existant");
			}
			if(errorMap.size() !=0){
				request.setAttribute("erreur",errorMap);
		
				RequestDispatcher rd = request.getRequestDispatcher("/Compte.jsp");
				rd.forward(request, response);
				return;
			}else{
				User userParam = new User(login, mdp);
				try{
					userDao.create(userParam);
				}catch (DAOException e){
					request.setAttribute("erreur Creation compte DAO", e.getMessage());
					
				}
				HttpSession session = request.getSession(); 
				session.setAttribute("utilisateur", userParam);
				RequestDispatcher rd = request.getRequestDispatcher("/dvd/listeDvds.jsp");
				rd.forward(request, response);
				return;
				
			}
		}	
	}

}
