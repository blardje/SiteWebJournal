package com.sdzee.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.beans.Article;
import com.sdzee.dao.ArticleDAO;
import com.sdzee.dao.DAOFactory;


public class FluxArticlesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String ATT_ARTICLES = "articles";
    public static final String VUE = "/connecte.jsp";
    public static final String CONF_DAO_FACTORY = "daofactory";
    
    private ArticleDAO articleDao;

    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.articleDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getArticleDao();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Article> articles = new ArrayList<Article>();
		articles = articleDao.lister();
		 
        request.setAttribute( ATT_ARTICLES, articles );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Article> articles = new ArrayList<Article>();
		articles = articleDao.lister();
		 
        request.setAttribute( ATT_ARTICLES, articles );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}
