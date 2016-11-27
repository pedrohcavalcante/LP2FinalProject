package br.lp2.classes;
/**
 * Classe que instancia uma objeto musica, armazenando o nome e o caminho do arquivo
 * @author Jonathan Rocha, Pedro Henrique
 * 
 */
public class Musica {
	// Atributos
	private String nome;
	private String caminho;
	
	// Construtor
	/**
	 * Construtor da classe Musica
	 * @param nome nome da musica
	 * @param caminho caminho da musica no sistema
	 */
	public Musica(String nome, String caminho) {
		this.nome = nome;
		this.caminho = caminho;
	}
	
	// Metodos
	/**
	 * Metodo que retorna o valor da variavel nome
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Metodo que atualiza o valor da variavel nome
	 * @param nome nome da musica
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Metodo que retorna o caminho contido na variavel Caminho
	 * @return caminho
	 */
	public String getCaminho() {
		return caminho;
	}
	/**
	 * Metodo que atualiza o valor da variavel Caminho
	 * @param caminho da musica no sistema
	 */
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
}
