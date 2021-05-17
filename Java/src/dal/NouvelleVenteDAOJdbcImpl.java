package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import bo.Article;
import bo.Categorie;
import bo.Retrait;
import connectionBDD.JdbcTools;

public class NouvelleVenteDAOJdbcImpl implements NouvelleVenteDAO {

	private static final String sqlInsertArticle = " INSERT INTO ARTICLE_VENDU (nomArticle,description,miseAPrix,dateDebut,dateFin) VALUES (?,?,?,?,?)";
	private static final String sqlInsertRetrait = " INSERT INTO RETRAIT (rueRetrait,codePostalRetrait,villeRetrait) VALUES (?,?,?)";
	private static final String sqlSelectCategorie = "SELECT libelle" + " FROM CATEGORIE WHERE libelle = ?";

	@Override
	public void insertArticle(Article article) throws SQLException {

		// Connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();
		System.out.println("Connection");

		// Requête à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(sqlInsertArticle);

		// Valorisation des paramètres de la requete
		pstmt.setString(1, article.getNomArticle());
		pstmt.setString(2, article.getDescription());
		pstmt.setInt(3, article.getMiseAPrix());
		pstmt.setDate(4,
				java.sql.Date.valueOf(article.getDateDebut().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
		pstmt.setDate(5,
				java.sql.Date.valueOf(article.getDateFin().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
		pstmt.executeUpdate();
		System.out.println("Requête");

		// Fermeture de la connexion
		uneConnection.close();
		System.out.println("Fermeture");

	}

	@Override
	public List<Categorie> selectionCategorie(Categorie categorie) throws SQLException {
		
		List<Categorie> listeCategorie = new ArrayList<Categorie>();
		
		// Connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();
		System.out.println("Connection");

		// Requête à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(sqlSelectCategorie);

		// Valorisation des paramètres de la requete
		pstmt.setString(1, categorie.getLibelle());

		// Fermeture de la connexion
		uneConnection.close();
		System.out.println("Fermeture");
		
		return listeCategorie;
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
		pstmt.setString(1, retrait.getRueRetrait());
		pstmt.setInt(2, retrait.getCodePostalRetrait());
		pstmt.setString(3, retrait.getVilleRetrait());
		pstmt.executeUpdate();
		System.out.println("Requête");

		// Fermeture de la connexion
		uneConnection.close();
		System.out.println("Fermeture");

	}

}
