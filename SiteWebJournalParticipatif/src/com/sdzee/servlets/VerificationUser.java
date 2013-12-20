package com.sdzee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.dao.DAOFactory;
import com.sdzee.dao.UserDAO;

/**
 * Servlet implementation class VerificationUser
 */
@WebServlet("/VerificationUser")
public class VerificationUser extends HttpServlet {
	private static final long serialVersionUID = 1176696879505978663L;

	/* Constantes */
    public static final String ATT_CLIENT      = "user";
    public static final String ATT_FORM        = "form";
    public static final String SESSION_USERS = "users";

    public static final String VUE_SUCCES      = "/viewUser.jsp";
    public static final String VUE_FORM        = "/accueil.jsp";
    
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String CHEMIN           = "chemin";

    private UserDAO          userDao;
    
    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
    	
        this.userDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUserDao();

    }
    
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificationUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
