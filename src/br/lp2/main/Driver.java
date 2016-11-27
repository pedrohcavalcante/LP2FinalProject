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
 * Classe principal que executa a janela
 * @author Jonathan Rocha, Pedro Henrique
 * 
 */
@SuppressWarnings("unused")
public class Driver {
	/**
	 * Metodo principal do projeto
	 * @param args metodo principal
	 * @throws ClassNotFoundException tratamento de exce��o
	 * @throws InstantiationException tratamento de exce��o
	 * @throws IllegalAccessException tratamento de exce��o
	 * @throws UnsupportedLookAndFeelException tratamento de exce��o
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		TelaPrincipal music = new TelaPrincipal();
	}

}
