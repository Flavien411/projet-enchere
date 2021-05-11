package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bo.Utilisateur;
import connectionBDD.JdbcTools;

public class ConnectionUtilisateurJdbcImpl implements ConnectionUtilisateur{
   
	private static final String SELECT_ConnectionUtilisateur=" SELECT pseudo,mot_de_passe FROM UTILISATEUR";
    private static final String INSERT_Instricption=" INSERT INTO UTILISATEUR () VALUES ()";

	@Override
	public Utilisateur connectionUtilisateur() throws SQLException {
		
		//connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();
		
		//Requette à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(SELECT_ConnectionUtilisateur);
		
		//Recuperation des données recupérer
		ResultSet rs = pstmt.executeQuery();
		Utilisateur Utilisateur = new Utilisateur();
		Utilisateur.setPseudo(rs.getString("pseudo"));
		Utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
		
		//Fermeture de la connexion
		uneConnection.close();
		
		return Utilisateur;		
	}
	
	public void inscription(Utilisateur inscrit) throws SQLException {
		
		//connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();
		
		//Requette à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(INSERT_Instricption);
		
		//Valorisation des paramètres de la requete
		pstmt.setString(1,inscrit.getPseudo() );
		pstmt.setString(2, inscrit.getNom());
		pstmt.setString(3, inscrit.getPrenom());
		pstmt.setString(4, inscrit.getEmail());
		pstmt.setString(5, inscrit.getTelephone());
		pstmt.setString(6, inscrit.getRue());
		pstmt.setInt(7, inscrit.getCodePostal());
		pstmt.setString(8, inscrit.getVille());
		pstmt.setString(9, inscrit.getMotDePasse());
		pstmt.executeUpdate();
		
		//Fermeture de la connexion
		uneConnection.close();
	}

}
