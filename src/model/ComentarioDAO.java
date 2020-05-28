package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ComentarioDAO {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void inserirComentario(Comentario c) {

		try {
			Connection con = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/gameforum?useSSL=false", "guedes", "Fatima012020");
			String sql = "INSERT INTO comentario(comentario, login, id_topico) VALUES (?, ?, ?);";
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			stm.setString(1, c.getComentario());
			stm.setString(2, c.getLogin());
			stm.setInt(3, c.getId_topico());
			stm.executeUpdate();
			System.out.println("Comentário inserido com sucesso");

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível realizar o acesso", e);
		}

	}

	public List<Comentario> lista(int id_topico) {
		List<Comentario> lista = new ArrayList<Comentario>();

		try {
			Connection con = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/gameforum?useSSL=false", "guedes", "Fatima012020");

			String sql = "select * from Comentario where id_topico = ?";
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			stm.setInt(1, id_topico);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Comentario c = new Comentario();
				c.setLogin(rs.getString("login"));
				c.setComentario(rs.getString("comentario"));
				c.setId_topico(rs.getInt("id_topico"));
				lista.add(c);
				System.out.println("Comentarios listados com sucesso");
			}

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível realizar o acesso", e);
		}

		return lista;
	}

}
