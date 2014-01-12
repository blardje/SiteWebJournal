package dao;

import static dao.DAOUtilities.fermeturesSilencieuses;
import static dao.DAOUtilities.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Article;

public class ArticleDaoImpl implements ArticleDAO {
	private static final String SQL_SELECT        = "SELECT idArticle, idUtilisateur, datePublie, localisation, categorie, titre, textArticle FROM article ORDER BY idArticle";
    private static final String SQL_SELECT_PAR_ID = "SELECT idArticle, idUtilisateur, datePublie, localisation, categorie, titre, textArticle FROM article WHERE idArticle = ?";
    private static final String SQL_SELECT_PAR_IDUSER = "SELECT idArticle, idUtilisateur, datePublie, localisation, categorie, titre, textArticle FROM article WHERE idUtilisateur = ?";
    private static final String SQL_SELECT_PAR_RUBRIQUE = "SELECT idArticle, idUtilisateur, datePublie, localisation, categorie, titre, textArticle FROM article WHERE categorie = ? ORDER BY datePublie DESC";
    private static final String SQL_INSERT        = "INSERT INTO article(idUtilisateur, datePublie, localisation, categorie, titre, textArticle) VALUES (?, ?, ?, ?, ?, ? )";
	
    private static final String[] RUBRIQUE = {
    	"A la une", 
    	"Politique", 
    	"Economie",
    	"Sport",
    	"Culture",
    	"Petites annonces",
    	"Location/Achat"
    	};


    private DAOFactory          daoFactory;

    ArticleDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
    @Override
	public void creer(Article article) throws DAOException {
    	 Connection connexion = null;
         PreparedStatement preparedStatement = null;
         ResultSet valeursAutoGenerees = null;

         try {
             connexion = daoFactory.getConnection();
            
             preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true,
             		article.getIdUtilisateur(), article.getDatePublie(), 
             		article.getLocalisation(), article.getCategorie(), 
             		article.getTitre(), article.getTextArticle());
             int statut = preparedStatement.executeUpdate();
             if ( statut == 0 ) {
                 throw new DAOException( "Échec de la création de l'article, aucune ligne ajoutée dans la table." );
             }
             valeursAutoGenerees = preparedStatement.getGeneratedKeys();
             if ( valeursAutoGenerees.next() ) {
                 article.setIdArticle( valeursAutoGenerees.getLong( 1 ) );
             } else {
                 throw new DAOException( "Échec de la création de l'article en base, aucun ID auto-généré retourné." );
             }
         } catch ( SQLException e ) {
             throw new DAOException( e );
         } finally {
             fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
         }
	}
    
	@Override
	public Article trouver(long id) throws DAOException {
		return trouver( SQL_SELECT_PAR_ID, id );
	}

	@Override
	public List<Article> trouverList(long idUtilisateur) throws DAOException {
		return trouverList(SQL_SELECT_PAR_IDUSER, idUtilisateur);
	}
	
	@Override
	public List<Article> lister() throws DAOException {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Article> articles = new ArrayList<Article>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement( SQL_SELECT );
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                articles.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return articles;
	}

	@Override
	public List<Article> listerRubrique( int i) throws DAOException {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Article> articles = new ArrayList<Article>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connection, SQL_SELECT_PAR_RUBRIQUE, false, RUBRIQUE[i] );
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                articles.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return articles;
	}
	@Override
	public void supprimer(Article article) throws DAOException {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void supprimer(long id) throws DAOException {
		// TODO Auto-generated method stub
	}
 
	/*
     * Méthode générique utilisée pour retourner un article depuis la base de
     * données, correspondant à la requête SQL donnée prenant en paramètres les
     * objets passés en argument.
     */
    private Article trouver( String sql, Object... objets ) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Article article = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connection = daoFactory.getConnection();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement un id) et exécution.
             */
            preparedStatement = initialisationRequetePreparee( connection, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données retournée dans le ResultSet */
            if ( resultSet.next() ) {
                article = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return article;
    }

	/*
     * Méthode générique utilisée pour retourner une liste d'article depuis la base de
     * données, correspondant à la requête SQL donnée prenant en paramètres les
     * objets passés en argument.
     */
    private List<Article> trouverList( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Article> listArticle = new ArrayList<Article>();

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement un id) et exécution.
             */
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données retournée dans le ResultSet */
            while ( resultSet.next() ) {
                listArticle.add( map( resultSet ) ) ;
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return listArticle;
    }

    /*
     * Simple méthode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des articles (un ResultSet) et
     * un bean article.
     */
    private static Article map( ResultSet resultSet ) throws SQLException {
        Article article = new Article();
        article.setIdArticle( resultSet.getLong("idArticle"));
        article.setIdUtilisateur( resultSet.getLong("idUtilisateur"));
        article.setLocalisation( resultSet.getString("localisation"));
        article.setCategorie( resultSet.getString("categorie"));
        article.setTitre( resultSet.getString("titre"));
        article.setTextArticle( resultSet.getString("textArticle"));
        article.setDatePublie( resultSet.getTimestamp("datePublie"));
      
        return article;
    }
    
}
