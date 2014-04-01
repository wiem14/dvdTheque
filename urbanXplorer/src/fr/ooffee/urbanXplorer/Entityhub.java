package fr.ooffee.urbanXplorer;

import java.io.IOException;

import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class Entityhub
 */
@WebServlet("/Entityhub/*")
public class Entityhub extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Entityhub() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String info   = request.getPathInfo();
		//System.out.print("POST = "+ info);
		String action = request.getParameter("search");

		HashMap<String, String> errorMap = new HashMap<>();
		
		String entity          = "";
		
		if (action != null && action.equals("Search")) {
			
			entity = request.getParameter("entity").trim();
		
			if (entity == null || entity.equals("")) {
				errorMap.put("entity", "entity obligatoire");
			}
			
			if(errorMap.size() !=0){
				request.setAttribute("erreur",errorMap);
				//repeupler le formulaire
				request.setAttribute("entity",entity);
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
				return;
			}else{
				String result = "";
				//appeler le scrit avec le param recupere
				//recuperer le flux de la console
				//et passer la main a la jsp
				
				request.setAttribute("result", result);
				request.setAttribute("entity",entity);
				//stocker dans ma base
				
				RequestDispatcher rd = request
						.getRequestDispatcher("/index.jsp");
						rd.forward(request, response);
				
			}
		}	
	}

}
