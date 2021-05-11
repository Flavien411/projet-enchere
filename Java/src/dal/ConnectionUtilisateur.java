package dal;

import java.sql.SQLException;
import java.util.List;

import bo.Utilisateur;

public interface ConnectionUtilisateur {
	public Utilisateur connectionUtilisateur() throws SQLException;
	public void inscription(Utilisateur utilisateur) throws SQLException;
	public List<Utilisateur> verifExistant(Utilisateur inscrit) throws SQLException;
}
