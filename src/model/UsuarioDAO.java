package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UsuarioDAO implements IUsuarioDAO {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void inserir(Usuario u) {

		try {
			Connection c = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/gameforum?useSSL=false", "guedes", "Fatima012020");
			String sql = "INSERT INTO usuario(nome, login, email, senha, pontos) VALUES (?, ?, ?, ?, ?);";
			PreparedStatement stm = (PreparedStatement) c.prepareStatement(sql);
			stm.setString(1, u.getNome());
			stm.setString(2, u.getLogin());
			stm.setString(3, u.getSenha());
			stm.setString(4, u.getEmail());
			stm.setInt(5, u.setPontos(0));
			stm.executeUpdate();
			System.out.println("Usuário inserido com sucesso");

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível realizar o acesso", e);
		}

	}

	public Usuario recuperar(String login) {

		Usuario u = new Usuario();

		try {
			Connection c = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/gameforum?useSSL=false", "guedes", "Fatima012020");

			String sql = "SELECT * FROM usuario WHERE login = ?;";
			PreparedStatement stm = (PreparedStatement) c.prepareStatement(sql);
			stm.setString(1, login);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {

				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				u.setEmail(rs.getString("email"));
				u.setPontos(rs.getInt("pontos"));
				return u;
			}
			System.out.println("Usuário recuperado com sucesso");

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível realizar o acesso", e);
		}
		return null;
	}

	public void adicionarPontos(String login, int pontos) {

		try {
			Connection c = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/gameforum?useSSL=false", "guedes", "Fatima012020");
			String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?";
			PreparedStatement stm = (PreparedStatement) c.prepareStatement(sql);
			stm.setInt(1, pontos);
			stm.setString(2, login);
			stm.executeUpdate();
			System.out.println("Ponto inserido com sucesso");

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível realizar o acesso", e);
		}

	}

	public List<Usuario> ranking() {

		List<Usuario> ranking = new ArrayList<Usuario>();

		try {
			Connection c = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/gameforum?useSSL=false", "guedes", "Fatima012020");

			String sql = "select * from usuario order by pontos desc";
			PreparedStatement stm = (PreparedStatement) c.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				u.setEmail(rs.getString("email"));
				u.setPontos(rs.getInt("pontos"));
				ranking.add(u);
				System.out.println("Ranking listado com sucesso");
			}

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível realizar o acesso", e);
		}

		return ranking;
	}

}
