package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class TopicoDAO {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void inserirTopico(Topico t) {

		try {
			Connection c = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/gameforum?useSSL=false", "guedes", "Fatima012020");
			String sql = "INSERT INTO topico(titulo, conteudo, login) VALUES (?, ?, ?);";
			PreparedStatement stm = (PreparedStatement) c.prepareStatement(sql);
			stm.setString(1, t.getTitulo());
			stm.setString(2, t.getConteudo());
			stm.setString(3, t.getLogin());
			stm.executeUpdate();
			System.out.println("Tópico inserido com sucesso");

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível realizar o acesso", e);
		}

	}

	public Topico recuperarTopico(int id_topico) {

		Topico t = new Topico();

		try {
			Connection c = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/gameforum?useSSL=false", "guedes", "Fatima012020");

			String sql = "SELECT * FROM topico WHERE id_topico = ?";
			PreparedStatement stm = (PreparedStatement) c.prepareStatement(sql);
			stm.setInt(1, id_topico);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				t.setTitulo(rs.getString("titulo"));
				t.setConteudo(rs.getString("conteudo"));
				t.setLogin(rs.getString("login"));
			}
			System.out.println("Tópico recuperado com sucesso");

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível realizar o acesso", e);
		}
		return t;
	}

	public List<Topico> lista() {

		List<Topico> lista = new ArrayList<Topico>();

		try {
			Connection c = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/gameforum?useSSL=false", "guedes", "Fatima012020");

			String sql = "select * from topico order by id_topico desc";
			PreparedStatement stm = (PreparedStatement) c.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Topico t = new Topico();
				t.setid_topico(rs.getInt("id_topico"));
				t.setTitulo(rs.getString("titulo"));
				t.setConteudo(rs.getString("conteudo"));
				t.setLogin(rs.getString("login"));
				lista.add(t);
				System.out.println("Tópicos listados com sucesso");
			}

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível realizar o acesso", e);
		}

		return lista;
	}

}
