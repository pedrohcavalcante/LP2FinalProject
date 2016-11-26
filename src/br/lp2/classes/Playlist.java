package br.lp2.classes;

import java.util.ArrayList;
/**
 * 
 * @author Jonathan Rocha, Pedro Henrique
 * Classe que armazena o nome, o usuario dono e o arquivo de musica em uma playlist
 */
public class Playlist {
	// Atributos
	private String nome;
	private String dono;
	private String arquivo;
	private ArrayList<Musica> musicas = new ArrayList<Musica>();
	
	private static int id = 0;
	
	//Construtor
	public Playlist(String nome, String dono) {
		this.nome = nome;
		this.dono = dono;
		
		arquivo = "playlist_" + id + ".txt";
		id++;
		
		System.out.println("Playlist com nome <" + nome + "> e dono <" + dono + "> e arquivo <" + arquivo + "> criada.");
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
