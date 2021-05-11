package bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Utilisateur;
import dal.ConnectionUtilisateur;
import dal.DAOFactory;

public class ConnectionUtilisateurBLL {
	
	private ConnectionUtilisateur connectionUtilisateur ;
	
	//Constructeurs
	public ConnectionUtilisateurBLL() {
		connectionUtilisateur = DAOFactory.getUtilisateurDAO();
	}

	public void connectionUtilisateur( ) {
		
	}
	
	public void InscriptionUtilisateur(Utilisateur inscrit) {
		List<Utilisateur> liste = new ArrayList<Utilisateur>();
		//recuperation des utilisateur
		try {
			liste = connectionUtilisateur.verifExistant(inscrit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String pseudoEntrer = inscrit.getPseudo();
		String emailEntrer = inscrit.getEmail();

		for (int i =0; i< liste.size(); i++) {
			String pseudoBDD = liste.get(i).getPseudo();
			String emailBDD = liste.get(i).getEmail();
			
			System.out.println(pseudoEntrer);
			System.out.println("---------");
			System.out.println(pseudoBDD);
			
			if (pseudoEntrer == pseudoBDD) {
				System.out.println("erreur pseudo deja utiliser");
			}
			else if (emailEntrer == emailBDD) {
				System.out.println("Erreur email deja utiliser");
			}
			else if (pseudoEntrer != pseudoBDD && emailEntrer == emailBDD){
				System.out.println("---------");
				System.out.println("continuer");
				try {
					connectionUtilisateur.inscription(inscrit);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
		
	}

}
