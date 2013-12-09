package com.sdzee.dao;

import static com.sdzee.dao.DAOUtilities.fermeturesSilencieuses;
import static com.sdzee.dao.DAOUtilities.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sdzee.beans.User;

public class UserDaoImpl implements UserDAO {

    private static final String SQL_SELECT        = "SELECT pwd, name, Address, telephone, email FROM user ORDER BY id";
    private static final String SQL_SELECT_PAR_ID = "SELECT pwd, name, Address, telephone, email  FROM user WHERE id = ?";
    private static final String SQL_INSERT        = "INSERT INTO user(fyname, ftname, address, telephone, email, pwd, inscription_date, Image) VALUES (?, ?, ?, ?,?,?,?,? )";
 

    private DAOFactory          daoFactory;

    UserDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    /* Impl�mentation de la m�thode d�finie dans l'interface userDao */
    @Override
    public User trouver( long id ) throws DAOException {
        return trouver( SQL_SELECT_PAR_ID, id );
    }

    /* Impl�mentation de la m�thode d�finie dans l'interface userDao */
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
            		user.getEmail(), "password",
            		user.getDateInscription(), user.getImage());
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "�chec de la cr�ation du user, aucune ligne ajout�e dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                user.setId( valeursAutoGenerees.getLong( 1 ) );
            } else {
                throw new DAOException( "�chec de la cr�ation du Useren base, aucun ID auto-g�n�r� retourn�." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

    /* Impl�mentation de la m�thode d�finie dans l'interface userDao */
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

    /* Impl�mentation de la m�thode d�finie dans l'interface userDao */
    @Override
    public void supprimer( User user) throws DAOException {
      /*  Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE_PAR_ID, true, user.getId() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "�chec de la suppression du user, aucune ligne supprim�e de la table." );
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
     * M�thode g�n�rique utilis�e pour retourner un Userdepuis la base de
     * donn�es, correspondant � la requ�te SQL donn�e prenant en param�tres les
     * objets pass�s en argument.
     */
    private User trouver( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user= null;

        try {
            /* R�cup�ration d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            /*
             * Pr�paration de la requ�te avec les objets pass�s en arguments
             * (ici, uniquement un id) et ex�cution.
             */
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de donn�es retourn�e dans le ResultSet */
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
     * Simple m�thode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des users (un ResultSet) et
     * un bean user.
     */
    private static User map( ResultSet resultSet ) throws SQLException {
    	
        User user= new User();
        user.setId( resultSet.getLong( "id" ) );
        user.setFyName( resultSet.getString( "nom" ) );
        user.setFtname( resultSet.getString( "prenom" ) );
        user.setAddress( resultSet.getString( "address" ) );
        user.setTelephone( resultSet.getString( "telephone" ) );
        user.setEmail( resultSet.getString( "email" ) );
        user.setImage( resultSet.getString( "image" ) );
      
        return user;
    }

}
