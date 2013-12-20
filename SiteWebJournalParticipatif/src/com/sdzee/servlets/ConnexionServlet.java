package com.sdzee.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.beans.User;
import com.sdzee.dao.UserDAO;
import com.sdzee.dao.DAOFactory;
import com.sdzee.forms.ConnexionForm;

public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = -59853274827056980L;
	
	/* Constantes */
    public static final String ATT_CLIENT      = "user";
    public static final String ATT_FORM        = "form";
    public static final String SESSION_USERS     = "users";
    
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
        
        
        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if ( form.getErreurs().isEmpty() ) {
        	System.out.println("Liste d'erreurs vide");
            /* Récupération de la session depuis la requête */
            HttpSession session = request.getSession();
            
            Map<Long, User> users = (HashMap<Long, User>) session.getAttribute( SESSION_USERS );
            /* Si aucune map n'existe, alors initialisation d'une nouvelle map */
            if ( users == null ) {
                users = new HashMap<Long, User>();
            }
            /* Puis ajout du client courant dans la map */
            users.put( user.getId(), user );
            /* Et enfin (ré)enregistrement de la map en session */
            session.setAttribute( SESSION_USERS, users );
            
            System.out.println("Set session user");

            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
            System.out.println("Vue changé");
            
        } else {
            System.out.println("VUE_FORM");
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
    }
    
}