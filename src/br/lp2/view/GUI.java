package br.lp2.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.*;

import br.lp2.player.*;
import br.lp2.main.*;

@SuppressWarnings({ "serial", "unused" })
public class GUI extends JFrame{
	
	
	JFileChooser jfile;
	Component parent = null;
	
	
	// Dimensoes da tela principal
	private int ALTURA = 300;
	private int LARGURA = 500;
	
	//Player
	PlayerFile p1Player;
	
	// Janela de cadastro de usuario
	private CadastroUsuario cadastroUsuario = new CadastroUsuario();
	
	// Menu bar
	private JMenuBar menuBar = new JMenuBar();
	// Menus
	private JMenu menuMusicas = new JMenu("Musicas");
	private JMenu menuPlaylists = new JMenu("Playlists");
	private JMenu menuUsuarios = new JMenu("Usuarios");
	// Menu items
	private JMenuItem adicionarMusica = new JMenuItem("Adicionar musica");
	private JMenuItem removerMusica = new JMenuItem("Remover musica");
	private JMenuItem verMusicas = new JMenuItem("Ver lista de musicas");
	private JMenuItem verPlaylists = new JMenuItem("Ver playlists");	
	private JMenuItem criarPlaylist = new JMenuItem("Criar playlist");
	private JMenuItem removerPlaylist = new JMenuItem("Remover playlist");
	private JMenuItem verUsuarios = new JMenuItem("Ver lista de usuarios");
	private JMenuItem adicionarUsuario = new JMenuItem("Cadastrar usuarios");
	private JMenuItem removerUsuario = new JMenuItem("Remover usuario");

	// Botoes
	private JButton playPause = new JButton("Play/Pause");
	private JButton proximaMusica = new JButton(">>");
	private JButton anteriorMusica = new JButton("<<");
	
	public GUI() {
		jfile = new JFileChooser();
		
		// Configuracoes padrao
		setTitle("Player de musica");
		setSize(LARGURA, ALTURA);
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Adicionando menu
		menuBar.add(menuMusicas);
		menuBar.add(menuPlaylists);
		menuBar.add(menuUsuarios);
		// Adicionando itens aos menus
		menuMusicas.add(verMusicas);
		menuMusicas.add(adicionarMusica);
		menuMusicas.add(removerMusica);
		menuPlaylists.add(verPlaylists);
		menuPlaylists.add(criarPlaylist);
		menuPlaylists.add(removerPlaylist);
		menuUsuarios.add(verUsuarios);
		menuUsuarios.add(adicionarUsuario);
		menuUsuarios.add(removerUsuario);
		// Setando menubar
		setJMenuBar(menuBar);

		// Adicionando botoes
		add(playPause);
		add(proximaMusica);
		add(anteriorMusica);
		// Setando posicao dos botoes
		playPause.setBounds(70, ALTURA - 90, 100, 30);
		proximaMusica.setBounds(180, ALTURA - 90, 50, 30);
		anteriorMusica.setBounds(10, ALTURA - 90, 50, 30);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Login inicial
		// Login login = new Login();		
		
		// Eventos
		adicionarMusica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jfile.showOpenDialog(parent);
				p1Player = new PlayerFile(jfile.getSelectedFile());		
			}
		});
		playPause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				p1Player.tocar(jfile.getSelectedFile());
				p1Player.start();

			}
		});			
		
		adicionarUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cadastroUsuario.setVisible(true);				
			}
		});
	}
	
}
