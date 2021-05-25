package dal;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import connectionBDD.JdbcTools;
import bo.Utilisateur;

public class DALSupprimerMonCompte {
	
	
	

	public DALSupprimerMonCompte() {	

	}
	
	
	
	public boolean supprimerCompte(Utilisateur utilisateur) throws SQLException {
		Connection connection = JdbcTools.getConnection();
		
		try {
			
			Statement statement = connection.createStatement();
			
			String delete = "DELETE FROM utilisateur WHERE pseudo = " + String.valueOf(utilisateur.getPseudo());
			
			int i = statement.executeUpdate(delete);
			
			//Renvoyer true si le compte de l'utilisateur a bien été supprimé ou false sinon
			return i == 1;
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

}
