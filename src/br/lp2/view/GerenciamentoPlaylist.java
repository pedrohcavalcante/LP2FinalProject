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

import br.lp2.classes.Musica;
import br.lp2.classes.Playlist;
import br.lp2.classes.Usuario;
/**
 * Classe que faz o gerenciamento e instanciacao de uma playlist
 * @author Jonathan Rocha, Pedro Henrique
 * 
 */
@SuppressWarnings("serial")
public class GerenciamentoPlaylist extends JFrame {
	
	// Dimensoes da tela
	private int ALTURA = 200;
	private int LARGURA = 500;
	
	// Array de strings pro ComboBox
	String[] arrayNomePlaylist;
	String[] arrayNomeMusica;
	
	// Labels
	private JLabel labelPlaylist = new JLabel("Qual playlist deseja modificar?");
	private JLabel labelMusica = new JLabel("Qual musica quer adicionar ou excluir?");
	
	// Combo box
	private JComboBox<String> seletorPlaylist;
	private JComboBox<String> seletorMusica;
	
	// Botoes
	private JButton adicionarMusica = new JButton("Adicionar");
	private JButton removerMusica = new JButton("Remover");
	/**
	 * Construtor da classe GerenciamentoPlaylist
	 * @param listaPlaylists tipo array de playlist
	 * @param listaMusicas tipo array de musica
	 * @param usuarioAtual obj tipo usuario
	 */
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
		
		// Cria um arraylist com os nomes das musicas
		arrayNomeMusica = new String[listaMusicas.size()];
		for (int i = 0; i < listaMusicas.size(); i++) {
			arrayNomeMusica[i] = listaMusicas.get(i).getNome();
		}
		
		// Instancia os JComboBoxes
		seletorPlaylist = new JComboBox<String>(arrayNomePlaylist);
		seletorMusica = new JComboBox<String>(arrayNomeMusica);
		
		// Adiciona elementos no gridLayout
		add(labelPlaylist);
		add(seletorPlaylist);
		add(labelMusica);
		add(seletorMusica);
		add(adicionarMusica);
		add(removerMusica);
		
		// Eventos
		adicionarMusica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				listaPlaylists.get(seletorPlaylist.getSelectedIndex()).adicionarMusica(listaMusicas.get(seletorMusica.getSelectedIndex()));

				System.out.println("Adicionou =D");
			}
		});
		removerMusica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean encontrou = false;
				
				// Procura a inputada na playlists selecionada
				try{
					for (int i = 0; i < listaPlaylists.get(seletorPlaylist.getSelectedIndex()).getMusicas().size(); i++) {
				
						if (seletorMusica.getSelectedItem().equals(listaPlaylists.get(seletorPlaylist.getSelectedIndex()).getMusicas().get(i).getNome())) {
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
		
	}
}
