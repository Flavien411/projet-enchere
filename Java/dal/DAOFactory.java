package dal;

public class DAOFactory {
	
	public static ConnectionUtilisateur getUtilisateurDAO()
	{
		return (ConnectionUtilisateur) new ConnectionUtilisateurJdbcImpl();
	}

}