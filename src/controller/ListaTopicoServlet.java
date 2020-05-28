package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Comentario;
import model.ComentarioDAO;
import model.Topico;
import model.TopicoDAO;

/**
 * Servlet implementation class ListaTopicoServlet
 */
@WebServlet("/ListaTopicoServlet")
public class ListaTopicoServlet extends HttpServlet {

	HttpSession sessaoUsuario;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessaoUsuario = request.getSession();

		if (sessaoUsuario.getAttribute("login") != null) {

			int id_topico = Integer.parseInt(request.getParameter("id_topico"));

			TopicoDAO tD = new TopicoDAO();
			ComentarioDAO cDAO = new ComentarioDAO();
			List<Comentario> lista = cDAO.lista(id_topico);

			sessaoUsuario = request.getSession();
			sessaoUsuario.setAttribute("id_topico", id_topico);

			try {
				Topico topico = tD.recuperarTopico(id_topico);
				sessaoUsuario.setAttribute("topico", topico);
				request.setAttribute("lista", lista);

				request.getRequestDispatcher("exibeTopico.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			request.getRequestDispatcher("invalidSession.jsp").forward(request, response);
		}

	}

}
