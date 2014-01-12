package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AccessDepotArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 257888698685597154L;
	
	/* Constantes */	
    public static final String VUE              = "/restreint/depotArticle.jsp";
    
    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	
           
    }
    
}