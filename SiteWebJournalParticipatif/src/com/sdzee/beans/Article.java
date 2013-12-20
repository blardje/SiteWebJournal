package com.sdzee.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Article implements Serializable{
	private static final long serialVersionUID = 6304123991404658140L;
	
	private Long idArticle;
	private Long idUtilisateur;
	private Timestamp datePublie;
	private String localisation;
	private String categorie;
	private String titre;
	private String textArticle;
	
	public Article() {
		super();
	}

	public Article(Long idArticle, Long idUtilisateur,Timestamp datePublie,
			String localisation, String categorie, String titre,
			String textArticle) {
		super();
		this.idArticle = idArticle;
		this.idUtilisateur = idUtilisateur;
		this.datePublie = datePublie;
		this.localisation = localisation;
		this.categorie = categorie;
		this.titre = titre;
		this.textArticle = textArticle;
	}

	public Article(Long idArticle, Long idUtilisateur, Timestamp datePublie,
			String localisation, String textArticle) {
		super();
		this.idArticle = idArticle;
		this.idUtilisateur = idUtilisateur;
		this.datePublie = datePublie;
		this.localisation = localisation;
		this.textArticle = textArticle;
	}

	public Long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Timestamp getDatePublie() {
		return datePublie;
	}

	public void setDatePublie(Timestamp datePublie) {
		this.datePublie = datePublie;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getTextArticle() {
		return textArticle;
	}

	public void setTextArticle(String textArticle) {
		this.textArticle = textArticle;
	}

	
}
