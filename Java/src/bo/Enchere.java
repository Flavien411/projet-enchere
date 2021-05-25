package bo;

import java.util.Date;

public class Enchere {
	
	private Date dateEnchere;
	private int montantEnchere;
	private Utilisateur Enchereur;
	private Article ArticleEncherie;
	
	//Constructeur
	public Enchere(Date dateEnchere, int montantEnchere) {
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}
	
	public Enchere() {

	}
	//Getters et Setters
	public Date getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public Utilisateur getEnchereur() {
		return Enchereur;
	}

	public void setEnchereur(Utilisateur enchereur) {
		Enchereur = enchereur;
	}

	public Article getArticleEncherie() {
		return ArticleEncherie;
	}

	public void setArticleEncherie(Article articleEncherie) {
		ArticleEncherie = articleEncherie;
	}

	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + ", Enchereur=" + Enchereur
				+ ", ArticleEncherie=" + ArticleEncherie + "]";
	}	
	
}
