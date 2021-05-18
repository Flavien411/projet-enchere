package Servlet;

import java.io.IOException;

import bll.GestionUtilisateurBLL;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ServletAfficherProfil extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7522942704590524587L;

    public ServletAfficherProfil() {
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
		b.afficherProfil(request.getParameter("pseudo"));

		HttpSession session = request.getSession();
		session.getSessionContext();

	}

}
