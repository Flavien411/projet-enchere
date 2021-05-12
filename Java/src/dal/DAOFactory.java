package dal;
public class DAOFactory {
	public static ConnectionUtilisateur getUtilisateurDAO()
	{
		return (ConnectionUtilisateur) new ConnectionUtilisateurJdbcImpl();
	}

	public static NouvelleVenteDAO getNouvelleVenteDAO() {
		return new NouvelleVenteDAOJdbcImpl();
	}
	
	/*public static DetailVenteDAO getDetailVenteDAO() {
		return new DetailVenteDAOJdbcImpl();
	}*/
}