package servlet;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Article;

/**
 * Servlet implementation class ConnecteServlet
 */
@WebServlet("/ConnecteServlet")
public class ConnecteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String ATT_ARTICLES = "articles";
    public static final String VUE = "/connecte.jsp";
    
	 Connection con = null;
	 Statement st = null;

	 String url = "jdbc:mysql://localhost:3306/";
	 String db = "db_journal";
	 String driver = "com.mysql.jdbc.Driver";
	 String user = "root";
	 String pass = "journalpwd";
	 
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnecteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Article> articles = new ArrayList<Article>();
        Article articleTemp = new Article();
        
        try {
			  Class.forName(driver);
			  con = DriverManager.getConnection(url + db, user, pass);
			  con.setAutoCommit(true);
			  st = con.createStatement();
			  
			  ResultSet resultat = st.executeQuery( "SELECT idArticle, idUtilisateur, datePublie, localisation, categorie, titre, textArticle FROM db_journal.article;" );
			  
			  while ( resultat.next() ) {
				  articleTemp = new Article(resultat.getInt( "idArticle"), 
						  resultat.getInt( "idUtilisateur"), 
						  resultat.getDate( "datePublie"), 
						  resultat.getString( "localisation"), 
						  resultat.getString( "categorie"), 
						  resultat.getString( "titre"), 
						  resultat.getString( "textArticle"));
			  
				  articles.add(articleTemp);
		  }
		
		  } catch (Exception e) {
			  System.out.println(e);
		  }
        
        request.setAttribute( ATT_ARTICLES, articles );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Article> articles = new ArrayList<Article>();
        Article articleTemp = new Article();
        
        try {
			  Class.forName(driver);
			  con = DriverManager.getConnection(url + db, user, pass);
			  con.setAutoCommit(true);
			  st = con.createStatement();
			  
			  ResultSet resultat = st.executeQuery( "SELECT idArticle, idUtilisateur, datePublie, localisation, categorie, titre, textArticle FROM db_journal.article;" );
			  
			  while ( resultat.next() ) {
				  articleTemp = new Article(resultat.getInt( "idArticle"), 
						  resultat.getInt( "idUtilisateur"), 
						  resultat.getDate( "datePublie"), 
						  resultat.getString( "localisation"), 
						  resultat.getString( "categorie"), 
						  resultat.getString( "titre"), 
						  resultat.getString( "textArticle"));
			  
				  articles.add(articleTemp);
		  }
		
		  } catch (Exception e) {
			  System.out.println(e);
		  }
        
        request.setAttribute( ATT_ARTICLES, articles );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}
	
}


