package bll;

import bo.Utilisateur;


public class test {
	
	public static void main(String[] args) {
			Utilisateur u = new Utilisateur("Mysto","Florian","Molinier","florian.molinier15@gmail.com","0565682171","15 rue des precheur",78300,"Poissy","********");
			ConnectionUtilisateurBLL b = new ConnectionUtilisateurBLL();
			 b.InscriptionUtilisateur(u);
	}
}
