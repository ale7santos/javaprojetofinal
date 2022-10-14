package br.com.voeairlines.javaprojetofinal;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	
	private JLabel lblUsuario;
	private JLabel lblSenha;
	
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private JButton btnLogar;
	
	private FlowLayout layout;
	private Container container;
	
	JMenuBar barraMenu = new JMenuBar();
	JMenu jmAtividade = new JMenu("CRUD");
	JMenuItem cadastroAeronave = new JMenuItem("Novo Cadastro");
	JMenuItem atualizarAeronave = new JMenuItem("Atualizar Aeronave");
	JMenuItem pesquisarAeronave = new JMenuItem("Pesquisar Aeronave");
	JMenuItem deletarAeronave = new JMenuItem("Deletar Aeronave");
	

	public Login() {
		
		super();
		
		setTitle("VoeAirLines");
		
		layout = new FlowLayout();
		container = getContentPane();
		
		btnLogar = new JButton("Logar");
		lblUsuario = new JLabel("Usuário");
		lblSenha = new JLabel("Senha");
		
		setJMenuBar(barraMenu);
		barraMenu.add(jmAtividade);
		jmAtividade.add(cadastroAeronave);
		jmAtividade.add(atualizarAeronave);
		jmAtividade.add(pesquisarAeronave);
		jmAtividade.add(deletarAeronave);
		
		
	
		txtUsuario = new JTextField();
		txtUsuario.setColumns(15);
		
		txtSenha = new JPasswordField();
		txtSenha.setColumns(15); 
		txtSenha.setSize(200, 30);
		
				
		//txtUsuario = new JTextField(20);
		//txtSenha = new JPasswordField(20);
		
		add(lblUsuario);
		add(txtUsuario);
		add(lblSenha);
		add(txtSenha);
		add(btnLogar);
		setLayout(layout);
		btnLogar.addActionListener(this);
		setSize(800, 600);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String usuario = "senai";
		String senha = "senai123";
		
		String strPass = new String (txtSenha.getPassword()).trim();
		
		if(txtUsuario.getText().equals(usuario) && strPass.equals(senha)) {
			JOptionPane.showMessageDialog(null, "Usuário Logado!");
		}else {
			JOptionPane.showMessageDialog(null,	"Usuário Inválido!");
		}

	}

}
