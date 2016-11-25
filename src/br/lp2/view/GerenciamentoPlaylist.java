package br.lp2.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.lp2.classes.Musica;
import br.lp2.classes.Playlist;
import br.lp2.classes.Usuario;

@SuppressWarnings("serial")
public class GerenciamentoPlaylist extends JFrame {
	
	// Dimensoes da tela
	private int ALTURA = 230;
	private int LARGURA = 500;
	
	// Labels
	private JLabel labelPlaylist = new JLabel("Qual playlist deseja modificar?");
	private JLabel labelMusica = new JLabel("Qual musica quer adicionar ou excluir?");
	
	// Combo box
	private JComboBox seletorPlaylist;
	
	// Text fields
	private JTextField inputMusicas = new JTextField();
	private JTextField inputPlaylist = new JTextField();
	
	// Botoes
	private JButton adicionarMusica = new JButton("Adicionar");
	private JButton removerMusica = new JButton("Remover");
	
//	public GerenciamentoPlaylist(ArrayList<Playlist> listaPLaylists, 
//								 ArrayList<Musica> listaMusicas, 
//								 Usuario usuarioAtual) {
		
	public GerenciamentoPlaylist() {
		
		// Configuracoes padrao
		setTitle("Gerenciamento de playlist");
		setSize(LARGURA, ALTURA);
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		GridLayout gridLayout = new GridLayout(6,1, 10, 10);
		setLayout(gridLayout);
		
		// Instancia o JComboBox
		//seletorPlaylist = new JComboBox();
		
		// Adiciona elementos no gridLayout
		add(labelPlaylist);
		//add(seletorPlaylist);
		add(inputPlaylist);
		add(labelMusica);
		add(inputMusicas);
		add(adicionarMusica);
		add(removerMusica);
		
		// Eventos
		adicionarMusica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		removerMusica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		// Fechamento de janela personalizado
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				setVisible(false);
			}
		});
	}
	
}
