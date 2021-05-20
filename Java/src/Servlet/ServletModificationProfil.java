package Servlet;

import java.io.IOException;

import bll.GestionUtilisateurBLL;
import bo.Utilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ServletModificationProfil extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5326180208976158071L;
	
	public ServletModificationProfil() {
		super();
	}
	    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GestionUtilisateurBLL b = new GestionUtilisateurBLL();
		Utilisateur u = new Utilisateur();
		
		//recuperation des information
		u.setPseudo(request.getParameter("pseudo"));
		u.setNom(request.getParameter("nom"));
		u.setPrenom(request.getParameter("prenom"));
		u.setEmail(request.getParameter("email"));
		u.setTelephone(request.getParameter("telephone"));
		u.setRue(request.getParameter("rue"));
		u.setCodePostal(Integer.parseInt(request.getParameter("codePostal")));
		u.setVille(request.getParameter("ville"));
		
		//recuperation info session
		HttpSession session = request.getSession();
		String pseudoActuel = (String) session.getAttribute("pseudo");
		String emailActuel =  (String) session.getAttribute("email");
		
		//on regarde si le mot de passe a été modifier
		if (request.getParameter("nouveauMotDePasse").equals(null)) {

			u.setMotDePasse(request.getParameter("motDePasse"));
			b.modificationProfil(u, pseudoActuel, emailActuel);
			
			//on verifie que le nouveau mot de passe correspond a la confirmation du nouveau mot de passe
		} else if (!request.getParameter("nouveauMotDePasse").equals(null)) {
			if (request.getParameter("nouveauMotDePasse").equals((request.getParameter("confirmerMotDePasse")))) {
				
				u.setMotDePasse(request.getParameter("nouveauMotDePasse"));
				u = b.modificationProfil(u, pseudoActuel, emailActuel);
				
				//affichage des modification
				request.setAttribute("pseudo", u.getPseudo());
				request.setAttribute("nom", u.getNom());
				request.setAttribute("prenom", u.getPrenom());
				request.setAttribute("email", u.getEmail());
				request.setAttribute("telephone", u.getTelephone());
				request.setAttribute("rue", u.getRue());
				request.setAttribute("codePostal", u.getCodePostal());
				request.setAttribute("ville", u.getVille());
				request.setAttribute("motDePasse", u.getMotDePasse());
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Profil.html");
				rd.forward(request, response);
			}else {
				System.out.println("la confirmation du mot de passe est incorrecte");
			}
		}

	}
}
