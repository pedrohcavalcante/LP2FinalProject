package MusicPlayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import br.lp2.classes.Musica;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicPlayer extends Thread{
	
	private InputStream inputStream;
	private Player musicFile = null;
	private int contador;
	private ArrayList<Musica> listaMusicas = new ArrayList<Musica>();
	
	// Construtor
	public MusicPlayer(ArrayList<Musica> listaMusicas) {
		this.listaMusicas = listaMusicas;
		contador = listaMusicas.size();
	}
	
	// Metodo responsavel por tocar as musicas
	public void run(){
		try {
			inputStream = new FileInputStream(listaMusicas.get(contador - 1).getCaminho());
			musicFile = new Player(inputStream);
			musicFile.play();
		} catch (JavaLayerException | FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public void close() {
		// TODO Auto-generated method stub
		musicFile.close();
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}
}
