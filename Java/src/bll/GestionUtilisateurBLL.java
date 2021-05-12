package bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Utilisateur;
import dal.GestionUtilisateur;
import dal.DAOFactory;

public class GestionUtilisateurBLL {
	
	private GestionUtilisateur gestionUtilisateur ;
	
	//Constructeurs
	public GestionUtilisateurBLL() {
		gestionUtilisateur = DAOFactory.getUtilisateurDAO();
	}
	
	//Methode gerant la connection d'un utilisateur
	public void gestionUtilisateur(Utilisateur connection) {
		
		//TEMPORAIRE TODO: recupérer les info de l'interface graphique
		Utilisateur utilisateur = new Utilisateur();
		/*Utilisateur connection = new Utilisateur();
		*connection.setPeudo(TODO : info de l'interface graphique);
		*connection.setMotDePasse(TODO : info de l'interface graphique);
		*/
		int pos = connection.getPseudo().indexOf("@");
		String type = null;
		
		//
		if (pos > 0) {
			//TODO connection.setEmail(connection.getPseudo());
			type = "email";
		}else if (pos < 0) {
			type = "pseudo";
		}
		
		//recuperation de l'utilisateur
		try {
			utilisateur = gestionUtilisateur.connection(connection,type);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//Verification si l'utilisateur existe ou non
		if (utilisateur.getPseudo() != null  || utilisateur.getEmail() != null) {
			
			//Verification si le mot de passe est correct
			//TODO TEMPORAIRE : connection.getMotDePasse()
			if (utilisateur.getMotDePasse().equals(connection.getEmail())) {
				System.out.println("c'est bon");
			}else {
				System.out.println("Erreur mot de passe erronée");
			}
			
		}else if (utilisateur.getPseudo() == null || utilisateur.getEmail() == null){
			System.out.println("Erreur pseudo ou email inconnue");
		}
	}
	
	//Methode gerant l'inscription d'un utilisateur
	public void InscriptionUtilisateur(Utilisateur inscrit) {
		
		List<Utilisateur> liste = new ArrayList<Utilisateur>();
		
		//recuperation des utilisateur
		try {
			liste = gestionUtilisateur.verifExistant(inscrit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String pseudoEntrer = inscrit.getPseudo();
		String emailEntrer = inscrit.getEmail();
		Boolean verif = false;
		//TODO : String mdp,confirmation
		//TODO verif motdepasse == confirmation mots de passe
		
		//vefication si le pseudo ou l'email existe deja
		for (int i =0; i< liste.size(); i++) {
			
			String pseudoBDD = liste.get(i).getPseudo();
			String emailBDD = liste.get(i).getEmail();
			
			if (pseudoEntrer.equals(pseudoBDD)) {
				verif = false;
				System.out.println("erreur pseudo déjà utiliser");
			}
			else if (emailEntrer.equals(emailBDD)) {
				verif = false;
				System.out.println("Erreur email déjà utiliser");
			}
			else if (!pseudoEntrer.equals(pseudoBDD) && !emailEntrer.equals(emailBDD)){
				verif = true;
			}
		}
		/*iscription dans la base de donne si le pseudo
		*et l'email son different de ce deja inscrit
		*/
		if (verif.equals(true)) {
			try {
				gestionUtilisateur.inscription(inscrit);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
