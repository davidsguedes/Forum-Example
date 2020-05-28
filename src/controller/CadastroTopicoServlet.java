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
import model.UsuarioDAO;

/**
 * Servlet implementation class CadastroTopicoServlet
 */
@WebServlet("/cadastroTopico")
public class CadastroTopicoServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessaoUsuario = request.getSession();

		if (sessaoUsuario.getAttribute("login") != null) {

			String tituloTopico = request.getParameter("tituloTopico");
			String textoTopico = request.getParameter("textoTopico");
			Object u = request.getSession().getAttribute("login");

			Topico t = new Topico(tituloTopico, textoTopico, u.toString());
			TopicoDAO tD = new TopicoDAO();
			UsuarioDAO pontoUser = new UsuarioDAO();

			try {
				tD.inserirTopico(t);
				pontoUser.adicionarPontos(u.toString(), 10);

				List<Topico> lista = tD.lista();
				request.setAttribute("lista", lista);

				request.getRequestDispatcher("topicos.jsp").forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			request.getRequestDispatcher("invalidSession.jsp").forward(request, response);
		}

	}

}
