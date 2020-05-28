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

@WebServlet("/listaComentario")
public class ListaComentarioServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessaoUsuario = request.getSession();
		int id_topico = (int) request.getSession().getAttribute("id_topico");

		if (sessaoUsuario.getAttribute("login") != null) {

			ComentarioDAO cDAO = new ComentarioDAO();

			List<Comentario> lista = cDAO.lista(id_topico);

			request.setAttribute("lista", lista);
			request.getRequestDispatcher("exibeTopico.jsp").forward(request, response);
			return;

		} else {
			// request.getRequestDispatcher("invalidSession.jsp").forward(request,
			// response);
		}

	}

}
