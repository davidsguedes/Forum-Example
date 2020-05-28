package model;

public class Comentario {

	private String comentario;
	private String login; // pegar o login
	private int id_topico; // pegar o id_topico

	public Comentario(String comentario, String login, int id_topico) {
		super();
		this.comentario = comentario;
		this.login = login;
		this.id_topico = id_topico;
	}

	public Comentario() {

	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getId_topico() {
		return id_topico;
	}

	public void setId_topico(int id_topico) {
		this.id_topico = id_topico;
	}

	@Override
	public String toString() {
		return "Comentario [comentario=" + comentario + ", usuario=" + login + ", topico=" + id_topico + "]";
	}

}
