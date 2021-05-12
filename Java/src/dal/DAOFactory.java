package dal;
public class DAOFactory {
	public static GestionUtilisateur getUtilisateurDAO()
	{
		return new GestionUtilisateurJdbcImpl();
	}

	public static NouvelleVenteDAO getArticleDAO() 
	{
		return new NouvelleVenteDAOJdbcImpl();
	}
}