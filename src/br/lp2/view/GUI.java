package br.lp2.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import br.lp2.player.*;
import br.lp2.classes.Musica;
import br.lp2.classes.Playlist;
import br.lp2.classes.Usuario;
import br.lp2.main.*;

@SuppressWarnings({ "serial", "unused" })
public class GUI extends JFrame {
	
	
	JFileChooser jfile;
	Component parent = null;
	
	
	// Dimensoes da tela principal
	private int ALTURA = 300;
	private int LARGURA = 500;
	
	// Atributos responsaveis por armazenas os dados do player
	private ArrayList<Musica> musicas = new ArrayList<Musica>();;
	private ArrayList<Playlist> playlists = new ArrayList<Playlist>();
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	//Player
	PlayerFile p1Player;
	
	// Janela de cadastro de usuario
	private CadastroUsuario cadastroUsuario;
	
	// Janela de listagem de musicas
	private ListaMusicas listaMusicas;
	
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
	private JMenuItem adicionarUsuario = new JMenuItem("Cadastrar usuarios");
	private JMenuItem removerUsuario = new JMenuItem("Remover usuario");

	// Botoes
	private JButton playPause = new JButton("Play/Pause");
	private JButton proximaMusica = new JButton(">>");
	private JButton anteriorMusica = new JButton("<<");
	
	public GUI() {
		jfile = new JFileChooser();
		
		// Metodo desponsavel por carregar os dados dos usuarios
		carregarDados();
		
		cadastroUsuario = new CadastroUsuario(usuarios);
		listaMusicas = new ListaMusicas(musicas);
		
		// Configuracoes padrao
		setTitle("Player de musica");
		setSize(LARGURA, ALTURA);
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

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
		
		
		// Login inicial
		Login login = new Login(usuarios);		
		
		// Eventos
		adicionarMusica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jfile.showOpenDialog(parent);
				
				System.out.println("Caminho: " + jfile.getSelectedFile().getAbsolutePath());
				System.out.println("Nome do arquivo: " + jfile.getSelectedFile().getName());
				
				// Checa se o arquivo é .mp3
				if (!jfile.getSelectedFile().getName().substring(jfile.getSelectedFile().getName().length() - 4).equals(".mp3")) {
					JOptionPane.showMessageDialog(null, "O arquivo selecionando nao eh um .mp3.");
				}
				else {
					// Checa a se o nome ou caminho tem o caractere "¬"
					if (jfile.getSelectedFile().getName().split("¬").length > 1 || jfile.getSelectedFile().getAbsolutePath().split("¬").length > 1) {
						JOptionPane.showMessageDialog(null, "Existe um '¬' no nome do arquivo da musica ou no caminho deste. Por favor retire-o para que a musica possoa ser adicionada a biblioteca.");
					}
					else {
						// Checa se a musica eh repetida
						Boolean ehRepetida = false;
						
						for (int i = 0; i < musicas.size(); i++) {
							// Eh repetida
							if (musicas.get(i).getNome().equals(jfile.getSelectedFile().getName())) {
								ehRepetida = true;
								break;
							}						
						}
						if (ehRepetida == false) {
							musicas.add(new Musica(jfile.getSelectedFile().getName(), jfile.getSelectedFile().getAbsolutePath()));
						}
					}
					
					// Abre arquivo no player de musica independente de ser repetida ou contem '¬'.
					p1Player = new PlayerFile(jfile.getSelectedFile());	
				}
				
					
			}
		});
		removerMusica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String musicaASerRemovida = JOptionPane.showInputDialog(null, "Qual musica deseja remover?");
				
				Boolean removida = false;
				
				for (int i = 0; i < musicas.size(); i++) {
					if (musicas.get(i).getNome().equals(musicaASerRemovida)) {
						musicas.remove(i);
						removida = true;
						JOptionPane.showMessageDialog(null, "Musica " + musicaASerRemovida + " removida.");
						break;
					}
				}
				
				if (removida == false) {
					JOptionPane.showMessageDialog(null, "Nao foi possivel remover a musica " + musicaASerRemovida);
				}
				
			}
		});
		verMusicas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				listaMusicas.setVisible(true);
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
				
				if (login.getUsuarioAtual().getVip() == true) {
					cadastroUsuario.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Somente usuarios VIPs podem cadastrar outros usuarios.");
				}
								
			}
		});
		removerUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (login.getUsuarioAtual().getVip() == true) {
					String usuarioASerRemovido = JOptionPane.showInputDialog(null, "Qual usuario deseja remover?");
					
					Boolean removido = false;
					
					for (int i = 0; i < usuarios.size(); i++) {
						if (usuarios.get(i).getUser().equals(usuarioASerRemovido)) {
							usuarios.remove(i);
							removido = true;
							JOptionPane.showMessageDialog(null, "Usuario " + usuarioASerRemovido + " removido.");
							break;
						}
					}
					
					if (removido == false) {
						JOptionPane.showMessageDialog(null, "Nao foi possivel remover o usuario " + usuarioASerRemovido);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Somente usuarios VIPs podem remover outros usuarios.");
				}
			}
		});


		// Fechamento de janela personalizado
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				persistirDados();
				
				System.exit(0);
			}
		});
	}
		
	public void persistirDados() {
		// Persiste dados dos usuarios
		BufferedWriter writerUser = null;
		try {
			File dadosUsuarios = new File("data/dadosUsuarios.txt");

			writerUser = new BufferedWriter(new FileWriter(dadosUsuarios));
			
			// Escrita no arquivo
			for(Usuario usuario : usuarios) {
				writerUser.write(usuario.getUser() + "¬" + usuario.getSenha() + "¬" + usuario.getVip());
				writerUser.newLine();
			}

		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				writerUser.close();
			}
			catch (Exception e) {
			}
		}
		
		// Persiste dados das musicas
		BufferedWriter writerMusica = null;
		try {
			File dadosMusicas = new File("data/dadosMusicas.txt");

			writerMusica = new BufferedWriter(new FileWriter(dadosMusicas));
			
			// Escrita no arquivo
			for(Musica musica : musicas) {
				writerMusica.write(musica.getNome() + "¬" + musica.getCaminho());
				writerMusica.newLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				writerMusica.close();
			}
			catch (Exception e) {
			}
		}
		
		
		// TODO: persistir dados das playlists
	}

	public void carregarDados() {
		// Carrega dados dos usuarios
		BufferedReader br = null;

		try {
			String sCurrentLine;

			br = new BufferedReader(new FileReader("data/dadosUsuarios.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				
				String[] dados = sCurrentLine.split("¬");
				
				if (dados[2].equals("true")) {
					usuarios.add(new Usuario(dados[0], dados[1], true));
				}
				else {
					usuarios.add(new Usuario(dados[0], dados[1], false));
				}
				
				// mensagem para debugar
				System.out.println("Usuario <" + dados[0] + "> com senha <" + dados[1] + "> e VIP <" + dados[2] + "> carregado.");
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (br != null)br.close();
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		// Carrega dados das musicas
		BufferedReader br2 = null;

		try {
			String sCurrentLine2;

			br2 = new BufferedReader(new FileReader("data/dadosMusicas.txt"));

			while ((sCurrentLine2 = br2.readLine()) != null) {
				
				String[] dados2 = sCurrentLine2.split("¬");
				
				musicas.add(new Musica(dados2[0], dados2[1]));
				
				// mensagem para debugar
				System.out.println("Musica <" + dados2[0] + "> com caminho <" + dados2[1] + "> carregada.");
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (br2 != null)br2.close();
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		// TODO: carregar dados das playlists		
	}
}
