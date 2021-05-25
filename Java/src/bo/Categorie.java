package bo;

public class Categorie {
	
	private int noCategorie;
	private String libelle;
	
	//Constructeur
	public Categorie(String libelle) {
		this.libelle = libelle;
	}
	
	public Categorie() {
	}

	//Getters et Setters
	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + "]";
	}
	
	
}
