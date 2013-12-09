package model;

import java.sql.Date;

public class Article{
	private int idArticle;
	private int idUtilisateur;
	private Date datePublie;
	private String localisation;
	private String categorie;
	private String titre;
	private String textArticle;
	
	public Article() {
		super();
	}

	public Article(int idArticle, int idUtilisateur, Date datePublie,
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

	public Article(int idArticle, int idUtilisateur, Date datePublie,
			String localisation, String textArticle) {
		super();
		this.idArticle = idArticle;
		this.idUtilisateur = idUtilisateur;
		this.datePublie = datePublie;
		this.localisation = localisation;
		this.textArticle = textArticle;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Date getDatePublie() {
		return datePublie;
	}

	public void setDatePublie(Date datePublie) {
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
