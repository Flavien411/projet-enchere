package bo;
import java.util.Date;

public class Article {
	
	private int noArticle,miseAPrix,prixVente;
	private String nomArticle,description,etatVente;
	private Date dateDebut,dateFin;
	private Categorie categorie;
	private Utilisateur Vendeur,Acheteur;
	
	//Constructeur
	public Article(String nomArticle, String description, String etatVente, Date dateDebut, Date dateFin, int miseAPrix) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.etatVente = etatVente;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.miseAPrix = miseAPrix;

	}
	
	public Article() {


	}
	
	//Getters et Setters
	public int getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	public int getMiseAPrix() {
		return miseAPrix;
	}
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	public int getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEtatVente() {
		return etatVente;
	}
	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Utilisateur getVendeur() {
		return Vendeur;
	}
	public void setVendeur(Utilisateur vendeur) {
		Vendeur = vendeur;
	}
	public Utilisateur getAcheteur() {
		return Acheteur;
	}
	public void setAcheteur(Utilisateur acheteur) {
		Acheteur = acheteur;
	}
	
	
}
