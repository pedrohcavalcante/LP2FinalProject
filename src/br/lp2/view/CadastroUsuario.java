package br.lp2.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.lp2.classes.Usuario;

@SuppressWarnings("serial")
public class CadastroUsuario extends JFrame {
	
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
	private JButton cadastrar = new JButton("Cadastrar");
	private JButton cancelar = new JButton("Fechar");
	
	public CadastroUsuario() {
		// Configuracoes padrao
		setTitle("Cadastro");
		setSize(LARGURA, ALTURA);
		setLayout(null);
		setVisible(false);
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
		
		
		
		
		
		// TODO: adicionar checkbox pra marcar como VIP.
		
		
		
		
		// Adicionando botoes
		add(cadastrar);
		add(cancelar);
		cadastrar.setBounds(10, 140, 100, 20);
		cancelar.setBounds(LARGURA - 117, 140, 100, 20);
		
		// Eventos dos botoes
		cadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (inputUsuario.getText().equals("") || inputSenha.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Insira usuario e senha");
				}
				else {
					// Usuario usuario = new Usuario(inputUsuario.getText(), inputSenha.getText());
					inputUsuario.setText("");
					inputSenha.setText("");
					
					// TODO: adicionar usuario criado no ArrayList de usuarios.
				}
			}
		});

		cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
	
}
