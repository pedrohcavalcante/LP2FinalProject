package br.lp2.classes;

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
