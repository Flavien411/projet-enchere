package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Article;
import bo.Categorie;
import bo.Utilisateur;
import connectionBDD.JdbcTools;

public class ListeEnchereJdbcImpl implements ListeEnchere {
	
	private static final String SELECT_ListeEnchere = "SELECT nom_article,mise_a_prix,date_fin_encheres,date_debut_encheres,no_categorie,no_vendeur FROM ARTICLE_VENDU";	
	private static final String SELECT_PseudoVendeur = "SELECT no_utilisateur,pseudo FROM UTILISATEUR WHERE no_utilisateur = ?";
	private static final String SELECT_libelleCategorie = "SELECT no_categorie,libelle FROM Categorie WHERE no_categorie = ?";


	public List<Article> listeEnchere() throws SQLException {
		
		List<Article> liste = new ArrayList<Article>();
		
		//connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();
		
		//Requette à la BDD
		PreparedStatement pstmt =  uneConnection.prepareStatement(SELECT_ListeEnchere);
		
		//Recuperation des données recupérer
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Article a = new Article();
			Categorie c = new Categorie();
			Utilisateur u = new Utilisateur();

			c = libelleCategorie(rs.getInt("no_categorie"));
			u =  pseudoVendeur(rs.getInt("no_vendeur"));
					
			a.setNomArticle(rs.getString("nom_article"));
			a.setMiseAPrix(rs.getInt("mise_a_prix"));
			a.setDateFin(rs.getDate("date_fin_encheres"));
			a.setDateDebut(rs.getDate("date_debut_encheres"));
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
}
