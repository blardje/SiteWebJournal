package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;


import dao.DAOFactory;
import dao.UserDAO;
import forms.ConnexionForm;

public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = -59853274827056980L;
	
	/* Constantes */
    public static final String ATT_CLIENT      = "user";
    public static final String ATT_FORM        = "form";
    public static final String ATT_SESSION_USER     = "sessionUser";
    
    public static final String CONF_DAO_FACTORY = "daofactory";
	
    public static final String VUE              = "/FluxArticles";
    public static final String VUE_FORM        = "/accueil.jsp";
    
    private UserDAO          userDao;

    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.userDao = ( (DAOFactory) getServletContext().
        		getAttribute( CONF_DAO_FACTORY ) ).
        		getUserDao();

    }
    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	/* Préparation de l'objet formulaire */
        ConnexionForm form = new ConnexionForm( userDao );
        
        /* Traitement de la requête et récupération du bean en résultant */
        User user = form.connecterUtilisateur( request );

        /* Ajout du bean et de l'objet métier à l'objet requête */
        request.setAttribute( ATT_CLIENT, user );
        request.setAttribute( ATT_FORM, form );
        
        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        
        if ( form.getErreurs().isEmpty() ) {
            
            if ( form.getErreurs().isEmpty() ) {
                session.setAttribute( ATT_SESSION_USER, user );
            } else {
                session.setAttribute( ATT_SESSION_USER, null );
            }

            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
            
        } else {
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
    }
    
}