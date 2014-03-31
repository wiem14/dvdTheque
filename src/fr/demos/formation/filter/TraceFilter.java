package fr.demos.formation.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class TraceFilter
 */
@WebFilter("/*")
public class TraceFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TraceFilter() {
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
		// TODO Auto-generated method stub
		// place your code here
		long debut = System.currentTimeMillis();
		//System.out.print("Entree dans l'application");
		// pass the request along the filter chain
		chain.doFilter(request, response);
		//en retour de la requete
		long fin = System.currentTimeMillis();
		//System.out.print("Duree de l'execution : " + (fin - debut));
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
