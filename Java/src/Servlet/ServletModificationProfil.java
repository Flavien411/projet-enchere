package Servlet;

import java.io.IOException;

import bll.GestionUtilisateurBLL;
import bo.Utilisateur;
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
		//recuperation des information TODO temporaire
		u.setPseudo(request.getParameter("pseudo"));
		u.setNom(request.getParameter("nom"));
		u.setPrenom(request.getParameter("prenom"));
		u.setEmail(request.getParameter("email"));
		u.setTelephone(request.getParameter("telephone"));
		u.setRue(request.getParameter("rue"));
		u.setCodePostal(Integer.parseInt(request.getParameter("codePostal")));
		u.setVille(request.getParameter("ville"));
		
		if (request.getParameter("nouveauMotDePasse").equals(null)) {
			u.setMotDePasse(request.getParameter("motDePasse"));
		} else if (!request.getParameter("nouveauMotDePasse").equals(null)) {
			if (request.getParameter("nouveauMotDePasse").equals((request.getParameter("confirmerMotDePasse")))) {
				u.setMotDePasse(request.getParameter("nouveauMotDePasse"));
			}
		}
		b.modificationProfil(u, "pseudoActuel", "EmailActuel");

	}
}
