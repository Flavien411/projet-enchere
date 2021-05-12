package dal;

import java.sql.SQLException;
import java.util.List;

import bo.Article;
import bo.Categorie;
import bo.Retrait;

public interface NouvelleVenteDAO {
	public void insertArticle(Article article) throws SQLException;

	public List<Categorie> selectionCategorie(Categorie categorie) throws SQLException;

	public void insertRetrait(Retrait retrait) throws SQLException;
}
