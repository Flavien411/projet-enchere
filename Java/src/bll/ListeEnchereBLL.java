package bll;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bo.Article;
import dal.DAOFactory;
import dal.ListeEnchere;

public class ListeEnchereBLL {
	private ListeEnchere listeEnchere ;
	
	//Constructeurs
	public ListeEnchereBLL() {
		listeEnchere = DAOFactory.getListeEncherDAO();
	}
	
	//liste non connectée
	public List<Article> listeDeconnecter() {
		List<Article> liste = new ArrayList<Article>();
		List<Article> listeDeconnectée = new ArrayList<Article>();
		LocalDate aujourdhui = LocalDate.now();

		try {
			liste = listeEnchere.listeEnchere();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (int i = 0;liste.size()>i;i++) {

			Date datejour = java.sql.Date.valueOf(aujourdhui);
			Date dateDebut = liste.get(i).getDateDebut();
			
			if (datejour.after(dateDebut)) {
				System.out.println("c bon");
				listeDeconnectée.add(liste.get(i));
			}
		}
		return listeDeconnectée;
	}
	
	//liste par categorie
	public List<Article> listeCategorie(String categorie) {
		List<Article> liste = new ArrayList<Article>();
		List<Article> listeCategorie = new ArrayList<Article>();

		try {
			liste = listeEnchere.listeEnchere();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (int i = 0;liste.size()>i;i++) {
			if (liste.get(i).getCategorie().getLibelle().equals(categorie)) {
				listeCategorie.add(liste.get(i));
			}else if (categorie == "tous") {
				listeCategorie.add(liste.get(i));
			}
		}
		return listeCategorie;
	}
	
	//liste par nom article
	public List<Article> listeNomArticle(String nomArticle) {
		List<Article> liste = new ArrayList<Article>();
		List<Article> listeDeconnectée = new ArrayList<Article>();

		try {
			liste = listeEnchere.listeEnchere();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (int i = 0;liste.size()>i;i++) {
			if (liste.get(i).getNomArticle().contains(nomArticle)) {
				listeDeconnectée.add(liste.get(i));
			}
		}
		return listeDeconnectée;
	}

}
