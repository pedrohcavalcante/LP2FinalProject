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
	 * @throws ClassNotFoundException tratamento de exceção
	 * @throws InstantiationException tratamento de exceção
	 * @throws IllegalAccessException tratamento de exceção
	 * @throws UnsupportedLookAndFeelException tratamento de exceção
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		TelaPrincipal music = new TelaPrincipal();
	}

}
