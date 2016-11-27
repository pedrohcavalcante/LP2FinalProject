package br.lp2.classes;

import java.util.ArrayList;
/**
 * Classe que armazena o nome, o usuario dono e o arquivo de musica em uma playlist
 * @author Jonathan Rocha, Pedro Henrique
 * 
 */
public class Playlist {
	// Atributos
	private String nome;
	private String dono;
	private String arquivo;
	private ArrayList<Musica> musicas = new ArrayList<Musica>();
	
	private static int id = 0;
	
	//Construtor
	/**
	 * Construtor da classe PlayList
	 * @param nome nome do usuario
	 * @param dono dono da playlist
	 */
	public Playlist(String nome, String dono) {
		this.nome = nome;
		this.dono = dono;
		
		arquivo = "playlist_" + id + ".txt";
		id++;
		
		//System.out.println("Playlist com nome <" + nome + "> e dono <" + dono + "> e arquivo <" + arquivo + "> criada.");
	}
	
	// Metodos
	/**
	 * Metodo para adicionar musica na playlist
	 * @param musica obj tipo musica
	 */
	public void adicionarMusica(Musica musica) {
		musicas.add(musica);
	}
	/**
	 * Metodo para remover musica da playlist
	 * @param musica obj tipo musica
	 */
	public void removerMusica(Musica musica) {
		musicas.remove(musica);
	}
	/**
	 * Metodo que retorna um arquivo	
	 * @return arquivo
	 */
	public String getArquivo() {
		return arquivo;
	}
	/**
	 * Metoro que atualiza o valor de um arquivo
	 * @param arquivo obj tipo String
	 */
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	/**
	 * Metodo que retorna o valor do nome 
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Metodo que atualiza o valor do nome
	 * @param nome nome da playlist
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Metodo que retorna o valor da variavel dono
	 * @return dono 
	 */
	public String getDono() {
		return dono;
	}
	/**
	 * Metodo que atualiza o valor da variavel dono
	 * @param dono nome do dono da playlist
	 */
	public void setDono(String dono) {
		this.dono = dono;
	}
	/**
	 * Metodo que retorna o arrayList de musicas da playlist
	 * @return ArrayList array de musica
	 */
	public ArrayList<Musica> getMusicas() {
		return musicas;
	}
	/**
	 * Metodo que atualiza o valor do arraylist de musicas
	 * @param ArrayList tipo array de musicas
	 */
	public void setMusicas(ArrayList<Musica> musicas) {
		this.musicas = musicas;
	}
}
