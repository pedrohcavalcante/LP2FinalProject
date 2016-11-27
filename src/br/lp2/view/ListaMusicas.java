package br.lp2.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import br.lp2.classes.Musica;
/**
 * Classe que faz a lista de musicas aparecer no sistema
 * @author Jonathan Rocha, Pedro Henrique
 * 
 */
@SuppressWarnings("serial")
public class ListaMusicas extends JFrame {
	
	// Dimensoes da tela
	private int ALTURA = 110;
	private int LARGURA = 500;
	
	// Label do topo
	private JLabel labelTopo = new JLabel("Lista de musicas:");
	
	// ArrayList das Labels para as musicas
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	/**
	 * Metodo construtor da classe ListaMusicas
	 * @param listaMusicas tipo array de musica
	 */
	public ListaMusicas(ArrayList<Musica> listaMusicas) {
		
		// Calcula ALTURA com base no tamanho do ArrayList de musicas
		int espacamento = 10;
		int alturaLabel = 10;
		int larguraLabel = LARGURA - 30;
		int padding = 20;
		if (listaMusicas.size() != 0) {
			ALTURA = (listaMusicas.size() * (alturaLabel + espacamento) + alturaLabel + espacamento) + 3 * padding;
		}
		
		// Configuracoes padrao
		setTitle("Lista de musicas");
		setSize(LARGURA, ALTURA);
		setLayout(null);
		setVisible(false);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		// Adicionando label do topo
		add(labelTopo);
		labelTopo.setBounds(padding, padding, larguraLabel, alturaLabel);
		
		// Cria as labels das musicas
		if (listaMusicas.size() == 0) {
			JLabel semMusicasLabel = new JLabel("Nao ha musicas no sistema.");
			add(semMusicasLabel);
			semMusicasLabel.setBounds(padding, 30 + espacamento, larguraLabel, alturaLabel);
		}
		else {
			for (int i = 0; i < listaMusicas.size(); i++) {
				labels.add(new JLabel(listaMusicas.get(i).getNome()));
				add(labels.get(i));
				labels.get(i).setBounds(20, 40 + i * (alturaLabel + espacamento), larguraLabel, alturaLabel);
			}
		}
		
		// Fechamento de janela personalizado
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				setVisible(false);
			}
		});
	}
}
