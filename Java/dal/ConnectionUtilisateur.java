package dal;

import java.sql.SQLException;

import bo.Utilisateur;

public interface ConnectionUtilisateur {
	public Utilisateur connectionUtilisateur() throws SQLException;
	public void inscription(Utilisateur utilisateur) throws SQLException;
}
