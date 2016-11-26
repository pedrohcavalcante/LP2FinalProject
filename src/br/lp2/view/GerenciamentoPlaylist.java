package br.lp2.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.lp2.classes.Musica;
import br.lp2.classes.Playlist;
import br.lp2.classes.Usuario;
/**
 * 
 * @author Jonathan Rocha, Pedro Henrique
 * Classe que faz o gerenciamento e instanciacao de uma playlist
 */
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
		
		// Cria um array com os nomes das playlists. Sera usado pelo ComboBox.
		arrayNomePlaylist = new String[listaPlaylists.size()];
		for (int i = 0; i < listaPlaylists.size(); i++) {
			arrayNomePlaylist[i] = listaPlaylists.get(i).getNome();
		}
		
		// Instancia o JComboBox
		seletorPlaylist = new JComboBox<String>(arrayNomePlaylist);
		
		// Adiciona elementos no gridLayout
		add(labelPlaylist);
		add(seletorPlaylist);
		add(labelMusica);
		add(inputMusicas);
		add(adicionarMusica);
		add(removerMusica);
		
		// Eventos
		adicionarMusica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean encontrou = false;
				
				// Procura a musica inputada no ArrayList de musicas
				for (int i = 0; i < listaMusicas.size(); i++) {
					if (inputMusicas.getText().equals(listaMusicas.get(i).getNome())) {
						// Adiciona a musica na playlist adequada
						listaPlaylists.get(seletorPlaylist.getSelectedIndex()).adicionarMusica(listaMusicas.get(i));
						encontrou = true;
						break;
					}
				}
				
				if (encontrou == false) {
					JOptionPane.showMessageDialog(null, "Esta musica nao esta na biblioteca");
				}
				else {
					// Mensagem de "adicionou musica".
					System.out.println("Adicionou =D");
				}
			}
		});
		removerMusica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean encontrou = false;
				
				// Procura a inputada na playlists selecionada
				try{
					for (int i = 0; i < listaPlaylists.get(seletorPlaylist.getSelectedIndex()).getMusicas().size(); i++) {
				
						if (inputMusicas.getText().equals(listaPlaylists.get(seletorPlaylist.getSelectedIndex()).getMusicas().get(i).getNome())) {
							// Remove a musica da playlist adequada
							listaPlaylists.get(seletorPlaylist.getSelectedIndex()).removerMusica(listaPlaylists.get(seletorPlaylist.getSelectedIndex()).getMusicas().get(i));
							encontrou = true;
							break;
						}
					}
				} catch (ArrayIndexOutOfBoundsException idx0){
				
				}
				
				if (encontrou == false) {
					JOptionPane.showMessageDialog(null, "Esta musica nao esta na playlist selecionada");
				}
				else {
					// Mensagem de "removeu musica".
					System.out.println("Removeu =D");
				}
				
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
