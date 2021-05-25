package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Article;
import bo.Categorie;
import bo.Enchere;
import bo.Utilisateur;
import connectionBDD.JdbcTools;

public class ListeEnchereJdbcImpl implements ListeEnchere {
	
	private static final String SELECT_ListeEnchere = "SELECT * FROM ARTICLE_VENDU Where etat_vente = ?";	
	private static final String SELECT_PseudoUtilisateur = "SELECT no_utilisateur,pseudo FROM UTILISATEUR WHERE no_utilisateur = ?";
	private static final String SELECT_NoUtilisateur = "SELECT no_utilisateur FROM UTILISATEUR WHERE pseudo = ?";
	private static final String SELECT_libelleCategorie = "SELECT no_categorie,libelle FROM Categorie WHERE no_categorie = ?";
	private static final String SELECT_Enchere = "SELECT * FROM ENCHERE WHERE no_utilisateur = ?";
	private static final String SELECT_ListeEnchereremporter = "SELECT * FROM ARTICLE_VENDU Where etat_vente = ? and no_acheteur = ?";	

	

	public List<Article> listeArticleVendu(String etatVente) throws SQLException {
		
		List<Article> liste = new ArrayList<Article>();
		
		//connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();
		
		//Requette à la BDD
		PreparedStatement pstmt =  uneConnection.prepareStatement(SELECT_ListeEnchere);
		pstmt.setString(1, etatVente);
		//Recuperation des données recupérer
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Article a = new Article();
			Categorie c = new Categorie();
			Utilisateur u = new Utilisateur();
			
			a.setNoArticle(rs.getInt("no_article"));;
			a.setNomArticle(rs.getString("nom_article"));
			a.setMiseAPrix(rs.getInt("mise_a_prix"));
			a.setDateFin(rs.getDate("date_fin_encheres"));
			a.setDateDebut(rs.getDate("date_debut_encheres"));
			c = libelleCategorie(rs.getInt("no_categorie"));		
			a.setCategorie(c);
			u =  pseudoUtilisateur(rs.getInt("no_vendeur"));
			a.setVendeur(u);
			a.setEtatVente(rs.getString("etat_vente"));
			liste.add(a);
		}
		
		//Fermeture de la connexion
		uneConnection.close();
		return liste;		
		
	}
	
	public List<Article> listeEnchereRemporter(String etatVente,String pseudoAcheteur) throws SQLException {
		
		List<Article> liste = new ArrayList<Article>();
		
		//connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();

		//Requette à la BDD
		PreparedStatement pstmt =  uneConnection.prepareStatement(SELECT_ListeEnchereremporter);
		pstmt.setString(1, etatVente);
		pstmt.setInt(2, noUtilisateur(pseudoAcheteur).getNoUtilisateur());
		
		//Recuperation des données recupérer
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Article a = new Article();
			Categorie c = new Categorie();
			Utilisateur u = new Utilisateur();
			
			a.setNoArticle(rs.getInt("no_article"));;
			a.setNomArticle(rs.getString("nom_article"));
			a.setMiseAPrix(rs.getInt("mise_a_prix"));
			a.setDateFin(rs.getDate("date_fin_encheres"));
			a.setDateDebut(rs.getDate("date_debut_encheres"));
			c = libelleCategorie(rs.getInt("no_categorie"));		
			a.setCategorie(c);
			u =  pseudoUtilisateur(rs.getInt("no_vendeur"));
			a.setVendeur(u);
			u =  pseudoUtilisateur(rs.getInt("no_acheteur"));
			a.setAcheteur(u);
			a.setEtatVente(rs.getString("etat_vente"));
			liste.add(a);
		}
		
		//Fermeture de la connexion
		uneConnection.close();
		return liste;		
		
	}

	private Utilisateur pseudoUtilisateur(int noUtilisateur) throws SQLException {
		ResultSet rs = null;
		Utilisateur u = new Utilisateur();
		//connection à la BDD
		Connection uneConnectionUtilisateur = null;
		uneConnectionUtilisateur = JdbcTools.getConnection();
		
		PreparedStatement pstmt = uneConnectionUtilisateur.prepareStatement(SELECT_PseudoUtilisateur);
		pstmt.setInt(1,noUtilisateur);
		rs = pstmt.executeQuery();
		rs.next();
		u.setNoUtilisateur(rs.getInt("no_utilisateur"));
		u.setPseudo(rs.getString("pseudo"));
		//Fermeture de la connexion
		uneConnectionUtilisateur.close();
		
		return u;
	}
	
	private Categorie libelleCategorie(int noCategorie) throws SQLException {
		ResultSet rs = null;
		Categorie c = new Categorie();
		
		//connection à la BDD
		Connection uneConnectionCategorie = null;
		uneConnectionCategorie = JdbcTools.getConnection();
		
		PreparedStatement pstmt = uneConnectionCategorie.prepareStatement(SELECT_libelleCategorie);
		pstmt.setInt(1,noCategorie);
		rs = pstmt.executeQuery();
		rs.next();
		c.setNoCategorie(rs.getInt("no_categorie"));
		c.setLibelle(rs.getString("libelle"));
		
		//Fermeture de la connexion
		uneConnectionCategorie.close();
		
		return c;
	}
	
	public Utilisateur noUtilisateur(String pseudo) throws SQLException {
		ResultSet rs = null;
		Utilisateur u = new Utilisateur();
		
		//connection à la BDD
		Connection uneConnectionUtilisateur = null;
		uneConnectionUtilisateur = JdbcTools.getConnection();
		
		PreparedStatement pstmt = uneConnectionUtilisateur.prepareStatement(SELECT_NoUtilisateur);
		pstmt.setString(1,pseudo);
		rs = pstmt.executeQuery();
		rs.next();
		u.setNoUtilisateur(rs.getInt("no_utilisateur"));
		
		//Fermeture de la connexion
		uneConnectionUtilisateur.close();
		
		return u;
	}
	
	//
	public List<Enchere> listeEnchere(String pseudo) throws SQLException {
		
		List<Enchere> listeEnchere = new ArrayList<Enchere>();
		
		//connection à la BDD
		Connection uneConnectionEnchere = null;
		uneConnectionEnchere = JdbcTools.getConnection();
		
		//Requette à la BDD
		PreparedStatement pstmt =  uneConnectionEnchere.prepareStatement(SELECT_Enchere);
		pstmt.setInt(1, noUtilisateur(pseudo).getNoUtilisateur());
		//Recuperation des données recupérer
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Enchere e = new Enchere();
			Utilisateur u = new Utilisateur();
			Article a = new Article();

			e.setDateEnchere(rs.getDate("date_enchere"));
			e.setMontantEnchere(rs.getInt("montant_enchere"));
			
			u.setNoUtilisateur(rs.getInt("no_utilisateur"));
			e.setEnchereur(u);
			
			a.setNoArticle(rs.getInt("no_article"));
			e.setArticleEncherie(a);
			
			listeEnchere.add(e);
		}
		
		//Fermeture de la connexion
		uneConnectionEnchere.close();
		return listeEnchere;		
		
	}
}
