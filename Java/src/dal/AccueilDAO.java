package dal;

import java.sql.SQLException;
import java.util.List;

public interface AccueilDAO<T> {

	// Sélectionner tous les business objects
	public List<T> selectAll() throws SQLException;

	// Sélectionner un business object par son id
	public T selectByCategorie(T obj) throws SQLException;

}
