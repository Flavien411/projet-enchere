package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bll.ListeEnchereBLL;
import bo.Article;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ServletListeEnchere extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6264262126743044394L;

	public ServletListeEnchere() {
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
		ListeEnchereBLL b = new ListeEnchereBLL();
		List<Article> liste = new ArrayList<Article>();
		String pseudo = session.getAttribute("pseudo").toString();
		if (pseudo == null) {
			if (request.getParameter("categorie").equals("tous") && request.getParameter("recherche").equals(null)) {
				liste = b.listeEnchere();

			}else if (!request.getParameter("categorie").equals("tous") ) {
				liste = b.listeCategorie(request.getParameter("categorie"));
				
			}else if(!request.getParameter("recherche").equals(null)) {
				liste = b.listeNomArticle(request.getParameter("recherche"));
			}

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Acceuil.html");
			rd.forward(request, response);
		}else if(pseudo != null) {
			
			if (request.getParameter("categorie").equals("tous") && request.getParameter("recherche").equals(null)) {
				liste = b.listeEnchere();

			}else if (!request.getParameter("categorie").equals("tous") ) {
				
				liste = b.listeCategorie(request.getParameter("categorie"));
				
			}else if(!request.getParameter("recherche").equals(null)) {
				
				liste = b.listeNomArticle(request.getParameter("recherche"));
				
			}else if(request.getParameter("mesVente").equals("venteEnCours")) {
				
				liste = b.listeMesVenteEnCours(pseudo);
				
			}else if(request.getParameter("mesVente").equals("venteNonDebute")) {
				
				liste = b.listeMesVenteNonDebute(pseudo);
				
			}else if(request.getParameter("achat").equals("venteRemporte")) {
				
				liste = b.listeMesVenteRemporte(pseudo);
				
			}else if(request.getParameter("mesVente").equals("venteTerminer")) {
				
				liste = b.listeMesVenteTerminer(pseudo);
				
			}else if(request.getParameter("achat").equals("enchereEnCours")) {
				
				liste = b.listeMesEnchereEnCours(pseudo);
			}else if (request.getParameter("achat").equals("enchereOuverte")) {
				
				liste = b.listeEnchere();

			}
		}	

	}
}
