package br.lp2.main;
import java.awt.Component;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import br.lp2.classes.Musica;
import br.lp2.player.PlayerFile;
import br.lp2.view.*;
@SuppressWarnings("unused")
public class Driver {
	final static JFileChooser chooser = new JFileChooser();
	static Component parent = null;
	
	public static void main(String[] args) {
		
		GUI music = new GUI();
		//CadastroUsuario cadastroUsuario = new CadastroUsuario();
		//cadastroUsuario.setVisible(true);
		
//		ArrayList<Musica> lista = new ArrayList<Musica>();
//		lista.add(new Musica("musica 1", "caminho da musica 1"));
//		lista.add(new Musica("musica 2", "caminho da musica 2"));
//		lista.add(new Musica("musica 3", "caminho da musica 3"));
//		lista.add(new Musica("musica 4", "caminho da musica 4"));
//		lista.add(new Musica("musica 5", "caminho da musica 5"));
//		lista.add(new Musica("musica 6", "caminho da musica 4"));
//		lista.add(new Musica("musica 7", "caminho da musica 5"));
//		lista.add(new Musica("musica 8", "caminho da musica 4"));
//		lista.add(new Musica("musica 9", "caminho da musica 5"));
//		lista.add(new Musica("musica 10", "caminho da musica 5"));
//		lista.add(new Musica("musica 11", "caminho da musica 4"));
//		lista.add(new Musica("musica 12", "caminho da musica 5"));
//		lista.add(new Musica("musica 13", "caminho da musica 4"));
//		lista.add(new Musica("musica 14", "caminho da musica 5"));
//		
//		ListaMusicas listaJanela = new ListaMusicas(lista);
//		listaJanela.setVisible(true);
	}

}
