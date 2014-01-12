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
        /* R�cup�ration d'une instance de notre DAO Utilisateur */
    	
        this.userDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUserDao();

    }
    
    
    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

    	
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /*
         * Lecture du param�tre 'chemin' pass� � la servlet via la d�claration
         * dans le web.xml
         */
        String chemin = this.getServletConfig().getInitParameter( CHEMIN );

        /* Pr�paration de l'objet formulaire */
        InscriptionForm form = new InscriptionForm( userDao );

        /* Traitement de la requ�te et r�cup�ration du bean en r�sultant */
        User user = form.creerUser( request, chemin );

        /* Ajout du bean et de l'objet m�tier � l'objet requ�te */
        request.setAttribute( ATT_CLIENT, user );
        request.setAttribute( ATT_FORM, form );
        
        HttpSession session = request.getSession();
        /* Si aucune erreur */
        if ( form.getErreurs().isEmpty() ) {
            /* Alors r�cup�ration de la map des clients dans la session */
        	
			@SuppressWarnings("unchecked")
			Map<Long, User> users = (HashMap<Long, User>) session.getAttribute( SESSION_USERS );
			
            /* Si aucune map n'existe, alors initialisation d'une nouvelle map */
            if ( users == null ) {
                users = new HashMap<Long, User>();
            }
            /* Puis ajout du client courant dans la map */
            users.put( user.getId(), user );
            /* Et enfin (r�)enregistrement de la map en session */
            session.setAttribute( SESSION_USERS, users );
            session.setAttribute( ATT_SESSION_USER, user );
            
            /* Affichage de la fiche r�capitulative */
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        } else {
            /* Sinon, r�-affichage du formulaire de cr�ation avec les erreurs */
            session.setAttribute( ATT_SESSION_USER, null );
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
    }
}