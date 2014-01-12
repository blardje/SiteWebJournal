package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Article;

import dao.ArticleDAO;
import dao.DAOFactory;


public class FluxArticlesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String ATT_ARTICLES = "articles";
    public static final String VUE = "/connecte.jsp";
    public static final String CONF_DAO_FACTORY = "daofactory";
    
    public static final String ATT_SESSION_USER     = "sessionUser";
    
    private ArticleDAO articleDao;

    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.articleDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getArticleDao();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<Long,List<Article>> articles = new HashMap<Long,List<Article>>();

		articles.put(new Long(0), articleDao.listerRubrique(0));
		articles.put(new Long(1), articleDao.listerRubrique(1));
		articles.put(new Long(2), articleDao.listerRubrique(2));
		articles.put(new Long(3), articleDao.listerRubrique(3));
		articles.put(new Long(4), articleDao.listerRubrique(4));
		articles.put(new Long(5), articleDao.listerRubrique(5));
		articles.put(new Long(6), articleDao.listerRubrique(6));
		
		 
        request.setAttribute( ATT_ARTICLES, articles );
        
//        request.getSession().invalidate();

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<Long,List<Article>> articles = new HashMap<Long,List<Article>>();

		articles.put(new Long(0), articleDao.listerRubrique(0));
		articles.put(new Long(1), articleDao.listerRubrique(1));
		articles.put(new Long(2), articleDao.listerRubrique(2));
		articles.put(new Long(3), articleDao.listerRubrique(3));
		articles.put(new Long(4), articleDao.listerRubrique(4));
		articles.put(new Long(5), articleDao.listerRubrique(5));
		articles.put(new Long(6), articleDao.listerRubrique(6));
		
        request.setAttribute( ATT_ARTICLES, articles );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}
