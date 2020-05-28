package model;

public class Topico {

	private int id_topico;
	private String titulo;
	private String conteudo;
	private String login;

	public Topico(String titulo, String conteudo, String login) {
		super();
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.login = login;
	}

	public Topico() {

	}

	public int getid_topico() {
		return id_topico;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setid_topico(int id_topico) {
		this.id_topico = id_topico;
	}

	@Override
	public String toString() {
		return "Topico [titulo=" + titulo + ", conteudo=" + conteudo + ", login=" + login + "]";
	}

}
