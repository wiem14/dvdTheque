package fr.demos.formation.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;



/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent evt) {
        // TODO Auto-generated method stub
    	//création panier de course associé à l'utilisateur
    	HttpSession session = evt.getSession(); //.getServletContext();
    	//session.getServletContext();
    	Compteur nbvisiteurs =  (Compteur) session.getServletContext().getAttribute("nbvisiteurs");
    	
    	nbvisiteurs.incrementer();
    	System.out.print("Created =" +nbvisiteurs);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent evt) {
    	HttpSession session = evt.getSession(); //.getServletContext();
    	//session.getServletContext();
    	Compteur nbvisiteurs =  (Compteur) session.getServletContext().getAttribute("nbvisiteurs");
    	nbvisiteurs.decrementer();
    	System.out.print("destroyed =" +nbvisiteurs);
    }
	
}
