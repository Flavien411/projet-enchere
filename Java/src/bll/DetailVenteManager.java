package bll;

import java.sql.SQLException;

import bo.Article;
import dal.DAOFactory;
import dal.DetailVenteDAO;

public class DetailVenteManager {
	private DetailVenteDAO detailVenteDAO;

	public DetailVenteManager() {
		// Instancier le Data Access Object
		detailVenteDAO = DAOFactory.getDetailVenteDAO();
	}

	/* Récuperation des détails de l'article */
	public Article detailArticle() {

		Article article = null;

		article = new Article();
		article.getNomArticle();
		article.getDescription();
		article.getEtatVente();
		article.getDateDebut();
		article.getDateFin();
		article.getMiseAPrix();

		return article;
	}

}
