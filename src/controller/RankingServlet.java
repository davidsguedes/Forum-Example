package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import model.UsuarioDAO;

/**
 * Servlet implementation class RankingServlet
 */
@WebServlet("/rankingServlet")
public class RankingServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessaoUsuario = request.getSession();

		if (sessaoUsuario.getAttribute("login") != null) {

			UsuarioDAO uDAO = new UsuarioDAO();
			List<Usuario> lista = uDAO.ranking();

			request.getSession();
			request.setAttribute("lista", lista);

			request.getRequestDispatcher("ranking.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("invalidSession.jsp").forward(request, response);
		}

	}

}
