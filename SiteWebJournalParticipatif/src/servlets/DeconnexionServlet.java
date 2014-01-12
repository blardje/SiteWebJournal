package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeconnexionServlet extends HttpServlet {
	private static final long serialVersionUID = -8276398543267773244L;
	
	public static final String URL_REDIRECTION = "/FluxArticles";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Récupération et destruction de la session en cours */
        HttpSession session = request.getSession();
        session.invalidate();

        this.getServletContext().getRequestDispatcher( URL_REDIRECTION ).forward( request, response );
       
    }
}