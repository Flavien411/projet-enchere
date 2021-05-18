package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bo.Article;
import connectionBDD.JdbcTools;

public class AccueilDAOJdbcImpl implements AccueilDAO<Article> {
	private static final String sqlSelectAll = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, mise_a_prix, prix_vente, etat_vente, no_categorie, no_acheteur, no_vendeur"
			+ " FROM ARTICLE_VENDU";
	private static final String sqlselectByCategorie = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, mise_a_prix, prix_vente, etat_vente, no_categorie, no_acheteur, no_vendeur"
			+ " FROM articles WHERE no_categorie = ?";

	@Override
	public List<Article> selectAll() throws SQLException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		List<Article> liste = new ArrayList<Article>();

		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(sqlSelectAll);
			Article art = null;

			while (rs.next()) {
				art = new Article(rs.getInt("no_article"), rs.getString("nom_article"), rs.getString("description"),
						rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"), rs.getInt("mise_a_prix"),
						rs.getInt("prix_vente"), rs.getString("etat_vente"), rs.getInt("no_categorie"),
						rs.getInt("no_acheteur"), rs.getInt("no_vendeur"));
				liste.add(art);
			}
		} catch (SQLException e) {
			System.out.println("selectAll failed - ");
			e.printStackTrace();
		}

		return liste;
	}

	@Override
	public Article selectByCategorie(Article articleCritere) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Article art = null;

		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlselectByCategorie);
			rqt.setInt(1, articleCritere.getNoArticle()); //NoCategorie normalement, à voir comment modifier...

			rs = rqt.executeQuery();
			if (rs.next()) {
				art = new Article(rs.getInt("no_article"), rs.getString("nom_article"), rs.getString("description"),
						rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"), rs.getInt("mise_a_prix"),
						rs.getInt("prix_vente"), rs.getString("etat_vente"), rs.getInt("no_categorie"),
						rs.getInt("no_acheteur"), rs.getInt("no_vendeur"));
			}
		} catch (SQLException e) {
			System.out.println("selectByCategorie failed - ");
			e.printStackTrace();
		}

		return art;
	}
}
