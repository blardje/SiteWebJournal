package dao;

import java.util.List;

import beans.Article;

public interface ArticleDAO {
	void creer(Article article) throws DAOException;
	
	Article trouver( long id) throws DAOException;
	
	List<Article> trouverList( long idUtilisateur) throws DAOException;
	
	List<Article> lister() throws DAOException;
	
	void supprimer( Article article ) throws DAOException;
	
	void supprimer( long id) throws DAOException;

	List<Article> listerRubrique(int i) throws DAOException;
}
