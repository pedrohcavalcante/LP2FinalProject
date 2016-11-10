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
		// TODO Auto-generated method stub
		try{
			chooser.showOpenDialog(parent);
		}catch (NullPointerException e ){
			System.out.println("erro1");
		}
		File caminho = chooser.getSelectedFile();
		PlayerFile music = new PlayerFile(caminho);
	}

}
