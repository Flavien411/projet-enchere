package dal;

import java.sql.SQLException;
import java.util.List;

import bo.Article;

public interface ListeEnchere {
	public List<Article> listeEnchere() throws SQLException;

}
