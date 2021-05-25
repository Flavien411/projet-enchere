package bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bo.Article;
import bo.Enchere;
import dal.DAOFactory;
import dal.ListeEnchere;

/**
 * 
 * @author Florian
 *
 */
public class ListeEnchereBLL {
	private ListeEnchere listeEnchere;

	// Constructeurs
	public ListeEnchereBLL() {
		listeEnchere = DAOFactory.getListeEncherDAO();
	}

	// liste non connectée
	public List<Article> listeEnchere() {
		List<Article> liste = new ArrayList<Article>();
		try {
			liste = listeEnchere.listeArticleVendu("en cours");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

	// liste par categorie
	public List<Article> listeCategorie(String categorie) {
		List<Article> liste = new ArrayList<Article>();
		List<Article> listeCategorie = new ArrayList<Article>();

		try {
			liste = listeEnchere.listeArticleVendu("en cours");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; liste.size() > i; i++) {
			if (liste.get(i).getEtatVente().equals("en cours")) {
				if (liste.get(i).getCategorie().getLibelle().equals(categorie)) {
					listeCategorie.add(liste.get(i));
				} else if (categorie == "tous") {
					listeCategorie.add(liste.get(i));
				}
			}
		}
		return listeCategorie;
	}

	// liste par nom article
	public List<Article> listeNomArticle(String nomArticle) {
		List<Article> liste = new ArrayList<Article>();
		List<Article> listeNomArticle = new ArrayList<Article>();

		try {
			liste = listeEnchere.listeArticleVendu("en cours");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; liste.size() > i; i++) {
			if (liste.get(i).getEtatVente().equals("en cours")) {

				if (liste.get(i).getNomArticle().contains(nomArticle)) {
					listeNomArticle.add(liste.get(i));
				}
			}
		}
		return listeNomArticle;
	}

	// liste mes vente en cours
	public List<Article> listeMesVenteEnCours(String pseudo) {
		List<Article> liste = new ArrayList<Article>();
		List<Article> listeMesVente = new ArrayList<Article>();

		try {
			liste = listeEnchere.listeArticleVendu("en cours");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; liste.size() > i; i++) {

			if (liste.get(i).getVendeur().getPseudo().equals(pseudo)) {
				listeMesVente.add(liste.get(i));
			}
		}
		return listeMesVente;
	}

	// liste mes vente terminer
	public List<Article> listeMesVenteTerminer(String pseudo) {
		List<Article> liste = new ArrayList<Article>();
		List<Article> listeMesVenteTerminer = new ArrayList<Article>();

		try {
			liste = listeEnchere.listeArticleVendu("terminer");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; liste.size() > i; i++) {

			if (liste.get(i).getVendeur().getPseudo().equals(pseudo)) {
				listeMesVenteTerminer.add(liste.get(i));
			}
		}
		return listeMesVenteTerminer;
	}

	// liste mes vente non debutée
	public List<Article> listeMesVenteNonDebute(String pseudo) {
		List<Article> liste = new ArrayList<Article>();
		List<Article> listeMesVenteNonDebute = new ArrayList<Article>();
		try {
			liste = listeEnchere.listeArticleVendu("non debuté");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; liste.size() > i; i++) {

			if (liste.get(i).getVendeur().getPseudo().equals(pseudo)) {
				listeMesVenteNonDebute.add(liste.get(i));

			}
		}
		return listeMesVenteNonDebute;
	}

	// liste mes enchere en cours
	public List<Article> listeMesEnchereEnCours(String pseudo) {
		List<Article> liste = new ArrayList<Article>();
		List<Enchere> Enchere = new ArrayList<Enchere>();
		List<Article> listeMesEnchereEnCours = new ArrayList<Article>();

		try {
			liste = listeEnchere.listeArticleVendu("en cours");
			Enchere = listeEnchere.listeEnchere(pseudo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; Enchere.size() > i; i++) {
			for (int j = 0; liste.size() > j; j++) {
				if (Enchere.get(i).getArticleEncherie().getNoArticle() == liste.get(j).getNoArticle()) {
					listeMesEnchereEnCours.add(liste.get(i));
				}
			}
		}
		return listeMesEnchereEnCours;
	}

	// liste mes enchere remportée
	public List<Article> listeMesVenteRemporte(String pseudo) {
		List<Article> liste = new ArrayList<Article>();
		List<Article> listeMesVenteNonDebute = new ArrayList<Article>();

		try {
			liste = listeEnchere.listeEnchereRemporter("terminer",pseudo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; liste.size() > i; i++) {
			if (liste.get(i).getAcheteur().getPseudo().equals(pseudo)) {
				listeMesVenteNonDebute.add(liste.get(i));
			}
		}
		return listeMesVenteNonDebute;
	}
}
