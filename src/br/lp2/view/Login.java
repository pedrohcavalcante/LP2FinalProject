package br.lp2.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Login extends JFrame {
	
	// Dimensoes da tela principal
	private int ALTURA = 210;
	private int LARGURA = 250;
	
	// Labels
	private JLabel labelUsuario = new JLabel("Usuario");
	private JLabel labelSenha = new JLabel("Senha");
	
	// Input de texto
	private JTextField inputUsuario = new JTextField();
	private JTextField inputSenha = new JTextField();
	
	// Botoes
	private JButton playPause = new JButton("Logar");
	private JButton proximaMusica = new JButton("Cancelar");
	
	public Login() {
		// Configuracoes padrao
		setTitle("Login");
		setSize(LARGURA, ALTURA);
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Adicionando labels
		add(labelUsuario);
		add(labelSenha);
		labelUsuario.setBounds(10, 10, 200, 20);
		labelSenha.setBounds(10, 70, 200, 20);
		
		// Adicionando input de texto
		add(inputUsuario);
		add(inputSenha);
		inputUsuario.setBounds(10, 40, LARGURA - 26, 20);
		inputSenha.setBounds(10, 100, LARGURA - 26, 20);
		
		// Adicionando botoes
		add(playPause);
		add(proximaMusica);
		playPause.setBounds(10, 140, 100, 20);
		proximaMusica.setBounds(LARGURA - 117, 140, 100, 20);
	}
}
