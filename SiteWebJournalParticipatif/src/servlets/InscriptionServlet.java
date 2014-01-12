package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;


import dao.DAOFactory;
import dao.UserDAO;
import forms.InscriptionForm;

public class InscriptionServlet extends HttpServlet {
	
	private static final long serialVersionUID = -1505400842610109052L;
	/* Constantes */
    public static final String ATT_CLIENT      = "user";
    public static final String ATT_FORM        = "form";
    public static final String SESSION_USERS = "users";
    public static final String ATT_SESSION_USER     = "sessionUser";

    public static final String VUE_FORM        = "/accueil.jsp";
    public static final String VUE              = "/FluxArticles";
    
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String CHEMIN           = "chemin";

    private UserDAO          userDao;
    
    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
    	
        this.userDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUserDao();

    }
    
    
    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

    	
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /*
         * Lecture du paramètre 'chemin' passé à la servlet via la déclaration
         * dans le web.xml
         */
        String chemin = this.getServletConfig().getInitParameter( CHEMIN );

        /* Préparation de l'objet formulaire */
        InscriptionForm form = new InscriptionForm( userDao );

        /* Traitement de la requête et récupération du bean en résultant */
        User user = form.creerUser( request, chemin );

        /* Ajout du bean et de l'objet métier à l'objet requête */
        request.setAttribute( ATT_CLIENT, user );
        request.setAttribute( ATT_FORM, form );
        
        HttpSession session = request.getSession();
        /* Si aucune erreur */
        if ( form.getErreurs().isEmpty() ) {
            /* Alors récupération de la map des clients dans la session */
        	
			@SuppressWarnings("unchecked")
			Map<Long, User> users = (HashMap<Long, User>) session.getAttribute( SESSION_USERS );
			
            /* Si aucune map n'existe, alors initialisation d'une nouvelle map */
            if ( users == null ) {
                users = new HashMap<Long, User>();
            }
            /* Puis ajout du client courant dans la map */
            users.put( user.getId(), user );
            /* Et enfin (ré)enregistrement de la map en session */
            session.setAttribute( SESSION_USERS, users );
            session.setAttribute( ATT_SESSION_USER, user );
            
            /* Affichage de la fiche récapitulative */
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        } else {
            /* Sinon, ré-affichage du formulaire de création avec les erreurs */
            session.setAttribute( ATT_SESSION_USER, null );
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
    }
}