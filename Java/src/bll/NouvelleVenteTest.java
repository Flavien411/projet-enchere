package bll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bo.Article;
import bo.Retrait;

public class NouvelleVenteTest {
	public static void main(String[] args) {
		// Dates données pour faire les tests
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date date1 = sdf.parse("17-05-2021");
			Date date2 = sdf.parse("25-05-2021");

			// Instanciation du jeu d'essai
			List<Article> articles = new ArrayList<>();
			System.out.println("Ajout d'un article - 1");
			articles.add(new Article("Article1", "Test1", "En cours", date1, date2, 100));

			List<Retrait> retraits = new ArrayList<>();
			System.out.println("Ajout d'un lieu de retrait - 1");
			retraits.add(new Retrait("RueTest1", 12345, "Paris"));

			/*
			 
			NouvelleVenteManager mger = null;

			mger = new NouvelleVenteManager();
			
			// Test : Ajout d'un nouvel article
			System.out.println("Ajout d'un article - 2");
			
			mger.ajouterArticle("Article2", "Test2", 200, date1, date2);
			
			
			for (Article art : articles) {
				
				mger.ajouterArticle(art);
			}
			

			// Test : Ajout d'un nouveau lieu de retrait
			System.out.println("Ajout d'un lieu de retrait - 2");

			mger.ajouterRetrait("RueTest2", 12345, "Lyon");

			
			for (Retrait ret : retraits) {

				mger.ajouterRetrait(ret);
			}
				
			// Test : Selection de la catégorie
			System.out.println("Selection de la categorie");
			mger.selectionCategorie();
			
			*/
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
