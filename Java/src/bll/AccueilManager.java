package bll;

import java.util.List;

import bo.Article;
import dal.AccueilDAO;
import dal.DAOFactory;

public class AccueilManager {
	private AccueilDAO acceuilDAO;

	// Constructeur
	public AccueilManager() {
		// Instancier le Data Access Object
		acceuilDAO = DAOFactory.getAcceuilDAO();
	}

	// Methode gerant l'affichage des articles
	public List<Article> afficherArticles() {
		List<Article> articles = null;
		try {
			articles = acceuilDAO.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return articles;
	}

}
