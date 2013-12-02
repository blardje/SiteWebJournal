package com.sdzee.dao;

import java.util.List;

import com.sdzee.beans.User;

public interface UserDAO {
    void creer( User client ) throws DAOException;

    User trouver( long id ) throws DAOException;

    List<User> lister() throws DAOException;

    void supprimer( User client ) throws DAOException;

}