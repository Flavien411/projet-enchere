package bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Utilisateur;
import dal.GestionUtilisateur;
import dal.DAOFactory;
/**
 * @author Florian MOLINIER
 */
public class GestionUtilisateurBLL {
	
	private GestionUtilisateur gestionUtilisateur ;
	
	//Constructeurs
	public GestionUtilisateurBLL() {
		gestionUtilisateur = DAOFactory.getUtilisateurDAO();
	}
	
	//Methode gerant la connection d'un utilisateur
	public Utilisateur Connection(String login,String motDePasse) {
		
		//TEMPORAIRE TODO: recupérer les info de l'interface graphique
		Utilisateur utilisateur = new Utilisateur();
		Utilisateur connection = new Utilisateur();
		connection.setMotDePasse(motDePasse);

		String type = null;
		
		//
		if (login.contains("@")) {
			type = "email";
			connection.setEmail(login);
		}else if (!login.contains("@")) {
			connection.setPseudo(login);
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
			if (utilisateur.getMotDePasse().equals(connection.getMotDePasse())) {
				return utilisateur;
			}else {
				System.out.println("Erreur mot de passe erronée");
			}
			
		}else if (utilisateur.getPseudo() == null){
			System.out.println("Erreur pseudo inconnue");
		}else if (utilisateur.getEmail() == null) {
			System.out.println("Erreur email inconnue");
		}

		return utilisateur;
	}
	
	//Methode gerant l'inscription d'un utilisateur
	public void InscriptionUtilisateur(Utilisateur inscrit) {
		
		List<Utilisateur> liste = new ArrayList<Utilisateur>();
		
		//recuperation des utilisateurs
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
	
	//Methode gerant l'affichage du profil d'un utilisateur
	public Utilisateur afficherProfil(String pseudo) {
		Utilisateur profil = new Utilisateur();
		
		try {
			profil = gestionUtilisateur.VoirProfil(pseudo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return profil;
	}
	
	//Methode gerant la modification du profil d'un utilisateur
	public Utilisateur modificationProfil(Utilisateur profil,String pseudoActuel,String emailActuel) {
		Utilisateur modif = new Utilisateur();
		List<Utilisateur> liste = new ArrayList<Utilisateur>();		
		
		//recuperation des utilisateurs
		try {
			liste = gestionUtilisateur.verifExistant(profil);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String pseudoEntrer = profil.getPseudo();
		String emailEntrer = profil.getEmail();
		Boolean verif = false;
			
			//verification si le pseudo a été modifier
			if (!pseudoActuel.equals(profil.getPseudo())) {
				
				//verification que le pseudo n'ai pas deja utiliser
				for (int i =0; i< liste.size(); i++) {
					
					String pseudoBDD = liste.get(i).getPseudo();
					
					if (pseudoEntrer.equals(pseudoBDD)) {
						verif = false;
						System.out.println("erreur pseudo déjà utiliser");
					}
					else if (!pseudoEntrer.equals(pseudoBDD)){
						verif = true;
					}
				}
				
			//verification si l'email a été modifier
			} else if (!emailActuel.equals(profil.getEmail())) {
				
				//verification que l'email n'ai pas deja utiliser
				for (int i =0; i< liste.size(); i++) {
					
					String emailBDD = liste.get(i).getEmail();
					
					if (emailEntrer.equals(emailBDD)) {
						verif = false;
						System.out.println("Erreur email déjà utiliser");
					}
					else if (!emailEntrer.equals(emailBDD)){
						verif = true;
					}
				}
			}
		
		/*modification dans la base de donne si le pseudo
		*et l'email son different de ce deja inscrit
		*/
		if (verif.equals(true)) {
			try {
				
				gestionUtilisateur.ModificationProfil(profil,pseudoActuel);
				modif = afficherProfil(profil.getPseudo());
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return modif;

	}

}
