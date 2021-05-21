package dal;

import java.sql.SQLException;
import java.util.List;

import bo.Article;
import bo.Enchere;
import bo.Utilisateur;

public interface ListeEnchere {
	public List<Article> listeArticleVendu() throws SQLException;
	public List<Enchere> listeEnchere() throws SQLException;
	public Utilisateur noUtilisateur(String pseudo) throws SQLException;

}
