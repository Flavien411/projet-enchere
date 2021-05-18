package dal;

import java.sql.SQLException;
import java.util.List;

import bo.Article;


public interface DetailVenteDAO {
	public List<Article> selectAllArticles(Article article) throws SQLException;
}
