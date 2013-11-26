package model;

import java.sql.Date;

public class Article{
	private int idUtilisateur;
	private Date date;
	private String ville;
	private String rubrique;
	private String text;

	public Article(int idUtilisateur, Date date, String ville, String rubrique,
			String text) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.date = date;
		this.ville = ville;
		this.rubrique = rubrique;
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRubrique() {
		return rubrique;
	}

	public void setRubrique(String rubrique) {
		this.rubrique = rubrique;
	}
	
	
}
