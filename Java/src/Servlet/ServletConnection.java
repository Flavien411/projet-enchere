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

public class ServletConnection {
		/**
		 * 
		 */

		public ServletConnection() {
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
			HttpSession session = request.getSession();
			GestionUtilisateurBLL b = new GestionUtilisateurBLL();
			Utilisateur u = new Utilisateur();
			
			u = b.Connection(request.getParameter("pseudo"),request.getParameter("motDePasse"));
			if (u.getPseudo() != null && u.getEmail() != null) {
				session.setAttribute("pseudo",u.getPseudo());
				session.setAttribute("email", u.getEmail());
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Acceuil.html");
				rd.forward(request, response);
			}
		}
}
