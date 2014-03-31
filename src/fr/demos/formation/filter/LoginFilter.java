package fr.demos.formation.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

import fr.demos.formation.model.DvdDaoJPA;
import fr.demos.formation.model.User;
import fr.demos.formation.model.UserDao;
import fr.demos.formation.model.UserDaoJPA;
import fr.demos.formation.model.UserDaoMySQL;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName="LoginFilter", urlPatterns={"/dvd/*"})
public class LoginFilter implements Filter {
	//private UserDao daoUser  = new UserDaoMySQL(); 
	@Inject  
	private UserDaoJPA daoUser;
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession(); 
		User user           = (User) session.getAttribute("user");
		
		if (user == null) {
			String loginparam = request.getParameter("login");
			String mdpparam   = request.getParameter("mdp");
			
			if (loginparam != null && !loginparam.equals("") && mdpparam != null && !mdpparam.equals("")) {
					// verification authentification
					User userparam = daoUser.findByParam(loginparam.trim(), mdpparam.trim());
					if( userparam != null ){
						
						session.setAttribute("user", userparam);
						
					}else{
						request.setAttribute("msg","Login ou mdp incorrect !");
						RequestDispatcher rd =
								request.getRequestDispatcher("/Authentification.jsp");
						rd.forward(request, response);
						return;
						
					}
					
			} else {
				RequestDispatcher rd =
						request.getRequestDispatcher("/Authentification.jsp");
				rd.forward(request, response);
				return;
			}
		}//l'user est connecté, on laisse passer
		try {
			chain.doFilter(request, response);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
