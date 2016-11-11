package br.lp2.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.*;

import br.lp2.player.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;
//import javazoom.jl.decoder.JavaLayerException;
//import javazoom.jl.player.Player;
import br.lp2.main.*;

@SuppressWarnings({ "serial", "unused" })
public class GUI extends JFrame {
	
	
	JFileChooser jfile;
	Component parent = null;
	private Player ply;
	Music msc = new Music();
	
	// Dimensoes da tela principal
	private int ALTURA = 300;
	private int LARGURA = 500;
	
	//Player
	File p1Player;
	ArrayList<File> arrayMusic = new ArrayList<File>();
	Player pl;
	
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
	private JButton play = new JButton("Play");
	private JButton pause = new JButton("Pause");
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
		add(play);
		add(pause);
		add(proximaMusica);
		add(anteriorMusica);
		// Setando posicao dos botoes
		play.setBounds(70, ALTURA - 90, 100, 30);
		pause.setBounds(180, ALTURA - 90, 100, 30);
		proximaMusica.setBounds(290, ALTURA - 90, 50, 30);
		anteriorMusica.setBounds(10, ALTURA - 90, 50, 30);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pause.setEnabled(false);
		// Login inicial
		// Login login = new Login();		
		
		// Eventos
		adicionarMusica.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jfile.showOpenDialog(parent);
				p1Player = jfile.getSelectedFile();	
				try{
					arrayMusic.add(p1Player);
				}catch (NullPointerException ex){
					System.out.println(ex.getMessage());
					System.out.println(ex.getStackTrace());
				}
			}
		});
		
		play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pause.setEnabled(true);
				play.setEnabled(false);
				msc.run();

			}
		});			
		pause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				play.setEnabled(true);
			}
		});
		
		adicionarUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cadastroUsuario.setVisible(true);				
			}
		});
	}
	
	/*class Music extends Thread implements Runnable{
		public void run(File file_t) throws FileNotFoundException{
			System.out.println("chegou aqui");
			FileInputStream input = new FileInputStream(file_t);
			PlayerFile ply = new PlayerFile(file_t);
			Thread playing = new Thread((Runnable) ply);
			playing.run();
		}
	}*/
	class Music extends Thread{
		public void run(){
			System.out.println("chegou aqui222");
			System.out.println(arrayMusic.get(0).getPath());
			InputStream teste = this.getClass().getResourceAsStream(arrayMusic.get(0).getPath());
			//System.out.println("GETPATH() " + file.getPath() + " GETABSOLUTPATH() "+ file.getAbsolutePath());
			try {
				pl = new Player(teste);
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch(NullPointerException npe){
				//npe.printStackTrace();
				System.out.println(npe.getMessage());
				System.out.println(npe.getCause());
			}
			try {
				pl.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
