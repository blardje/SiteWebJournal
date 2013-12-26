package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Article;


import dao.ArticleDAO;
import dao.DAOFactory;
import forms.DepotArticleForm;

public class DepotArticleServlet extends HttpServlet {
	private static final long serialVersionUID = -59853274827056980L;
	
	/* Constantes */
	public static final String ATT_ARTICLE = "article";
    public static final String ATT_FORM        = "form";
    public static final String VUE = "/FluxArticles";
    public static final String VUE_FORM = "/depotArticle.jsp";
    public static final String CONF_DAO_FACTORY = "daofactory";
    
    private ArticleDAO articleDao;

    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.articleDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getArticleDao();

    }
    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
    	DepotArticleForm form = new DepotArticleForm(articleDao);
    	
    	/* Traitement de la requête et récupération du bean en résultant */
        Article article = form.deposerArticle(request);
    	
        /* Ajout du bean et de l'objet métier à l'objet requête */
        request.setAttribute( ATT_ARTICLE, article );
        request.setAttribute( ATT_FORM, form );
        
        /* Si aucune erreur */
        if ( form.getErreurs().isEmpty() ) {
            /* Affichage de la fiche récapitulative */
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        } else {
            /* Sinon, ré-affichage du formulaire de création avec les erreurs */
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
    }
    
}