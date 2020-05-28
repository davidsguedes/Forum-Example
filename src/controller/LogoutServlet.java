package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessaoUsuario = request.getSession();

		if (sessaoUsuario != null) {
			sessaoUsuario.invalidate();
		}

		Cookie cookie = new Cookie("JSESSIONID", "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);

		response.sendRedirect("login.jsp");

		cookie.setMaxAge(0);
		response.addCookie(cookie);

	}

}
