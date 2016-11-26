package br.lp2.classes;
/**
 * 
 * @author Jonathan Rocha, Pedro Henrique
 * Classe que instancia uma objeto musica, armazenando o nome e o caminho do arquivo
 */
public class Musica {
	// Atributos
	private String nome;
	private String caminho;
	
	// Construtor
	public Musica(String nome, String caminho) {
		this.nome = nome;
		this.caminho = caminho;
	}
	
	// Metodos
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
}
