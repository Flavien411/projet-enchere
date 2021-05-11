package bll;

import java.util.Date;

import bo.Article;
import bo.Categorie;
import bo.Retrait;
import dal.DAOFactory;
import dal.NouvelleVenteDAO;

public class NouvelleVenteManager {
	private static NouvelleVenteDAO nouvelleVenteDAO;

	public NouvelleVenteManager() {
		// Instancier le Data Access Object
		nouvelleVenteDAO = DAOFactory.getArticleDAO();
	}


/* Ajout d'un nouvel article en vente */
public Article ajouterArticle(String nomArticle, String description, int miseAPrix, Date dateDebut, Date dateFin) {

	Article article = null;

	article = new Article();
	article.setNomArticle(nomArticle);
	article.setDescription(description);
	article.setMiseAPrix(miseAPrix);
	article.setDateDebut(dateDebut);
	article.setDateFin(dateFin);
}

/* Selection de la catégorie du nouvel article */
public Categorie selectionCategorie(String libelle) {

	Categorie categorie = null;

	categorie = new Categorie();
	categorie.setLibelle(libelle);
}

/* Ajout d'un nouveau lieu de retrait pour le nouvel article */
public Retrait ajouterRetrait(String rueRetrait, int codePostalRetrait, String villeRetrait) {
	
	Retrait retrait = null;
	
	retrait = new Retrait();
	retrait.setRueRetrait(rueRetrait);
	retrait.setCodePostalRetrait(codePostalRetrait);
	retrait.setVilleRetrait(villeRetrait);
	}
}