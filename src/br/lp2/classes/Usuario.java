package br.lp2.classes;
/**
 * Classe que define um usuario com nome de usuario, senha e acesso vip
 * @author Jonathan Rocha, Pedro Henrique
 * 
 */
public class Usuario {
	// Atributos
	private String user;
	private String senha;
	private Boolean vip;
	
	// Construtor
	/**
	 * Metodo construtor da classe Usuario
	 * @param user nome do usuario
	 * @param senha senha do usuario
	 * @param vip status de VIP do usuario
	 */
	public Usuario(String user, String senha, Boolean vip) {
		this.user = user;
		this.senha = senha;
		this.vip = vip;
	}
	
	// Metodos
	/**
	 * Metodo que retorna o valor da variavel User 
	 * @return variavel user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * Matodo que atualiza o valor do User
	 * @param user usuario
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * Metodo que retorna a senha do usuario
	 * @return senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * Metodo que define a enha do usuario
	 * @param senha senha do usuario
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	/**
	 * Metodo que retorna status de VIP do usuario
	 * @return true of false
	 */
	public Boolean getVip() {
		return vip;
	}
	/**
	 * Metodo que define o valor de VIP do usuario
	 * @param vip true of false
	 */
	public void setVip(Boolean vip) {
		this.vip = vip;
	}
}
