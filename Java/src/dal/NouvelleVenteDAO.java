package dal;

import java.sql.SQLException;
import java.util.List;

import bo.Article;
import bo.Categorie;
import bo.Retrait;

public interface NouvelleVenteDAO {
	public int insertArticle(Article article, String pseudo, String libelle) throws SQLException;

	public void insertRetrait(Retrait retrait) throws SQLException;
}
