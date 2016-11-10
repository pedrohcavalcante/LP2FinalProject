package br.lp2.classes;

public class Usuario {
	// Atributos
	private String user;
	private String senha;
	private Boolean vip;
	
	// Construtor
	public Usuario(String user, String senha, Boolean vip) {
		this.user = user;
		this.senha = senha;
		this.vip = vip;
	}
	
	// Metodos
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Boolean getVip() {
		return vip;
	}
	public void setVip(Boolean vip) {
		this.vip = vip;
	}
}
