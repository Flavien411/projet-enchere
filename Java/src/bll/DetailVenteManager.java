package bll;

import bo.Article;
import bo.Categorie;
import dal.DAOFactory;
import dal.DetailVenteDAO;


public class DetailVenteManager {
	private static DetailVenteDAO detailVenteDAO;

	public DetailVenteManager() {
		// Instancier le Data Access Object
		detailVenteDAO = DAOFactory.getDetailVenteDAO();
	}
	
	/* Récuperation des détails de l'article */
	public Article detailArticle() {

		Article article = null;

		article = new Article();
		article.getLibelle();

		return categorie;
	}

}
