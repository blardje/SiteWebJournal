package model;

import java.util.ArrayList;

public class Journal {
	private String name;
	private int numberFollowers;
	private ArrayList<Article> listArticle = new ArrayList<Article>();
	private ArrayList<Utilisateur> listUser = new ArrayList<Utilisateur>();
	
	public Journal(String name, int numberFollowers) {
		super();
		this.name = name;
		this.numberFollowers = numberFollowers;
	}
	
	public Journal(String name, int numberFollowers,
			ArrayList<Article> listArticle) {
		super();
		this.name = name;
		this.numberFollowers = numberFollowers;
		this.listArticle = listArticle;
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
	
}
