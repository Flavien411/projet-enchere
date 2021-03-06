package dal;

import java.sql.SQLException;
import java.util.List;

import bo.Article;
import bo.Enchere;
import bo.Utilisateur;

public interface ListeEnchere {
	public List<Article> listeArticleVendu(String etatVente) throws SQLException;
	public List<Enchere> listeEnchere(String pseudo) throws SQLException;
	public Utilisateur noUtilisateur(String pseudo) throws SQLException;
	public List<Article> listeEnchereRemporter(String etatVente,String pseudoAcheteur) throws SQLException;

}
