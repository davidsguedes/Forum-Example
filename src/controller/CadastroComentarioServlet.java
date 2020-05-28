package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Comentario;
import model.ComentarioDAO;
import model.UsuarioDAO;

/**
 * Servlet implementation class _CadastroComentarioServlet
 */
@WebServlet("/cadastroComentario")
public class CadastroComentarioServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessaoUsuario = request.getSession();
		String c = request.getParameter("textoComentario");
		request.getSession().setAttribute("comentario", c);
		UsuarioDAO pontoUser = new UsuarioDAO();

		if (sessaoUsuario.getAttribute("login") != null) {

			Object login = sessaoUsuario.getAttribute("login");
			int id_topico = (int) sessaoUsuario.getAttribute("id_topico");
			String comentario = request.getParameter("textoComentario");

			Comentario coment = new Comentario(comentario, login.toString(), id_topico);
			ComentarioDAO cDAO = new ComentarioDAO();

			try {
				cDAO.inserirComentario(coment);
				pontoUser.adicionarPontos(login.toString(), 3);
				request.setAttribute("coment", coment);
				response.sendRedirect("listaComentario");
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			request.getRequestDispatcher("invalidSession.jsp").forward(request, response);
		}
	}

}
