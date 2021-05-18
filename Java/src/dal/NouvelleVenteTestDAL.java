package dal;

import java.text.SimpleDateFormat;

import bo.Article;
import bo.Retrait;

public class NouvelleVenteTestDAL {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		NouvelleVenteDAO nouvelleVenteDAO = DAOFactory.getNouvelleVenteDAO();

		// Instanciation du jeu d'essai
		try {
			Article a1 = new Article("Article1", "test1", "en cours", sdf.parse("18-05-2021"), sdf.parse("25-05-2021"),
					100);
			Article a2 = new Article("Article2", "test2", "en cours", sdf.parse("18-05-2021"), sdf.parse("25-05-2021"),
					200);
			Article a3 = new Article("Article3", "test3", "en cours", sdf.parse("18-05-2021"), sdf.parse("25-05-2021"),
					300);

			System.out.println("Ajout des articles... ");

			nouvelleVenteDAO.insertArticle(a1);
			System.out.println("Article ajouté  : " + a1.toString());
			nouvelleVenteDAO.insertArticle(a2);
			System.out.println("Article ajouté  : " + a2.toString());
			nouvelleVenteDAO.insertArticle(a3);
			System.out.println("Article ajouté  : " + a3.toString());

			Retrait r1 = new Retrait("Rue1", 12345, "Ville1");
			Retrait r2 = new Retrait("Rue2", 12345, "Ville2");
			Retrait r3 = new Retrait("Rue3", 12345, "Ville3");

			System.out.println("Ajout des retraits... ");

			nouvelleVenteDAO.insertRetrait(r1);
			System.out.println("Retrait ajouté  : " + r1.toString());
			nouvelleVenteDAO.insertRetrait(r2);
			System.out.println("Retrait ajouté  : " + r2.toString());
			nouvelleVenteDAO.insertRetrait(r3);
			System.out.println("Retrait ajouté  : " + r3.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
