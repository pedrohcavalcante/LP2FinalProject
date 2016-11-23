package br.lp2.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.lp2.classes.Usuario;

@SuppressWarnings("serial")
public class Login extends JFrame {
	
	// Dimensoes da tela principal
	private int ALTURA = 210;
	private int LARGURA = 250;
	
	// Campo responsaovel por armazenar informacoes do login atual
	private Usuario usuarioAtual;
	private Boolean logou = false;

	// Labels
	private JLabel labelUsuario = new JLabel("Usuario");
	private JLabel labelSenha = new JLabel("Senha");
	
	// Input de texto
	private JTextField inputUsuario = new JTextField();
	private JTextField inputSenha = new JTextField();
	
	// Botoes
	private JButton logar = new JButton("Logar");
	private JButton cancelar = new JButton("Cancelar");
	
	public Login(ArrayList<Usuario> listaUsuarios, JLabel usuario, JLabel vip, TelaPrincipal tela) {
		// Configuracoes padrao
		setTitle("Login");
		setSize(LARGURA, ALTURA);
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		
		
		
		//COLOQUEI USUARIO PARA NAO TER QUE FICAR DIGITANDO HORRORES (REMOVER DEPOIS)
		inputUsuario.setText("jonathan");
		inputSenha.setText("pedro");
		
		
		
		
		
		
		
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
		add(logar);
		add(cancelar);
		logar.setBounds(10, 140, 100, 20);
		cancelar.setBounds(LARGURA - 117, 140, 100, 20);
		
		
		// Eventos
		logar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				logou = false;
				Boolean userExiste = false;
				
				for (int i = 0; i < listaUsuarios.size(); i++) {
					
					// Login do usuario admin
					if (inputUsuario.getText().equals("admin") && inputSenha.getText().equals("admin")) {
						
						usuarioAtual = new Usuario("admin", "admin", true);
						
						usuario.setText("Logado como admin");
						vip.setText("usuario VIP");
						
						setVisible(false);
						tela.setVisible(true);
						
						logou = true;
						userExiste = true;
						break;
					}
					
					if (listaUsuarios.get(i).getUser().equals(inputUsuario.getText())) {
						
						userExiste = true;
						
						if (listaUsuarios.get(i).getSenha().equals(inputSenha.getText())) {
							
							usuarioAtual = new Usuario(listaUsuarios.get(i).getUser(), listaUsuarios.get(i).getSenha(), listaUsuarios.get(i).getVip());
							
							logou = true;
							
							usuario.setText("Logado como " + listaUsuarios.get(i).getUser());
							if (listaUsuarios.get(i).getVip() == true) {
								vip.setText("usuario VIP");
							}
							else {
								vip.setText("usuario nao VIP");
							}
							
							setVisible(false);
							tela.setVisible(true);
						}
						else {							
							JOptionPane.showMessageDialog(null, "Senha incorreta");
						}
						break;
					}
				}
				
				if (logou == false && userExiste == false) {
					JOptionPane.showMessageDialog(null, "Usuario inexistente");
				}
			}
		});
		cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	// Metodos
	public Usuario getUsuarioAtual() {
		return usuarioAtual;
	}
	public void setUsuarioAtual(Usuario usuarioAtual) {
		this.usuarioAtual = usuarioAtual;
	}
}
