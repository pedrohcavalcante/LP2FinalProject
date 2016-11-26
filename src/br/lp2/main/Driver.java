package br.lp2.main;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.commons.io.FileUtils;

import br.lp2.classes.Musica;
import br.lp2.view.*;
/**
 * 
 * @author Jonathan Rocha, Pedro Henrique
 * Classe principal que executa a janela
 */
@SuppressWarnings("unused")
public class Driver {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		TelaPrincipal music = new TelaPrincipal();
	}

}
