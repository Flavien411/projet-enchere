
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DALSupprimerMonCompte {
	
	
	

	public DALSupprimerMonCompte() {	

	}
	
	
	
	public boolean supprimerCompte(Utilisateur utilisateur) {
		Connection connection = ConnectionDB.getConnection();
		
		try {
			
			Statement statement = connection.createStatement();
			
			String delete = "DELETE FROM utilisateur WHERE no_utilisateur = " + String.valueOf(utilisateur.getNoUtilisateur());
			
			int i = statement.executeUpdate(delete);
			
			//Renvoyer si le compte de l'utilisateur a bien été supprimé
			return i == 1;
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

}
