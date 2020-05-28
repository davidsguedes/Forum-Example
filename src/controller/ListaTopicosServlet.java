package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Topico;
import model.TopicoDAO;

@WebServlet("/ListaTopicosServlet")
public class ListaTopicosServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessaoUsuario = request.getSession();

		if (sessaoUsuario.getAttribute("login") != null) {

			TopicoDAO tD = new TopicoDAO();

			try {

				List<Topico> lista = tD.lista();
				sessaoUsuario.setAttribute("lista", lista);
				request.getRequestDispatcher("topicos.jsp").forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			request.getRequestDispatcher("invalidSession.jsp").forward(request, response);
		}

	}

}
