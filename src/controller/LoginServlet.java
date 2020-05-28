package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Autenticador;
import model.Topico;
import model.TopicoDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		Autenticador a = new Autenticador();
		TopicoDAO tD = new TopicoDAO();

		try {
			String loginUsuario = a.autenticar(login, senha);

			HttpSession sessaoUsuario = request.getSession();
			sessaoUsuario.setAttribute("login", loginUsuario);

			List<Topico> lista = tD.lista();
			sessaoUsuario.setAttribute("lista", lista);
			request.getRequestDispatcher("topicos.jsp").forward(request, response);

		} catch (Exception e) {
			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher("erroLogin.jsp").forward(request, response);
		}

	}

}
