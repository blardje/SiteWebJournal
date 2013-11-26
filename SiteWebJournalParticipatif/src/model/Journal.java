package model;

import java.util.ArrayList;

public class Journal {
	private int idUtilisateur;
	private String name;
	private int numberFollowers;
	private ArrayList<Article> listArticle = new ArrayList<Article>();
	private ArrayList<Utilisateur> listAbonne = new ArrayList<Utilisateur>();
	
	public Journal(int idUtilisateur, String name, int numberFollowers) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.name = name;
		this.numberFollowers = numberFollowers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberFollowers() {
		return numberFollowers;
	}

	public void setNumberFollowers(int numberFollowers) {
		this.numberFollowers = numberFollowers;
	}

	public ArrayList<Article> getListArticle() {
		return listArticle;
	}

	public void setListArticle(ArrayList<Article> listArticle) {
		this.listArticle = listArticle;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public ArrayList<Utilisateur> getListAbonne() {
		return listAbonne;
	}

	public void setListAbonne(ArrayList<Utilisateur> listAbonne) {
		this.listAbonne = listAbonne;
	}
	
	
	
}
