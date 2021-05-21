package bll;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bo.Article;
import bo.Enchere;
import bo.Utilisateur;
import dal.DAOFactory;
import dal.ListeEnchere;

public class ListeEnchereBLL {
	private ListeEnchere listeEnchere ;
	
	//Constructeurs
	public ListeEnchereBLL() {
		listeEnchere = DAOFactory.getListeEncherDAO();
	}
	
	//liste non connectée
	public List<Article> listeEnchere() {
		List<Article> liste = new ArrayList<Article>();
		List<Article> listeEnCours = new ArrayList<Article>();
		LocalDate aujourdhui = LocalDate.now();
		Date datejour = java.sql.Date.valueOf(aujourdhui);

		try {
			liste = listeEnchere.listeArticleVendu();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (int i = 0;liste.size()>i;i++) {

			Date dateDebut = liste.get(i).getDateDebut();
			
			if (datejour.after(dateDebut)) {
				listeEnCours.add(liste.get(i));
			}
		}
		return listeEnCours;
	}
	
	//liste par categorie
	public List<Article> listeCategorie(String categorie) {
		List<Article> liste = new ArrayList<Article>();
		List<Article> listeCategorie = new ArrayList<Article>();

		try {
			liste = listeEnchere.listeArticleVendu();
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
		List<Article> listeNomArticle = new ArrayList<Article>();

		try {
			liste = listeEnchere.listeArticleVendu();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (int i = 0;liste.size()>i;i++) {
			if (liste.get(i).getNomArticle().contains(nomArticle)) {
				listeNomArticle.add(liste.get(i));
			}
		}
		return listeNomArticle;
	}
	
	//liste mes vente en cours
	public List<Article> listeMesVenteEnCours(String pseudo) {
		List<Article> liste = new ArrayList<Article>();
		List<Article> listeMesVente = new ArrayList<Article>();
		LocalDate aujourdhui = LocalDate.now();
		Date datejour = java.sql.Date.valueOf(aujourdhui);

		try {
			liste = listeEnchere.listeArticleVendu();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (int i = 0;liste.size()>i;i++) {
			
			Date dateDebut = liste.get(i).getDateDebut();
			
			if (liste.get(i).getVendeur().getPseudo().equals(pseudo)) {
				if(datejour.after(dateDebut)) {
					listeMesVente.add(liste.get(i));
				}
				
			}
		}
		return listeMesVente;
	}
	
	//liste mes vente terminer
	public List<Article> listeMesVenteTerminer(String pseudo) {
		List<Article> liste = new ArrayList<Article>();
		List<Article> listeMesVenteTerminer = new ArrayList<Article>();
		LocalDate aujourdhui = LocalDate.now();
		Date datejour = java.sql.Date.valueOf(aujourdhui);

		try {
			liste = listeEnchere.listeArticleVendu();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (int i = 0;liste.size()>i;i++) {
			
			Date dateFin = liste.get(i).getDateFin();
			
			if (liste.get(i).getVendeur().getPseudo().equals(pseudo)) {
				if(dateFin.after(datejour)) {
					listeMesVenteTerminer.add(liste.get(i));
				}
				
			}
		}
		return listeMesVenteTerminer;
	}
	
	//liste mes vente non debutée
	public List<Article> listeMesVenteNonDebute(String pseudo) {
		List<Article> liste = new ArrayList<Article>();
		List<Article> listeMesVenteNonDebute = new ArrayList<Article>();
		LocalDate aujourdhui = LocalDate.now();
		Date datejour = java.sql.Date.valueOf(aujourdhui);

		try {
			liste = listeEnchere.listeArticleVendu();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (int i = 0;liste.size()>i;i++) {
			
			Date dateDebut = liste.get(i).getDateDebut();
			
			if (liste.get(i).getVendeur().getPseudo().equals(pseudo)) {
				if(dateDebut.before(datejour)) {
					listeMesVenteNonDebute.add(liste.get(i));
				}
				
			}
		}
		return listeMesVenteNonDebute;
	}
	
	//liste mes vente remportée
	public List<Article> listeMesVenteRemporte(String pseudo) {
		List<Article> liste = new ArrayList<Article>();
		List<Article> listeMesVenteNonDebute = new ArrayList<Article>();

		try {
			liste = listeEnchere.listeArticleVendu();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (int i = 0;liste.size()>i;i++) {			
			if (liste.get(i).getAcheteur().getPseudo().equals(pseudo)) {
				listeMesVenteNonDebute.add(liste.get(i));
			}
		}
		return listeMesVenteNonDebute;
	}
	
	//liste mes enchere en cours
	public List<Article> listeMesEnchereEnCours(String pseudo) {
		List<Article> liste = new ArrayList<Article>();
		List<Enchere> Enchere = new ArrayList<Enchere>();
		List<Article> listeMesEnchereEnCours = new ArrayList<Article>();
		Utilisateur u = new Utilisateur();

		try {
			liste = listeEnchere.listeArticleVendu();
			Enchere = listeEnchere.listeEnchere();
			u = listeEnchere.noUtilisateur(pseudo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0;liste.size()>i;i++) {			
			if (u.getNoUtilisateur() == Enchere.get(i).getEnchereur().getNoUtilisateur()) {
				listeMesEnchereEnCours.add(liste.get(i));
			}
		}
		return listeMesEnchereEnCours;
	}
}
