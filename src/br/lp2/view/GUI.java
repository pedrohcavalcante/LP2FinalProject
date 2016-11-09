package br.lp2.view;

import java.awt.Component;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import br.lp2.player.*;
import br.lp2.main.*;

@SuppressWarnings({ "serial", "unused" })
public class GUI extends JFrame{
	JFileChooser jfile;
	Component parent = null;
	public GUI(){
		jfile = new JFileChooser();
		jfile.showOpenDialog(parent);
		Player p1Player = new Player(jfile.getSelectedFile());
		
		p1Player.Play();
	}
	
}
