package dal;

import java.sql.SQLException;
import bo.Article;
import bo.Retrait;

public interface NouvelleVenteDAO {
	public int insertArticle(Article article, String pseudo, String libelle) throws SQLException;

	public void insertRetrait(Retrait retrait) throws SQLException;
}
