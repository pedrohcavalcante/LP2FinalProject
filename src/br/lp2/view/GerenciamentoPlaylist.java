package br.lp2.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private int ALTURA = 200;
	private int LARGURA = 500;
	
	// Array de strings pro ComboBox
	String[] arrayNomePlaylist;
	
	// Labels
	private JLabel labelPlaylist = new JLabel("Qual playlist deseja modificar?");
	private JLabel labelMusica = new JLabel("Qual musica quer adicionar ou excluir?");
	
	// Combo box
	private JComboBox<String> seletorPlaylist;
	
	// Text fields
	private JTextField inputMusicas = new JTextField();
	
	// Botoes
	private JButton adicionarMusica = new JButton("Adicionar");
	private JButton removerMusica = new JButton("Remover");
	
	public GerenciamentoPlaylist(ArrayList<Playlist> listaPlaylists, 
								 ArrayList<Musica> listaMusicas, 
								 Usuario usuarioAtual) {
		
		// Configuracoes padrao
		setTitle("Gerenciamento de playlist do usuario " + usuarioAtual.getUser());
		setSize(LARGURA, ALTURA);
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridLayout gridLayout = new GridLayout(6,1, 10, 10);
		setLayout(gridLayout);
		
		// Cria um array com os nomes das playlists. Será usado pelo ComboBox.
		arrayNomePlaylist = new String[listaPlaylists.size()];
		for (int i = 0; i < listaPlaylists.size(); i++) {
			arrayNomePlaylist[i] = listaPlaylists.get(i).getNome();
		}
		
		// Instancia o JComboBox
		seletorPlaylist = new JComboBox<String>(arrayNomePlaylist);
		
		// Adiciona elementos no gridLayout
		add(labelPlaylist);
		add(seletorPlaylist);
		//add(inputPlaylist);
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
//		addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent evt) {
//				setVisible(false);
//			}
//		});
	}
	
}
