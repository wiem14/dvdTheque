package fr.demos.formation.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;





import java.util.Random;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;










import fr.demos.formation.annotation.Dao;
import fr.demos.formation.model.Acteur;
import fr.demos.formation.model.ActeurDao;
import fr.demos.formation.model.ActeurDaoJPA;
import fr.demos.formation.model.ActeurDaoMySQL;
import fr.demos.formation.model.Categorie;
import fr.demos.formation.model.DAOException;
import fr.demos.formation.model.Dvd;
import fr.demos.formation.model.DvdDao;
import fr.demos.formation.model.DvdDaoJPA;
import fr.demos.formation.model.DvdDaoMySQL;
import fr.demos.formation.model.Realisateur;
import fr.demos.formation.model.RealisateurDao;
import fr.demos.formation.model.RealisateurDaoJPA;
import fr.demos.formation.model.RealisateurDaoMySQL;
import fr.demos.formation.model.User;

/**
 * Servlet implementation class SaisieDvd
 */
//@WebServlet("/CrudDvd")
@WebServlet("/dvd/*")   //getPathInfo()  /dvd/liste ; /dvd/add
public class CrudDvd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    //private DvdDao daoDvd          = new DvdDaoMySQL();  

	//private ActeurDao daoAct       = new ActeurDaoMySQL();
	//private RealisateurDao daoReal = new RealisateurDaoMySQL();
	
	@Inject  @Dao  //on cree nos propres annotations
	private DvdDao daoDvd;
	//private DvdDaoJPA daoDvd;
	
	//si on veut utiliser DvdDaoMySQL , on cree une nouvelle annotation @DaoMysql, et le met sur la classe
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrudDvd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.setContentType ("text/html; charset=UTF-8");
		HttpSession session = request.getSession(); 
		request.setAttribute("nbvisiteurs", session.getServletContext().getAttribute("nbvisiteurs"));
		User user = (User) session.getAttribute("user");
		String info = request.getPathInfo();
		
		if ((info != null) && (info.equals("/liste")) ){
			/*  //Stockage dans la session
			HttpSession session = request.getSession();
			
			ArrayList<Dvd> dvdsList = (ArrayList<Dvd>) session.getAttribute("dvds");
			if (dvdsList == null){
				dvdsList = new ArrayList<Dvd>();
				session.setAttribute("dvds", dvdsList);
			}	
			*/
			System.out.print(user);
			Collection<Dvd>	 dvdsList = new ArrayList<>();
			 dvdsList = daoDvd.findByUser(user);
			/*
			 if (dvdsList != null){
			for (Dvd dvd : dvdsList) {
				List<Acteur> actListe = daoAct.findByDvd(dvd);
				List<String> actListeS = new ArrayList<>();
				for (Acteur acteur : actListe) {
					actListeS.add(acteur.getNom());
				}	
				dvd.setActeurs(actListeS);
				List<Realisateur> reaListe = daoReal.findByDvd(dvd);
				List<String> reaListeS = new ArrayList<>();
				for (Realisateur real : reaListe) {
					reaListeS.add(real.getNom());
				}	
				dvd.setRealisateurs(reaListeS);
			}
			}
			*/
			  
			request.setAttribute("dvdsList", dvdsList);
			
		
			RequestDispatcher rd = request
					.getRequestDispatcher("/ListeDvds.jsp");
					rd.forward(request, response);
			return;		
			
		}else if ( (info != null) &&(info.equals("/add")) ){
			RequestDispatcher rd = request.getRequestDispatcher("/SaisieDvd.jsp");
			rd.forward(request, response);
			return;
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); 
		User user = (User) session.getAttribute("user");
		System.out.print(user);
		String info   = request.getPathInfo();
		//System.out.print("POST = "+ info);
		String action = request.getParameter("submit");
		//request.setCharacterEncoding("UTF-8");
		HashMap<String, String> errorMap = new HashMap<>();
		
		String titre          = "";
		String isbn           = "";
		String dateDeSortie   = "";
		
		Date dateDeSortieD    = null;
		String duree          = "";
		String categorie      = "";
		String reals          = "";
		String acts           = "";
		String[] realisateurs = null;
		String[] acteurs      = null;
		
		if (action != null && action.equals("Valider")) {
			
			titre = request.getParameter("titre").trim();
			isbn  = request.getParameter("isbn").trim();
			if (titre == null || titre.equals("")) {
				errorMap.put("titre", "Titre obligatoire");
			}
			if (isbn == null || isbn.equals("")) {
				
				errorMap.put("isbn", "Isbn obligatoire");
				
				
			}
			
			dateDeSortie    = request.getParameter("dateDeSortie").trim();
			if (dateDeSortie != null){
				try {
					//System.out.print(dateDeSortie); //2014-02-06
					SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
					dateDeSortieD = formater.parse(dateDeSortie);
					//SimpleDateFormat formaterSortie = new SimpleDateFormat("dd-MM-yyyy");
					//dateDeSortieD = formater.format(dateDeSortie1);
					
					//System.out.print(formaterSortie.format(dateDeSortieD));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						errorMap.put("dateDeSortie", "Date non valide (jj-mm-aaaa)");
					}	
			}
			duree  = request.getParameter("duree").trim();
			
			if ( (duree == null) || (duree.equals(""))  ) {
				
				errorMap.put("duree", "Dur�e obligatoire");
			}
			
			categorie = request.getParameter("categorie");
			
			if ( (categorie == null) || (categorie.equals("")) || (categorie.equals("0")) ) {
				
				errorMap.put("categorie", "categorie obligatoire");
			}
			
			
			
			reals        = request.getParameter("real");
			realisateurs = reals.split(",");
			acts         = request.getParameter("acteur");
			acteurs      = acts.split(",");
			
			if(errorMap.size() !=0){
				request.setAttribute("erreur",errorMap);
				//repeupler le formulaire
				request.setAttribute("titre",titre);
				request.setAttribute("isbn",isbn);
				request.setAttribute("real",reals);
				request.setAttribute("acteur",acts);
				request.setAttribute("dateDeSortie",dateDeSortie);
				request.setAttribute("duree",duree);
				
				if (categorie != null){
					switch (categorie) {
						case "s1":request.setAttribute("s1","selected ='selected'");break;
						case "s2":request.setAttribute("s2","selected ='selected'");break;	
						case "s3":request.setAttribute("s3","selected ='selected'");break;
						default:request.setAttribute  ("s1","selected ='selected'");break;
					}	
				}
				
				RequestDispatcher rd = request.getRequestDispatcher("/SaisieDvd.jsp");
				rd.forward(request, response);
				return;
			}else{
				/*
				//stocker les dvds dans la session
				
				HttpSession session = request.getSession();
				ArrayList<Dvd> dvdsList = (ArrayList<Dvd>) session.getAttribute("dvds");
				//premier appel
				if (dvdsList == null){
					dvdsList = new ArrayList<Dvd>();
					session.setAttribute("dvds", dvdsList);
				}	
				
				Dvd d = new Dvd(titre, isbn, dateDeSortieD, duree, realisateurs, acteurs,Categorie.valueOf(categorie));
				dvdsList.add(d);
				System.out.println(dvdsList.size());
				*/
				
				List<String> reaListeS = new ArrayList<>();
				for (int i = 0; i < realisateurs.length; i++) {
					reaListeS.add(realisateurs[i]);
					
				} 
				List<String> actListeS = new ArrayList<>();
				for (int i = 0; i < acteurs.length; i++) {
					actListeS.add(acteurs[i]);
					
				} 
				//recuperer user de la session
				
				//Dvd d = new Dvd(titre, isbn, dateDeSortieD, duree, Categorie.valueOf(categorie), user);
				Dvd d =   new Dvd(titre, isbn, dateDeSortieD, duree, reaListeS, actListeS, Categorie.valueOf(categorie), user);
				String succes = "";
				try{
					daoDvd.create(d);
					succes ="LA saisie de votre dvd " + titre + " est termin�e avec succ�s.";
				}catch (DAOException e){
					request.setAttribute("erreurDAO", e.getMessage());
					
				}
				/*
				if (acteurs != null){                  
					System.out.println(acteurs.length);
					for (int i = 0; i < acteurs.length; i++) {
						Acteur a = new Acteur(acteurs[i], d);
						try{
							daoAct.create(a);
						}catch (DAOException e){
							request.setAttribute("erreurDAOActeur", e.getMessage());	
						}	
					}
				}
				
				if (realisateurs != null){
					for (int i = 0; i < realisateurs.length; i++) {
						Realisateur r = new Realisateur(realisateurs[i], d);
						try{
							daoReal.create(r);
						}catch (DAOException e){
							request.setAttribute("erreurDAORealisateur", e.getMessage());	
						}		
					}
				}
				*/
				
				Collection<Dvd>	 dvdsList = new ArrayList<>();
				dvdsList = daoDvd.findByUser(user);
				
				/*
				if (dvdsList != null){
				for (Dvd dvd : dvdsList) {
					List<Acteur> actListe = new ArrayList<Acteur>();
					actListe = daoAct.findByDvd(dvd);
					List<String> actListeS1 =new ArrayList<>();
					for (Acteur acteur : actListe) {
						actListeS1.add(acteur.getNom());
					}	
					dvd.setActeurs(actListeS1);
					
					List<Realisateur> reaListe = new ArrayList<Realisateur>();
					reaListe = daoReal.findByDvd(dvd);
					List<String> reaListeS1 = new ArrayList<>();
					for (Realisateur real : reaListe) {
						reaListeS1.add(real.getNom());
					}	
					dvd.setRealisateurs(reaListeS1);
				}
				}
				*/
				request.setAttribute("dvdsList", dvdsList);
				request.setAttribute("succes",succes);
				//stocker dans ma base
				
				RequestDispatcher rd = request
						.getRequestDispatcher("/ListeDvds.jsp");
						rd.forward(request, response);
				
			}
		
		}else if ((action != null && action.equals("Connecter")) ){
			System.out.print(action);
			Collection<Dvd>	 dvdsList = new ArrayList<>();
			 dvdsList = daoDvd.findByUser(user);
			
			/*
			 if (dvdsList != null){
			for (Dvd dvd : dvdsList) {
				List<Acteur> actListe = daoAct.findByDvd(dvd);
				System.out.print(actListe.size());
				List<String> actListeS = new ArrayList<>();
				for (Acteur acteur : actListe) {
					actListeS.add(acteur.getNom());
				}	
				dvd.setActeurs(actListeS);
				List<Realisateur> reaListe = daoReal.findByDvd(dvd);
				List<String> reaListeS = new ArrayList<>();
				for (Realisateur real : reaListe) {
					reaListeS.add(real.getNom());
				}	
				dvd.setRealisateurs(reaListeS);
			}
			}
			*/
			request.setAttribute("dvdsList", dvdsList);
			
			RequestDispatcher rd = request
					.getRequestDispatcher("/ListeDvds.jsp");
					rd.forward(request, response);
			
			
		}
		
		
	}
	

}
