package br.com.voeairlines.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.UsuarioDAO;
import br.com.voearlines.model.Usuario;

public class TelaNovoUsuario extends JFrame implements ActionListener {

	JButton btnCadastrar;
	JButton btnLimpar;
	JTextField txtUsuario;
	JPasswordField pwfSenha;
	JLabel lblUsuario;
	JLabel lblSenha;

	public TelaNovoUsuario() {
		setTitle("Cadastro de Login");
		setSize(500, 110);
		
		getContentPane().setLayout(new GridLayout(3, 2));
		setLocationRelativeTo(null);
		setResizable(false);

		btnCadastrar = new JButton("Cadastrar");
		btnLimpar = new JButton("Limpar");
		txtUsuario = new JTextField(10);

		pwfSenha = new JPasswordField(10);
		lblUsuario = new JLabel("Usuário");
		lblSenha = new JLabel("Senha");
		
		getContentPane().add(lblUsuario);
		getContentPane().add(txtUsuario);
		getContentPane().add(lblSenha);
		getContentPane().add(pwfSenha);
		getContentPane().add(btnCadastrar);
		getContentPane().add(btnLimpar);
		btnCadastrar.addActionListener(this);
		btnLimpar.addActionListener(this);

	}

	public void limparCampos() {
		txtUsuario.setText("");
		pwfSenha.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = new Usuario();

		if (e.getSource() == btnCadastrar) {
			if (txtUsuario.getText().trim().isEmpty() || pwfSenha.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "É obrigatório preencher todos os campos");
			} else {
				System.out.println("Botao clicado");
				usuario.setLogin(txtUsuario.getText());
				usuario.setSenha(pwfSenha.getText());
				dao.cadastra(usuario);
				JOptionPane.showMessageDialog(null, "Parabéns você foi cadastrado com sucesso no sistema VoeArlines");
				this.dispose();
			}
		} else {
			limparCampos();
		}

	}

}
