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
import com.sdzee.forms.InscriptionForm;

public class InscriptionServlet extends HttpServlet {
    /* Constantes */
    public static final String CHAMP_NOM       = "nomUser";
    public static final String CHAMP_PRENOM    = "prenomUser";
    public static final String CHAMP_ADRESSE   = "adresseUser";
    public static final String CHAMP_TELEPHONE = "telephoneUser";
    public static final String CHAMP_EMAIL     = "emailUser";
    public static final String ATT_CLIENT      = "user";
    public static final String ATT_FORM        = "form";
    public static final String SESSION_USERS = "users";

    public static final String VUE_SUCCES      = "/viewUser.jsp";
    public static final String VUE_FORM        = "/usr_Inscription.jsp";
    public static final String ATT_MESSAGE     = "message";
    public static final String ATT_ERREUR      = "erreur";
 
    public static final String VUE             = "/viewUser.jsp";
    
    
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String CHEMIN           = "chemin";


    private UserDAO          userDao;

    
    public void init() throws ServletException {
        /* R�cup�ration d'une instance de notre DAO Utilisateur */
        this.userDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUserDao();
    }
    
    
    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /*
         * R�cup�ration des donn�es saisies, envoy�es en tant que param�tres de
         * la requ�te GET g�n�r�e � la validation du formulaire
         */
        String nom = request.getParameter( CHAMP_NOM );
        String prenom = request.getParameter( CHAMP_PRENOM );
        String adresse = request.getParameter( CHAMP_ADRESSE );
        String telephone = request.getParameter( CHAMP_TELEPHONE );
        String email = request.getParameter( CHAMP_EMAIL );

        String message;
        boolean erreur;
        /*
         * Initialisation du message � afficher : si un des champs obligatoires
         * du formulaire n'est pas renseign�, alors on affiche un message
         * d'erreur, sinon on affiche un message de succ�s
         */
        if ( nom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty() ) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creerClient.jsp\">Cliquez ici</a> pour acc�der au formulaire de cr�ation d'un client.";
            erreur = true;
        } else {
            message = "Client cr�� avec succ�s !";
            erreur = false;
        }
        /*
         * Cr�ation du bean Client et initialisation avec les donn�es r�cup�r�es
         */
        User user = new User();
        user.setFyName( nom );
        user.setFtname( prenom );
        user.setAddress( adresse );
        user.setTelephone( telephone );
        user.setEmail( email );

        /* Ajout du bean et du message � l'objet requ�te */
        request.setAttribute( ATT_CLIENT, user );
        request.setAttribute( ATT_MESSAGE, message );
        request.setAttribute( ATT_ERREUR, erreur );

        /* Transmission � la page JSP en charge de l'affichage des donn�es */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
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

        /* Si aucune erreur */
        if ( form.getErreurs().isEmpty() ) {
            /* Alors r�cup�ration de la map des clients dans la session */
            HttpSession session = request.getSession();
            Map<Long, User> users = (HashMap<Long, User>) session.getAttribute( SESSION_USERS );
            /* Si aucune map n'existe, alors initialisation d'une nouvelle map */
            if ( users == null ) {
                users = new HashMap<Long, User>();
            }
            /* Puis ajout du client courant dans la map */
            users.put( user.getId(), user );
            /* Et enfin (r�)enregistrement de la map en session */
            session.setAttribute( SESSION_USERS, users );

            /* Affichage de la fiche r�capitulative */
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            /* Sinon, r�-affichage du formulaire de cr�ation avec les erreurs */
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
    }
}