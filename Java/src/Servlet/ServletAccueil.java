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

public class ServletAccueil extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6264262126743044394L;

	public ServletAccueil() {
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
		liste = b.listeEnchere();
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Acceuil.html");
		rd.forward(request, response);
		}	
}
