package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bo.Utilisateur;
import connectionBDD.JdbcTools;


public class ConnectionUtilisateurJdbcImpl implements ConnectionUtilisateur{
   
	private static final String SELECT_ConnectionUtilisateur=" SELECT pseudo,mot_de_passe FROM UTILISATEUR";
	private static final String SELECT_VerifExistant=" SELECT pseudo,email FROM UTILISATEUR";
    private static final String INSERT_Instricption=" INSERT INTO UTILISATEUR (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit) VALUES (?,?,?,?,?,?,?,?,?,?)";

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
	

	@Override
	public List<Utilisateur> verifExistant(Utilisateur inscrit) throws SQLException {
		
		List<Utilisateur> liste = new ArrayList<Utilisateur>();

		//connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();
		

		
		//Requette à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(SELECT_VerifExistant);
		
		//Recuperation des données recupérer
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Utilisateur verif = new Utilisateur(rs.getString("pseudo"),rs.getString("email"));
			liste.add(verif);
		}
		
		//Fermeture de la connexion
		uneConnection.close();
		
		return liste;		
	}
	
	@Override
	public void inscription(Utilisateur inscrit) throws SQLException {
		
		//connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();
		System.out.println("connection");
		
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
		pstmt.setInt(10, 0);
		pstmt.executeUpdate();
		System.out.println("requette");

		//Fermeture de la connexion
		uneConnection.close();
		System.out.println("fermeture");


	}

}
