package MusicPlayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
	private int index;
	private ArrayList<Musica> listaMusicas = new ArrayList<Musica>();
	
	/**
	 * Construtor da classe MusicPlayer
	 * @param listaMusicas recebe um arrayList do tipo Musica
	 */
	public MusicPlayer(ArrayList<Musica> listaMusicas, int index) {
		this.listaMusicas = listaMusicas;
		if (index > listaMusicas.size()) {
			index = listaMusicas.size();
		}
		else if (index < 0) {
			index = 0;
		}
		else {
			this.index = index;
		}
	}
	
	
	
	
	/**
	 * Inicia a reproducao de uma musica
	 */
	public void run(){
		try {
			inputStream = new FileInputStream(listaMusicas.get(index).getCaminho());
			musicFile = new Player(inputStream);
			musicFile.play();
		} catch (JavaLayerException | FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Arquivos não encontrados");
			
		}
	}




	/**
	 * Interrompe a reproducao de uma musica
	 */
	public void close() {
		musicFile.close();
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
}
