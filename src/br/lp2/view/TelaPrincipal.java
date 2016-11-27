package br.lp2.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.text.BreakIterator;
import java.util.ArrayList;

import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;

import javax.swing.*;

import MusicPlayer.MusicPlayer;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import br.lp2.classes.Musica;
import br.lp2.classes.Playlist;
import br.lp2.classes.Usuario;
import br.lp2.main.*;
/**
 * Classe que cria a tela principal do projeto
 * @author Jonathan Rocha, Pedro Henrique
 * 
 */
@SuppressWarnings({ "serial", "unused" })
public class TelaPrincipal extends JFrame {
	
	// Instanciando o JFileChooser usado para abrir musicas
	private JFileChooser jfile;
	private Component parent = null;
	
	// Dimensoes da tela principal
	private int ALTURA = 500;
	private int LARGURA = 750;
	
	// Atributos responsaveis por armazenas os dados do player
	private ArrayList<Musica> musicas = new ArrayList<Musica>();
	private ArrayList<Musica> playlistAtual = new ArrayList<Musica>();
	private ArrayList<Playlist> playlists = new ArrayList<Playlist>();
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<String> diretorios = new ArrayList<String>();
	
	// Janela de cadastro de usuario
	private CadastroUsuario cadastroUsuario;
	
	// Janela de gerenciar playlists
	private GerenciamentoPlaylist gerenciamentoPlaylist;
	
	// Janela de login
	private Login login;
	
	// Classe responsavel por tocar as musicas
	private MusicPlayer musicPlayer;
	
	// Menu bar
	private JMenuBar menuBar = new JMenuBar();
	// Menus
	private JMenu menuMusicas = new JMenu("Musicas");
	private JMenu menuPlaylists = new JMenu("Playlists");
	private JMenu menuUsuarios = new JMenu("Usuarios");	
	// Menu items
	private JMenuItem removerMusica = new JMenuItem("Remover musica");
	private JMenuItem removerPlaylist = new JMenuItem("Remover playlist");
	private JMenuItem gerenciarPlaylist = new JMenuItem("Gerenciar playlist");
	private JMenuItem adicionarUsuario = new JMenuItem("Cadastrar usuarios");
	private JMenuItem removerUsuario = new JMenuItem("Remover usuario");
	
	// Botoes
	private JButton adicionarMusica = new JButton("Adicionar musica");
	private JButton adicionarPasta = new JButton("Adicionar pasta");
	private JButton play = new JButton("Play");
	private JButton stop = new JButton("Stop");
	private JButton proximaMusica = new JButton(">>");
	private JButton anteriorMusica = new JButton("<<");
	private JButton adicionarPlaylist = new JButton("Adicionar playlist");
	private JButton selecionarPlaylist = new JButton("Selecionar playlist");
	
	// Labels
	private JLabel labelMusicas = new JLabel("Musicas");
	private JLabel labelAtualPlaylist = new JLabel("Playlist atual");
	private JLabel labelPlaylists = new JLabel("Playlists");
	private JLabel labelUsuario = new JLabel("Usuario atual");
	private JLabel labelVip = new JLabel("VIP");
	
	// Textfields
	private JTextArea textMusicas = new JTextArea();
	private JScrollPane paneMusicas = new JScrollPane(textMusicas);
	private JTextArea textAtualPlaylist = new JTextArea();
	private JScrollPane paneAtualPlaylist = new JScrollPane(textAtualPlaylist);
	private JTextArea textPlaylists = new JTextArea();
	private JScrollPane panePlaylists = new JScrollPane(textPlaylists);
	/**
	 * Classe que inicia a instancia da janela principal de execucao
	 * @throws ClassNotFoundException tratamento de exceção
	 * @throws InstantiationException tratamento de exceção
	 * @throws IllegalAccessException tratamento de exceção
	 * @throws UnsupportedLookAndFeelException tratamento de exceção
	 */
	public TelaPrincipal() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		// variavel de insercao de musicas
		jfile = new JFileChooser(".");
		
		// Configuracao do layout dos botoes
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		
		// Metodo desponsavel por carregar os dados dos usuarios
		carregarDados();
		
		// Instancia janela de cadastro de usuario
		cadastroUsuario = new CadastroUsuario(usuarios);
		
		// Instancia classe tocados de musica
		musicPlayer = new MusicPlayer(musicas, 0);
		
		// Seleciona o array padrao como array de musicas a ser tocado
		playlistAtual = musicas;
		
		// Configuracoes padrao
		setTitle("Player de musica");
		setSize(LARGURA, ALTURA);
		setLayout(null);
		setVisible(false);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		// Adicionando menu
		menuBar.add(menuMusicas);
		menuBar.add(menuPlaylists);
		menuBar.add(menuUsuarios);
		
		// Adicionando itens aos menus
		menuMusicas.add(removerMusica);
		menuPlaylists.add(removerPlaylist);
		menuPlaylists.add(gerenciarPlaylist);
		menuUsuarios.add(adicionarUsuario);
		menuUsuarios.add(removerUsuario);
		
		// Setando menubar
		setJMenuBar(menuBar);

		// Adicionando botoes
		add(adicionarMusica);
		add(adicionarPasta);
		add(play);
		add(stop);
		add(proximaMusica);
		add(anteriorMusica);
		add(adicionarPlaylist);
		add(selecionarPlaylist);
		// Setando posicao dos botoes
		adicionarMusica.setBounds(10, 10, 140, 30);
		adicionarPasta.setBounds(10, 50, 140, 30);
		play.setBounds(70, ALTURA - 90, 100, 30);
		stop.setBounds(180, ALTURA - 90, 100, 30);
		stop.setEnabled(false);
		proximaMusica.setBounds(290, ALTURA - 90, 50, 30);
		anteriorMusica.setBounds(10, ALTURA - 90, 50, 30);
		adicionarPlaylist.setBounds(LARGURA - 160, ALTURA - 90, 140, 30);
		selecionarPlaylist.setBounds(LARGURA - 160, 145, 140, 30);
		
		// Adicionando labels
		add(labelMusicas);
		add(labelAtualPlaylist);
		add(labelPlaylists);
		add(labelUsuario);
		add(labelVip);
		// Setando posicao das labels
		labelMusicas.setBounds(160, 20, 200, 30);
		labelAtualPlaylist.setBounds(370, 20, 200, 30);
		labelPlaylists.setBounds(LARGURA - 160, 170, 140, 30);
		labelUsuario.setBounds(LARGURA - 160, 20, 140, 30);
		labelVip.setBounds(LARGURA - 160, 40, 140, 30);
		
		// Adicionando TextAreas
		add(paneMusicas);
		add(paneAtualPlaylist);
		add(panePlaylists);
		// Setando posicao dos textfields
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		paneMusicas.setBounds(160, 50, 200, 350);
		paneMusicas.setBorder(border);
		paneMusicas.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		paneMusicas.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textMusicas.setEditable(false);
		paneAtualPlaylist.setBounds(370, 50, 200, 350);
		paneAtualPlaylist.setBorder(border);
		paneAtualPlaylist.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		paneAtualPlaylist.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textAtualPlaylist.setEditable(false);
		panePlaylists.setBounds(LARGURA - 160, 200, 140, 200);
		panePlaylists.setBorder(border);
		panePlaylists.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panePlaylists.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textPlaylists.setEditable(false);
		
		// Login inicial
		login = new Login(usuarios, labelUsuario, labelVip, this);
		
		// Eventos
		adicionarPasta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.showSaveDialog(null);
				File pasta = null;
				File[] arrayFiles = null;
				
				// Adiciona a pasta ao Arraylist de diretorios do sistema
				try{
					diretorios.add(fileChooser.getSelectedFile().getAbsolutePath());
				} catch (NullPointerException npx){
					JOptionPane.showMessageDialog(null, "Nenhuma pasta selecionada");
				}
				
				try{
					pasta = new File(fileChooser.getSelectedFile().getAbsolutePath());
					arrayFiles = pasta.listFiles();
					
					// Itera por todos os arquivos da pasta selecionada
					for (int i = 0; i < arrayFiles.length; i++) {
						// Previne erro de tentar ler arquivos com nomes menores que 4 unidades
						if (arrayFiles[i].getName().length() > 4) {
							// Checa se eh mp3
							if (arrayFiles[i].getName().substring(arrayFiles[i].getName().length() - 4).equals(".mp3")) {
		
								// Checa se o nome ou caminho tem o caractere "&"
								if (arrayFiles[i].getName().split("&").length > 1 || arrayFiles[i].getAbsolutePath().split("&").length > 1) {
									JOptionPane.showMessageDialog(null, "Existe um '&' no nome do arquivo da musica ou no caminho deste. Retire-o para que a musica possoa ser adicionada a biblioteca.");
								}
								else {
									// Checa se a musica eh repetida
									Boolean ehRepetida = false;
									for (int j = 0; j < musicas.size(); j++) {
										// Eh repetida
										if (musicas.get(j).getNome().equals(arrayFiles[i].getName())) {
											ehRepetida = true;
											break;
										}						
									}
									if (ehRepetida == false) {
										musicas.add(new Musica(arrayFiles[i].getName().substring(0, arrayFiles[i].getName().length() - 4), arrayFiles[i].getAbsolutePath()));
	
										textMusicas.append("> " + arrayFiles[i].getName().substring(0, arrayFiles[i].getName().length() - 4) + "\n");
									}
								}
							}
						}
					}
				}
				catch (NullPointerException npx){
				
				}
			}
		});
		adicionarMusica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jfile.showOpenDialog(parent);
				
				// Checa se o arquivo eh .mp3
				try{
					if (!jfile.getSelectedFile().getName().substring(jfile.getSelectedFile().getName().length() - 4).equals(".mp3")) {

						JOptionPane.showMessageDialog(null, "O arquivo selecionando nao eh um .mp3.");
					}
					else {
						// Checa a se o nome ou caminho tem o caractere "&"
						if (jfile.getSelectedFile().getName().split("&").length > 1 || jfile.getSelectedFile().getAbsolutePath().split("&").length > 1) {
							JOptionPane.showMessageDialog(null, "Existe um '&' no nome do arquivo da musica ou no caminho deste. Retire-o para que a musica possoa ser adicionada a biblioteca.");
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
								musicas.add(new Musica(jfile.getSelectedFile().getName().substring(0, jfile.getSelectedFile().getName().length() - 4), jfile.getSelectedFile().getAbsolutePath()));

								textMusicas.append("> " + jfile.getSelectedFile().getName().substring(0, jfile.getSelectedFile().getName().length() - 4) + "\n");
							}
						}	
					}
				}
				catch(NullPointerException npe){
					JOptionPane.showMessageDialog(null, "Nenhuma musica informada");
				}
			}
		});
		removerMusica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String musicaASerRemovida = JOptionPane.showInputDialog(null, "Qual musica deseja remover?");

				if (musicaASerRemovida != null){
					Boolean removida = false;
					for (int i = 0; i < musicas.size(); i++) {
						if (musicas.get(i).getNome().equals(musicaASerRemovida)) {
							musicas.remove(i);
							removida = true;
							JOptionPane.showMessageDialog(null, "Musica " + musicaASerRemovida + " removida.");

							textMusicas.setText("");
							
							for (int j = 0; j < musicas.size(); j++) {
								textMusicas.append("> " + musicas.get(j).getNome() + "\n");
							}
							
							break;
						}
					}
					
					if (removida == false) {
						JOptionPane.showMessageDialog(null, "Nao foi possivel remover a musica " + musicaASerRemovida);
					}
				}else{
					JOptionPane.showMessageDialog(null, "Nenhuma musica informada");
				}
				
				
				
			}
		});
		
		adicionarPlaylist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (login.getUsuarioAtual().getVip() == true) {
					// Recebe o nome da nova playlist do usuario
					String nomeNovaPlaylist = JOptionPane.showInputDialog(null, "Como deseja chamar a playlist?");
					
					// Cria e adiciona uma nova playlist a lista
					if (nomeNovaPlaylist != null){
						playlists.add(new Playlist(nomeNovaPlaylist, login.getUsuarioAtual().getUser()));
						
						// Imprime a nova playlist na lista de playlists
						textPlaylists.append("> " + nomeNovaPlaylist + "\n");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Somente usuarios VIPs podem criar playlists.");
				}
			}
		});
		removerPlaylist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (login.getUsuarioAtual().getVip() == true) {
					String playlistASerRemovida = JOptionPane.showInputDialog(null, "Qual playlist deseja remover?");

					if (playlistASerRemovida != null){

						Boolean removido = false;

						for (int i = 0; i < playlists.size(); i++) {
							if (playlists.get(i).getNome().equals(playlistASerRemovida)) {
								playlists.remove(i);
								removido = true;
								JOptionPane.showMessageDialog(null, "Playlist " + playlistASerRemovida + " removida.");
								break;
							}
						}
						
						if (removido == true) {
							textPlaylists.setText("");
							for (int j = 0; j < playlists.size(); j++) {
								textPlaylists.append("> " + playlists.get(j).getNome() + "\n");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Nao foi possivel remover a playlist " + playlistASerRemovida);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Somente usuarios VIPs podem excluir playlists.");
				}
			}
		});
		gerenciarPlaylist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// instancia gerenciador de playlist
				gerenciamentoPlaylist = new GerenciamentoPlaylist(playlists, musicas, login.getUsuarioAtual());
			}
		});
		selecionarPlaylist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textAtualPlaylist.setText("");
				Boolean encontrou = false;
				
				// Recebe input da playlist a ser selecionada
				String playlistSelecionada = JOptionPane.showInputDialog("Digite o nome da Playlist");

				// Procura a playlist inputada dentre as existentes no sistema
				if (playlistSelecionada != null){
					for (int i = 0; i < playlists.size(); i++){
						if (playlistSelecionada.equals(playlists.get(i).getNome())){
							
							// Imprime todas as musicas da playlist no JTextArea de playlist
							for (Musica musica : playlists.get(i).getMusicas()) {
								
								textAtualPlaylist.append("> " + musica.getNome() + "\n");
							}
							
							playlistAtual = playlists.get(i).getMusicas();
							
							encontrou = true;
							break;
						}					
					}
					
					if (encontrou == false) {
						JOptionPane.showMessageDialog(null, "A playlist " + playlistSelecionada + " nao foi encontrada na biblioteca.");
					}
				}else{
					JOptionPane.showMessageDialog(null, "Nenhuma playlist informda.");
				}
			}
				
		});
		
		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (musicPlayer.getIndex() == 0) {
					musicPlayer = new MusicPlayer(playlistAtual, 0);
				}
				else {
					musicPlayer = new MusicPlayer(playlistAtual, musicPlayer.getIndex());
				}
				
				stop.setEnabled(true);
				play.setEnabled(false);
				
				musicPlayer.start();
			}
		});			
		stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				musicPlayer.close();
				play.setEnabled(true);
				stop.setEnabled(false);
			}
		});
		proximaMusica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				musicPlayer.close();

				musicPlayer = new MusicPlayer(playlistAtual, musicPlayer.getIndex() + 1);
				
				musicPlayer.start();
				
			}
		});
		anteriorMusica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				musicPlayer.close();

				musicPlayer = new MusicPlayer(playlistAtual, musicPlayer.getIndex() - 1);
				
				musicPlayer.start();
				
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
					
					if (usuarioASerRemovido != null){
						
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
				}else{
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
	/**
	 * Metodo que mantem os dados dos usuarios no sistema
	 */
	public void persistirDados() {
		// Persiste dados dos usuarios
		BufferedWriter writerUser = null;
		try {
			File dadosUsuarios = new File("data/dadosUsuarios.txt");

			writerUser = new BufferedWriter(new FileWriter(dadosUsuarios));
			
			// Escrita no arquivo
			for(Usuario usuario : usuarios) {
				writerUser.write(usuario.getUser() + "&" + usuario.getSenha() + "&" + usuario.getVip());
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
				writerMusica.write(musica.getNome() + "&" + musica.getCaminho());
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
		
		
		// Persiste os dados das playlists
		
		// Deleta todos os arquivos dentro da pasta de playlists antes de salvar os atuais dados de playlist
		File pastaPlaylists = new File("data/playlists");
		try {
			FileUtils.cleanDirectory(pastaPlaylists);
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		
		// Cria um arquivo .txt para cada playlist
		for (Playlist playlist : playlists) {
			BufferedWriter writerPlaylist = null;
			
			try {
				File dadosPlaylist = new File("data/playlists/" + playlist.getArquivo());

				writerPlaylist = new BufferedWriter(new FileWriter(dadosPlaylist));

				// Escrita no arquivo
				writerPlaylist.write(playlist.getNome());
				writerPlaylist.newLine();
				writerPlaylist.write(playlist.getDono());
				writerPlaylist.newLine();
				for(Musica musica : playlist.getMusicas()) {
					writerPlaylist.write(musica.getNome());
					writerPlaylist.newLine();
				}

			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
					writerPlaylist.close();
				}
				catch (Exception e) {
				}
			}
		}
		
		// Persiste dados dos diretorios
		BufferedWriter writerUser4 = null;
		try {
			File dadosDiretorios = new File("data/dadosDiretorios.txt");

			writerUser4 = new BufferedWriter(new FileWriter(dadosDiretorios));

			// Escrita no arquivo
			for(String diretorio : diretorios) {
				writerUser4.write(diretorio);
				writerUser4.newLine();
			}

		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				writerUser4.close();
			}
			catch (Exception e) {
			}
		}

	}
	/**
	 * Metodo que carrega os dados dos usuarios no sistema
	 */
	public void carregarDados() {
		// Carrega dados dos usuarios
		BufferedReader br = null;

		try {
			String sCurrentLine;

			br = new BufferedReader(new FileReader("data/dadosUsuarios.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				
				String[] dados = sCurrentLine.split("&");
				
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
				
				String[] dados2 = sCurrentLine2.split("&");
				
				musicas.add(new Musica(dados2[0], dados2[1]));
				
				// mensagem para debugar
				System.out.println("Musica <" + dados2[0] + "> com caminho <" + dados2[1] + "> carregada.");
			
				// Escreve as musicas no TextArea de musicas
				textMusicas.append("> " + dados2[0] + "\n");
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
		
		// Garrega os dados das playlists
		File folder = new File("data/playlists");
		File[] arrayFiles = folder.listFiles();

		for (int i = 0; i < arrayFiles.length; i++) {

			BufferedReader br3 = null;

			try {
				String sCurrentLine3;
				
				br3 = new BufferedReader(new FileReader(arrayFiles[i].getPath()));
				
				String nomePlaylist = br3.readLine();
				String donoPlaylist = br3.readLine();
				
				Playlist novaPlaylist = new Playlist(nomePlaylist, donoPlaylist);
				
				// Mensagem para debugar
				System.out.println("Playlist <" + nomePlaylist + "> de dono <" + donoPlaylist + "> carregada.");
				
				playlists.add(novaPlaylist);
				
				textPlaylists.append("> " + novaPlaylist.getNome() + "\n");
				
				while ((sCurrentLine3 = br3.readLine()) != null) {
					String musica = sCurrentLine3;
					
					Boolean encontrou = false;
					
					// Procura a musica inputada no ArrayList de musicas
					for (int j = 0; j < musicas.size(); j++) {
						if (musica.equals(musicas.get(j).getNome())) {
							// Adiciona a musica na playlist adequada
							novaPlaylist.adicionarMusica(musicas.get(j));
							encontrou = true;
							break;
						}
					}
					
					if (encontrou == false) {
						JOptionPane.showMessageDialog(null, "Erro ao carreagar dados da playlist " + nomePlaylist + ". A musica " + musica + " nao esta na biblioteca e nao pode ser adicionada a playlist.");
					}
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
					if (br3 != null)br3.close();
				}
				catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		// Carrega dados dos diretorios
		BufferedReader br4 = null;

		try {
			String sCurrentLine;

			br4 = new BufferedReader(new FileReader("data/dadosDiretorios.txt"));

			while ((sCurrentLine = br4.readLine()) != null) {

				// mensagem para debugar
				System.out.println("Diretorio <" + sCurrentLine + "> carregado.");
				
				File pasta = new File(sCurrentLine);
				
				// Adiciona a pasta ao Arraylist de diretorios do sistema
				diretorios.add(sCurrentLine);
				// Array de files dentro da pasta
				File[] arrayFiles2 = pasta.listFiles();
				
				// Itera por todos os arquivos da pasta selecionada
				for (int i = 0; i < arrayFiles2.length; i++) {
					// Previne erro de tentar ler arquivos com nomes menores que 4 unidades
					if (arrayFiles2[i].getName().length() > 4) {
						// Checa se eh mp3
						if (arrayFiles2[i].getName().substring(arrayFiles2[i].getName().length() - 4).equals(".mp3")) {
							// Checa se o nome ou caminho tem o caractere "&"
							if (arrayFiles2[i].getName().split("&").length > 1 || arrayFiles2[i].getAbsolutePath().split("&").length > 1) {
								JOptionPane.showMessageDialog(null, "Existe um '&' no nome do arquivo da musica ou no caminho deste. Retire-o para que a musica possoa ser adicionada a biblioteca.");
							}
							else {
								// Checa se a musica eh repetida
								Boolean ehRepetida = false;
								for (int j = 0; j < musicas.size(); j++) {
									// Eh repetida
									if (musicas.get(j).getNome().equals(arrayFiles2[i].getName())) {
										ehRepetida = true;
										break;
									}						
								}
								if (ehRepetida == false) {
									musicas.add(new Musica(arrayFiles2[i].getName().substring(0, arrayFiles2[i].getName().length() - 4), arrayFiles2[i].getAbsolutePath()));

									textMusicas.append("> " + arrayFiles2[i].getName().substring(0, arrayFiles2[i].getName().length() - 4) + "\n");
								}
							}
						}
					}
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (br4 != null)br4.close();
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}		
	}
}
