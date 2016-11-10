package br.lp2.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.lp2.classes.Usuario;

@SuppressWarnings("serial")
public class CadastroUsuario extends JFrame {
	
	// Dimensoes da tela principal
	private int ALTURA = 250;
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
	
	// Checkbox
	private JCheckBox vipCheckbox = new JCheckBox("VIP");
	
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
		
		// Adicionando checkbox
		add(vipCheckbox);
		vipCheckbox.setBounds(10, 140, 200, 20);
				
		// Adicionando botoes
		add(cadastrar);
		add(cancelar);
		cadastrar.setBounds(10, 180, 100, 20);
		cancelar.setBounds(LARGURA - 117, 180, 100, 20);
		
		// Eventos dos botoes
		cadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (inputUsuario.getText().equals("") || inputSenha.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Insira usuario e senha");
				}
				else {
					Usuario usuario;
					
					if (vipCheckbox.isSelected()) {
						usuario = new Usuario(inputUsuario.getText(), inputSenha.getText(), true);
					}
					else {
						usuario = new Usuario(inputUsuario.getText(), inputSenha.getText(), false);
					}
					
					inputUsuario.setText("");
					inputSenha.setText("");
					vipCheckbox.setSelected(false);
					
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
