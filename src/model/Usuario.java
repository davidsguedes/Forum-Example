package model;

public class Usuario {

	private String nome;
	private String login;
	private String senha;
	private String email;
	private int pontos;

	public Usuario() {
		super();
	}

	public Usuario(String nome, String login, String senha, String email, int pontos) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.pontos = pontos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPontos() {
		return pontos;
	}

	public int setPontos(int pontos) {
		return this.pontos = pontos;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", login=" + login + ", senha=" + senha + ", email=" + email + ", pontos="
				+ pontos + "]";
	}

}
