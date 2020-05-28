package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Autenticador {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String autenticar(String login, String senha) throws Exception {

		try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/gameforum?useSSL=false", "guedes",
				"Fatima012020")) {

			PreparedStatement st = c.prepareStatement("select login from usuario where login=? and senha=?");
			st.setString(1, login);
			st.setString(2, senha);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				return rs.getString("login");
			} else {
				throw new Exception("Não foi possível autenticar o usuário");
			}
		}

	}

}
