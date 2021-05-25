package bll;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import bo.Article;
import bo.Retrait;

public class NouvelleVenteTestBLL {
	public static void main(String[] args) {
		// Dates données pour faire les tests
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			NouvelleVenteManager mger = null;

			mger = new NouvelleVenteManager();

			// Test : Ajout d'un nouvel article
			System.out.println("Ajout d'un article");

			mger.ajouterArticle("Article2", "Test2", 200, sdf.parse("14-06-2021"), sdf.parse("18-06-2012"), "Mysto",
					"Informatique", "RueTest2", 12345, "Lyon");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
