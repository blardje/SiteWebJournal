package model;

import java.util.ArrayList;

public class Utilisateur {
	private String name;
	private String surname;
	private String mail;
	private String pseudo;
	private String password;
	private ArrayList<Article> listArticle = new ArrayList<Article>();
	private ArrayList<Journal> listJournal = new ArrayList<Journal>();
	
	public Utilisateur(String name, String surname, String mail, String pseudo,
			String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.pseudo = pseudo;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
