package br.lp2.classes;

import java.util.ArrayList;

public class Playlist {
	// Atributos
	private String nome;
	private String dono;
	private String arquivo;
	private ArrayList<Musica> musicas;
	
	private static int id = 0;
	
	//Construtor
	public Playlist(String nome, String dono) {
		this.nome = nome;
		this.dono = dono;
		
		arquivo = "playlist_" + id + ".txt";
		id++;
	}
	
	// Metodos
	public void adicionarMusica(Musica musica) {
		musicas.add(musica);
	}
	public void removerMusica(Musica musica) {
		musicas.remove(musica);
	}
	
	
	public String getArquivo() {
		return arquivo;
	}
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDono() {
		return dono;
	}
	public void setDono(String dono) {
		this.dono = dono;
	}
	public ArrayList<Musica> getMusicas() {
		return musicas;
	}
	public void setMusicas(ArrayList<Musica> musicas) {
		this.musicas = musicas;
	}
}
