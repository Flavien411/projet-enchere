package Servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import bll.GestionUtilisateurBLL;
import bo.Utilisateur;

public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ServletInscription() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		GestionUtilisateurBLL b = new GestionUtilisateurBLL();
		Utilisateur u = new Utilisateur();

		// recuperation des information
		u.setPseudo(request.getParameter("pseudo"));
		u.setNom(request.getParameter("nom"));
		u.setPrenom(request.getParameter("prenom"));
		u.setEmail(request.getParameter("email"));
		u.setTelephone(request.getParameter("telephone"));
		u.setRue(request.getParameter("rue"));
		u.setCodePostal(Integer.parseInt(request.getParameter("codePostal")));
		u.setVille(request.getParameter("ville"));

		// on verifie que le nouveau mot de passe correspond a la confirmation du
		// nouveau mot de passe
		if (request.getParameter("MotDePasse").equals((request.getParameter("confirmerMotDePasse")))) {
			b.InscriptionUtilisateur(u);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/seconnecter.html");
			rd.forward(request, response);
		} else {
			System.out.println("la confirmation du mot de passe est incorrecte");
		}
	}
}
