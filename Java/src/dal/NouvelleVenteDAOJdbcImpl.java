package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import bo.Article;
import bo.Categorie;
import bo.Retrait;
import bo.Utilisateur;
import connectionBDD.JdbcTools;

public class NouvelleVenteDAOJdbcImpl implements NouvelleVenteDAO {

	private static final String sqlInsertArticle = " INSERT INTO ARTICLE_VENDU (nom_Article,description,mise_a_prix,date_debut_encheres,date_fin_encheres,etat_vente,no_vendeur,no_categorie) VALUES (?,?,?,?,?,?,?,?)";
	private static final String sqlInsertRetrait = " INSERT INTO RETRAIT (no_article,rue,code_postal,ville) VALUES (?,?,?,?)";
	private static final String sqlSelectNoCategorie = "SELECT no_categorie" + " FROM CATEGORIE WHERE libelle = ?";
	private static final String sqlSelectNoUtilisateur = "select no_utilisateur from utilisateur where pseudo = ?";

	@Override
	public int insertArticle(Article article, String pseudo, String libelle) throws SQLException {

		// Connection à la BDD
		ResultSet rs;
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();
		System.out.println("Connection");

		// Requête à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(sqlInsertArticle,
				PreparedStatement.RETURN_GENERATED_KEYS);

		// Valorisation des paramètres de la requete
		pstmt.setString(1, article.getNomArticle());
		pstmt.setString(2, article.getDescription());
		pstmt.setInt(3, article.getMiseAPrix());
		pstmt.setDate(4,
				java.sql.Date.valueOf(article.getDateDebut().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
		pstmt.setDate(5,
				java.sql.Date.valueOf(article.getDateFin().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
		pstmt.setString(6, article.getEtatVente());
		pstmt.setInt(7, noUtilisateur(pseudo));
		pstmt.setInt(8, noCategorie(libelle));
		pstmt.executeUpdate();
		rs = pstmt.getGeneratedKeys();
		rs.next();
		int noArticle = rs.getInt(1);
		System.out.println("Requête");

		// Fermeture de la connexion
		uneConnection.close();
		System.out.println("Fermeture");

		return noArticle;
	}

	private int noUtilisateur(String pseudo) throws SQLException {
		ResultSet rs = null;
		int num = 0;
		// connection à la BDD
		Connection uneConnectionUtilisateur = null;
		uneConnectionUtilisateur = JdbcTools.getConnection();

		PreparedStatement pstmt = uneConnectionUtilisateur.prepareStatement(sqlSelectNoUtilisateur);
		pstmt.setString(1, pseudo);
		rs = pstmt.executeQuery();
		rs.next();
		num = rs.getInt("no_utilisateur");
		// Fermeture de la connexion
		uneConnectionUtilisateur.close();

		return num;
	}

	private int noCategorie(String libelle) throws SQLException {
		ResultSet rs = null;
		int num = 0;
		// Connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();
		System.out.println("Connection");

		// Requête à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(sqlSelectNoCategorie);

		// Valorisation des paramètres de la requete
		pstmt.setString(1, libelle);

		rs = pstmt.executeQuery();
		rs.next();
		num = rs.getInt("no_categorie");
		// Fermeture de la connexion
		uneConnection.close();
		System.out.println("Fermeture");

		return num;
	}

	@Override
	public void insertRetrait(Retrait retrait) throws SQLException {
		// Connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();
		System.out.println("Connection");

		// Requête à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(sqlInsertRetrait);

		// Valorisation des paramètres de la requete
		pstmt.setInt(1, retrait.getNoArticle());
		pstmt.setString(2, retrait.getRueRetrait());
		pstmt.setInt(3, retrait.getCodePostalRetrait());
		pstmt.setString(4, retrait.getVilleRetrait());
		pstmt.executeUpdate();
		System.out.println("Requête");

		// Fermeture de la connexion
		uneConnection.close();
		System.out.println("Fermeture");

	}

}
