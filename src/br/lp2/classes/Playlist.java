package br.lp2.classes;

import java.util.ArrayList;

public class Playlist {
	// Atributos
	private int id;
	private ArrayList<Musica> musicas;
	
	// Metodos
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Musica> getMusicas() {
		return musicas;
	}
	public void setMusicas(ArrayList<Musica> musicas) {
		this.musicas = musicas;
	}
}
