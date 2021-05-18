package dal;
public class DAOFactory {
	public static GestionUtilisateur getUtilisateurDAO()
	{
		return new GestionUtilisateurJdbcImpl();
	}

	public static NouvelleVenteDAO getNouvelleVenteDAO() {
		return new NouvelleVenteDAOJdbcImpl();
	}
	
	public static DetailVenteDAO getDetailVenteDAO() {
		return new DetailVenteDAOJdbcImpl();
	}
	
	public static ListeEnchere getListeEncherDAO() {
		return new ListeEnchereJdbcImpl();
	}
}