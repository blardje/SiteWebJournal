package com.sdzee.dao;

public class UserDaoImpl {
	
	private static final String SQL_SELECT        = "SELECT id, nom, prenom, adresse, telephone, email, image FROM Client ORDER BY id";
	private static final String SQL_SELECT_PAR_ID = "SELECT id, nom, prenom, adresse, telephone, email, image FROM Client WHERE id = ?";
	private static final String SQL_INSERT        = "INSERT INTO Client (nom, prenom, adresse, telephone, email, image) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String SQL_DELETE_PAR_ID = "DELETE FROM Client WHERE id = ?";
	
	public class UserrDaoImpl implements UserDAO {
	    /* Impl�mentation de la m�thode trouver() d�finie dans l'interface UtilisateurDao */
	    @Override
	    public User trouver( String email ) throws DAOException {
	        return null;
	    }

	    /* Impl�mentation de la m�thode creer() d�finie dans l'interface UtilisateurDao */
	    @Override
	    public void creer( User user ) throws IllegalArgumentException, DAOException {
	    }
	}
}
