package dal;

public class DAOFactory {

	public static NouvelleVenteDAO getRepasDAO() {
		return new NouvelleVenteDAOJdbcImpl();
	}
}
