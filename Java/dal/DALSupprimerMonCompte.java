package dal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import bo.Utilisateur;

import java.sql.Driver;
import connectionBDD.JdbcTools;

public class DALSupprimerMonCompte {
	
	
	

	public DALSupprimerMonCompte() {	

	}
	
	
	
	public boolean supprimerCompte(Utilisateur utilisateur) {
		Connection connection = JdbcTools.getConnection();
		
		try {
			
			Statement statement = connection.createStatement();
			
			String delete = "DELETE FROM utilisateur WHERE no_utilisateur = " + String.parseInt(utilisateur.getNoUtilisateur());
			
			int i = statement.executeUpdate(delete);
			
			//Renvoyer si le compte de l'utilisateur a bien été supprimé
			return i == 1;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}