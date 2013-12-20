package com.sdzee.forms;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sdzee.beans.Article;
import com.sdzee.dao.ArticleDAO;
import com.sdzee.dao.DAOException;

public class DepotArticleForm {
	private static final String CHAMP_LOCALISATION  = "localisation";
    private static final String CHAMP_CATEGORIE     = "categorie";
    private static final String CHAMP_TITRE		    = "titre";
    private static final String CHAMP_TEXTARTICLE   = "textArticle";

    private String              resultat;
    private Map<String, String> erreurs         = new HashMap<String, String>();
    
    private ArticleDAO articleDao;
    
    public DepotArticleForm (ArticleDAO articleDao) {
    	this.articleDao = articleDao;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }
    
    public Article deposerArticle (HttpServletRequest request){
    	String localisation = getValeurChamp( request, CHAMP_LOCALISATION );
    	String categorie = getValeurChamp( request, CHAMP_CATEGORIE );
    	String titre = getValeurChamp( request, CHAMP_TITRE );
    	String textArticle = getValeurChamp( request, CHAMP_TEXTARTICLE );
    	
    	Article article = new Article();

        traiterLocalisation( localisation, article );
        traiterCategorie( categorie, article );
        traiterTitre( titre, article );
        traiterTextArticle( textArticle, article );

    	java.util.Date now = new java.util.Date();
        article.setDatePublie(new Timestamp(now.getTime()));
        article.setIdUtilisateur(new Long(0000));
        
        try {
            if ( erreurs.isEmpty() ) {
            	articleDao.creer(article);
                resultat = "Succès de la création de l'article.";
                
            } else {
                resultat = "Échec de la création de l'article.";
            }
        } catch ( DAOException e ) {
            setErreur( "imprévu", "Erreur imprévue lors de la création de l'article." );
            resultat = "Échec de la création de l'article : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }

        return article;
    }

	private void traiterLocalisation(String localisation, Article article) {
		try {
            validationLocalisation( localisation );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_LOCALISATION, e.getMessage() );
            System.out.println(e.getMessage());
        }
        article.setLocalisation( localisation );
	}

	private void traiterCategorie(String categorie, Article article) {
		try {
            validationCategorie( categorie );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_CATEGORIE, e.getMessage() );
            System.out.println(e.getMessage());
        }
        article.setCategorie( categorie );
	}

	private void traiterTitre(String titre, Article article) {
		try {
            validationTitre( titre );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_TITRE, e.getMessage() );
            System.out.println(e.getMessage());
        }
        article.setTitre( titre );
	}

	private void traiterTextArticle(String textArticle, Article article) {
    	try {
            validationTextArticle( textArticle );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_TEXTARTICLE, e.getMessage() );
            System.out.println(e.getMessage());
        }
        article.setTextArticle( textArticle );
	}

	private void validationLocalisation(String localisation) throws FormValidationException  {
		if ( localisation != null ) {
            if ( localisation.length() < 2 ) {
                throw new FormValidationException( "La localisation doit contenir au moins 2 caractères." );
            }
        } else {
            throw new FormValidationException( "Merci d'entrer une localisation." );
        }
	}

	private void validationCategorie(String categorie) throws FormValidationException  {
		if ( categorie != null ) {
            if ( categorie.length() < 2 ) {
                throw new FormValidationException( "La catégorie doit contenir au moins 2 caractères." );
            }
        } else {
            throw new FormValidationException( "Merci d'entrer une catégorie." );
        }
	}
    
    private void validationTitre(String titre) throws FormValidationException  {
    	if ( titre != null ) {
            if ( titre.length() < 2 ) {
                throw new FormValidationException( "Le titre doit contenir au moins 2 caractères." );
            }
        } else {
            throw new FormValidationException( "Merci d'entrer un titre." );
        }
	}

	private void validationTextArticle(String textArticle) throws FormValidationException  {
		if ( textArticle != null ) {
            if ( textArticle.length() < 2 ) {
                throw new FormValidationException( "L'article doit contenir au moins 2 caractères." );
            }
        } else {
            throw new FormValidationException( "Merci d'entrer un article." );
        }
	}

	private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
    
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}
