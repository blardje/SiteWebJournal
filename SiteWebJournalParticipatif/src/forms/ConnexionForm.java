package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.User;

import dao.UserDAO;

public final class ConnexionForm {
    private static final String CHAMP_EMAIL  = "emailInscrit";
    private static final String CHAMP_PASS   = "pwdInscrit";

    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();
    
	private UserDAO userDao;

    public ConnexionForm( UserDAO userDAO ) {
        this.userDao = userDAO;
    }

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public User connecterUtilisateur( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );
        
        User user = null;

        /* Recherche si l'utilisateur est inscrit */
        try {
            user = userDao.trouver(email);
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        
        if (user == null) {
        	setErreur( CHAMP_EMAIL, "Erreur email" );
        	System.out.println("Erreur email");
		}
        else if (!motDePasse.equals(user.getPassword())) {
	        setErreur( CHAMP_PASS, "Mauvais mot de passe" );
	        System.out.println("Mauvais mot de passe" );
        }
        
        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la connexion.";
        } else {
            resultat = "Échec de la connexion.";
        }
        
        return user;
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}