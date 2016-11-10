package br.lp2.main;
import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;

import br.lp2.player.PlayerFile;
import br.lp2.view.*;
@SuppressWarnings("unused")
public class Driver {
	final static JFileChooser chooser = new JFileChooser();
	static Component parent = null;
	
	public static void main(String[] args) {
		
		// GUI music = new GUI();
		CadastroUsuario cadastroUsuario = new CadastroUsuario();
		cadastroUsuario.setVisible(true);
	}

}
