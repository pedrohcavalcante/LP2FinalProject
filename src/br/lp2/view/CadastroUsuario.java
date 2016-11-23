package br.lp2.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.lp2.classes.Usuario;

@SuppressWarnings("serial")
public class CadastroUsuario extends JFrame {
	
	// Dimensoes da tela
	private int ALTURA = 250;
	private int LARGURA = 250;
	
	// Labels
	private JLabel labelUsuario = new JLabel("Usuario");
	private JLabel labelSenha = new JLabel("Senha");
	
	// Input de texto
	private JTextField inputUsuario = new JTextField();
	private JTextField inputSenha = new JTextField();
	
	// Checkbox
	private JCheckBox vipCheckbox = new JCheckBox("VIP");
	
	// Botoes
	private JButton cadastrar = new JButton("Cadastrar");
	private JButton fechar = new JButton("Fechar");
	
	public CadastroUsuario(ArrayList<Usuario> listaUsuarios) {
		// Configuracoes padrao
		setTitle("Cadastro");
		setSize(LARGURA, ALTURA);
		setLayout(null);
		setVisible(false);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
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
		add(fechar);
		cadastrar.setBounds(10, 180, 100, 20);
		fechar.setBounds(LARGURA - 117, 180, 100, 20);
		
		// Eventos dos botoes
		cadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Checa se o usuario ou senha estao em branco
				if (inputUsuario.getText().equals("") || inputSenha.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Insira usuario e senha");
				}
				// Checa se o usuario inserido tem espacos
				else if (inputUsuario.getText().split("&").length > 1 ){
					JOptionPane.showMessageDialog(null, "O campo de usuario nao pode conter '&'");
				}
				// Checa se a senha inserida tem espacos
				else if (inputSenha.getText().split("&").length > 1 ){
					JOptionPane.showMessageDialog(null, "O campo de senha nao pode conter '&'");
				}
				else {
					Boolean ehRepetido = false;
					
					// Checa se o usuario eh repetido
					for (int i = 0; i < listaUsuarios.size(); i++) {
						if (inputUsuario.getText().equals(listaUsuarios.get(i).getUser())) {
							ehRepetido = true;
						}
					}
					
					if (!ehRepetido) {
						// Cria um novo usuario
						Usuario usuario;
						
						if (vipCheckbox.isSelected()) {
							usuario = new Usuario(inputUsuario.getText(), inputSenha.getText(), true);
						}
						else {
							usuario = new Usuario(inputUsuario.getText(), inputSenha.getText(), false);
						}
						
						// Limpa os campos
						inputUsuario.setText("");
						inputSenha.setText("");
						vipCheckbox.setSelected(false);
						
						// Adiciona o usuario a ArrayList de usuarios da GUI.
						listaUsuarios.add(usuario);	
					}
					else {
						JOptionPane.showMessageDialog(null, "Este usuario ja existe");
					}
				}
			}
		});

		fechar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	
		// Fechamento de janela personalizado
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				setVisible(false);
			}
		});
	}
}
