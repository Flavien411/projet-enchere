package dal;

import java.sql.SQLException;
import java.util.List;

import bo.Utilisateur;

public interface GestionUtilisateur {
	public Utilisateur connection(Utilisateur connection,String type) throws SQLException;
	public void inscription(Utilisateur utilisateur) throws SQLException;
	public List<Utilisateur> verifExistant(Utilisateur inscrit) throws SQLException;
	
	public Utilisateur VoirProfil(String pseudo) throws SQLException;
	public Utilisateur VoirMonProfil(String pseudo) throws SQLException;
	public void ModificationProfil(Utilisateur modif) throws SQLException;
}
