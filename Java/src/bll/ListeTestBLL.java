package bll;

import java.util.ArrayList;
import java.util.List;

import bo.Article;

public class ListeTestBLL {

	public static void main(String[] args) {
		ListeEnchereBLL l  =new ListeEnchereBLL();
		List<Article> liste = new ArrayList<Article>();
		
		//Test listes en mode non connecté :
		
		/*//test liste deconecté (toutes)
		liste = l.listeEnchere();
		for (int i = 0;i<liste.size();i++) {
			System.out.println(liste.get(i).toString());
		}
		*/
		
		//test liste par categorie
		/*liste = l.listeCategorie("Vêtement"); //Informatique, Ameublement, Vêtement, Sport & loisir
		for (int i = 0;i<liste.size();i++) {
			System.out.println(liste.get(i).toString());
		}*/
		
		//test liste par nom article
		/*
		liste = l.listeNomArticle("e");
		for (int i = 0;i<liste.size();i++) {
			System.out.println(liste.get(i).toString());
		}*/
		
		
		
		
		//Test listes en mode connecté :
		
		//Test mes ventes en cours
		/*
		liste = l.listeMesVenteEnCours("test");
		for (int i = 0;i<liste.size();i++) {
			System.out.println(liste.get(i).toString());
		}*/
		
		//Test mes ventes non débutées
		/*
		liste = l.listeMesVenteNonDebute("Mysto");
		for (int i = 0;i<liste.size();i++) {
			System.out.println(liste.get(i).toString());
		}*/
		
		//Test mes ventes terminées
		/*
		liste = l.listeMesVenteTerminer("test");
		for (int i = 0;i<liste.size();i++) {
			System.out.println(liste.get(i).toString());
		}*/
		
		//Test mes encheres en cours
		/*
		liste = l.listeMesEnchereEnCours("Mysto");
		for (int i = 0;i<liste.size();i++) {
			System.out.println(liste.get(i).toString());
		}*/
		
		//test mes encheres remportées
		liste = l.listeMesVenteRemporte("Mysto");
		for (int i = 0;i<liste.size();i++) {
			System.out.println(liste.get(i).toString());
		}
	}

}
