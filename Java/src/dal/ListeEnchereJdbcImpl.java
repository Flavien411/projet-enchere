package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bo.Article;
import bo.Categorie;
import bo.Utilisateur;
import connectionBDD.JdbcTools;

public class ListeEnchereJdbcImpl implements ListeEnchere {
	
	private static final String SELECT_ListeEnchere = "SELECT nom_article,mise_a_pris,date_fin_enchere,no_categorie,no_vendeur FROM ARTICLE_VENDU WHERE date_debut_encheres >= ?";
	private static final String SELECT_PseudoVendeur = "SELECT no_utilisateur,pseudo FROM UTILISATEUR WHERE no_utilisateur = ?";
	private static final String SELECT_libelleCategorie = "SELECT no_categorie,libelle FROM Categorie WHERE no_categorie = ?";


	public List<Article> ListeEnchere() throws SQLException {
		
		List<Article> liste = new ArrayList<Article>();
		
		//connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();
		
		Date dateJour = new Date();
		
		//Requette à la BDD
		PreparedStatement pstmt =  uneConnection.prepareStatement(SELECT_ListeEnchere);
		pstmt.setDate(1,(java.sql.Date) dateJour);
		
		//Recuperation des données recupérer
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Article a = new Article();
			Categorie c = new Categorie();
			Utilisateur u = new Utilisateur();

			c = libelleCategorie(rs.getInt("no_categorie"));
			u =  pseudoVendeur(rs.getInt("no_utilisateur"));
					
			a.setNomArticle(rs.getString("nom_article"));
			a.setMiseAPrix(rs.getInt("mise_a_prix"));
			a.setDateFin(rs.getDate("date_fin_enchere"));
			a.setCategorie(c);
			a.setVendeur(u);
			liste.add(a);
		}
		
		//Fermeture de la connexion
		uneConnection.close();
		return liste;		
		
	}

	private Utilisateur pseudoVendeur(int noUtilisateur) throws SQLException {
		ResultSet rs = null;
		Utilisateur u = new Utilisateur();
		//connection à la BDD
		Connection uneConnectionUtilisateur = null;
		uneConnectionUtilisateur = JdbcTools.getConnection();
		
		PreparedStatement pstmt = uneConnectionUtilisateur.prepareStatement(SELECT_PseudoVendeur);
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
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();
		
		PreparedStatement pstmt = uneConnection.prepareStatement(SELECT_libelleCategorie);
		pstmt.setInt(1,noCategorie);
		rs = pstmt.executeQuery();
		rs.next();
		c.setNoCategorie(rs.getInt("no_categorie"));
		c.setLibelle(rs.getString("libelle"));
		
		//Fermeture de la connexion
		uneConnection.close();
		
		return null;
	}
}
