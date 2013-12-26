package dao;

import static dao.DAOUtilities.fermeturesSilencieuses;
import static dao.DAOUtilities.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.User;

public class UserDaoImpl implements UserDAO {

    private static final String SQL_SELECT        = "SELECT id, fyname, ftname, address, telephone, email, pwd, inscription_date, Image FROM user ORDER BY id";
    private static final String SQL_SELECT_PAR_ID = "SELECT id, fyname, ftname, address, telephone, email, pwd, inscription_date, Image  FROM user WHERE id = ?";
    private static final String SQL_SELECT_PAR_EMAIL = "SELECT id, fyname, ftname, address, telephone, email, pwd, inscription_date, Image  FROM user WHERE email = ?";
    private static final String SQL_INSERT        = "INSERT INTO user(fyname, ftname, address, telephone, email, pwd, inscription_date, Image) VALUES (?, ?, ?, ?, ?, ?, ?, ? )";
 

    private DAOFactory          daoFactory;

    UserDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    /* Implémentation de la méthode définie dans l'interface userDao */
    @Override
    public User trouver( long id ) throws DAOException {
        return trouver( SQL_SELECT_PAR_ID, id );
    }

    /* Implémentation de la méthode définie dans l'interface userDao */
    @Override
    public User trouver( String email ) throws DAOException {
        return trouver( SQL_SELECT_PAR_EMAIL, email );
    }

    /* Implémentation de la méthode définie dans l'interface userDao */
    @Override
    public void creer( User user ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            connexion = daoFactory.getConnection();
           
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true,
            		user.getFyName(), user.getFtName(),
            		user.getAddress(), user.getTelephone(),
            		user.getEmail(), user.getPassword(),
            		user.getDateInscription(), user.getImage());
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création du user, aucune ligne ajoutée dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                user.setId( valeursAutoGenerees.getLong( 1 ) );
            } else {
                throw new DAOException( "Échec de la création du Useren base, aucun ID auto-généré retourné." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

    /* Implémentation de la méthode définie dans l'interface userDao */
    @Override
    public List<User> lister() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> users = new ArrayList<User>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement( SQL_SELECT );
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                users.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return users;
    }

    /* Implémentation de la méthode définie dans l'interface userDao */
    @Override
    public void supprimer( User user) throws DAOException {
      /*  Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE_PAR_ID, true, user.getId() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la suppression du user, aucune ligne supprimée de la table." );
            } else {
                user.setId( null );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }*/
    }

    /* Implémentation de la méthode définie dans l'interface userDao */
    @Override
    public void supprimer( long id ) throws DAOException {
      /*  Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE_PAR_ID, true, user.getId() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la suppression du user, aucune ligne supprimée de la table." );
            } else {
                user.setId( null );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }*/
    }

    /*
     * Méthode générique utilisée pour retourner un Userdepuis la base de
     * données, correspondant à la requête SQL donnée prenant en paramètres les
     * objets passés en argument.
     */
    private User trouver( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user= null;

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
            if ( resultSet.next() ) {
                user= map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return user;
    }

    /*
     * Simple méthode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des users (un ResultSet) et
     * un bean user.
     */
    private static User map( ResultSet resultSet ) throws SQLException {
    	
        User user= new User();
        user.setId( resultSet.getLong( "id" ) );
        user.setFyName( resultSet.getString( "fyname" ) );
        user.setFtname( resultSet.getString( "ftname" ) );
        user.setAddress( resultSet.getString( "address" ) );
        user.setTelephone( resultSet.getString( "telephone" ) );
        user.setEmail( resultSet.getString( "email" ) );
        user.setImage( resultSet.getString( "image" ) );
        user.setPassword( resultSet.getString("pwd"));
        user.setDateInscription(resultSet.getTimestamp("inscription_date"));
      
        return user;
    }

}
