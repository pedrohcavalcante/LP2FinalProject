package MusicPlayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import br.lp2.classes.Musica;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
/**
 * Classe que instancia uma música e coloca-a para tocar, criando uma thread para evitar que a execucao da musica trave a execucao
 * @author Jonathan Rocha, Pedro Henrique
 * 
 */
public class MusicPlayer extends Thread{
	
	private InputStream inputStream;
	private Player musicFile = null;
	private int contador;
	private ArrayList<Musica> listaMusicas = new ArrayList<Musica>();
	
	// Construtor
	/**
	 * Construtor da classe MusicPlayer
	 * @param listaMusicas recebe um arrayList do tipo Musica
	 */
	public MusicPlayer(ArrayList<Musica> listaMusicas) {
		this.listaMusicas = listaMusicas;
		contador = listaMusicas.size();
	}
	
	// Metodo responsavel por tocar as musicas
	/**
	 * Metodo que inicia a reproducao de uma musica
	 */
	public void run(){
		try {
			inputStream = new FileInputStream(listaMusicas.get(contador - 1).getCaminho());
			musicFile = new Player(inputStream);
			musicFile.play();
		} catch (JavaLayerException | FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	/**
	 * Metodo que interrompe a reproducao de uma musica
	 */
	public void close() {
		// TODO Auto-generated method stub
		musicFile.close();
	}
	/**
	 * Metodo que retorna o valor do contador
	 * @return contador
	 */
	public int getContador() {
		return contador;
	}
	/**
	 * Metodo que atualiza o valor do contador
	 * @param contador contador 
	 */
	public void setContador(int contador) {
		this.contador = contador;
	}
}
