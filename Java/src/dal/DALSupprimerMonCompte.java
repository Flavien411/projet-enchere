
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import Java.src.connectionBDD.JdbcTools;

public class DALSupprimerMonCompte {
	
	
	

	public DALSupprimerMonCompte() {	

	}
	
	
	
	public boolean supprimerCompte(Utilisateur utilisateur) {
		Connection connection = JdbcTools.getConnection();
		
		try {
			
			Statement statement = connection.createStatement();
			
			String delete = "DELETE FROM utilisateur WHERE no_utilisateur = " + String.valueOf(utilisateur.getNoUtilisateur());
			
			int i = statement.executeUpdate(delete);
			
			//Renvoyer true si le compte de l'utilisateur a bien été supprimé ou false sinon
			return i == 1;
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

}
