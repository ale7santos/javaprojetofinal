package br.com.voeairlines.view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.UsuarioDAO;

public class TelaLoginView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField usuario;
	private JPasswordField senha;
	private JLabel user, pass;
	private JButton btnLogar;
	private JButton btnLimpar;

	public TelaLoginView() {

		setTitle("VoeArlines");
		setResizable(false);
		setSize(820, 420);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		contentPane = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel imagem = new JLabel();
		Icon fundo = new ImageIcon("aviao.jpg");
		imagem.setIcon(fundo);
		add(imagem);

		user = new JLabel("Usuário:");
		user.setFont(new Font("Ubuntu", Font.BOLD, 20));
		user.setForeground(SystemColor.white);
		user.setBounds(230, 51, 86, 20);
		contentPane.add(user);
		imagem.add(user);

		usuario = new JTextField(30);
		usuario.setFont(new Font("Ubuntu", Font.BOLD, 20));
		usuario.setForeground(SystemColor.desktop);
		usuario.setBounds(312, 52, 114, 19);
		contentPane.add(usuario);
		imagem.add(usuario);
		usuario.setColumns(10);

		pass = new JLabel("Senha:");
		pass.setFont(new Font("Ubuntu", Font.BOLD, 20));
		pass.setForeground(SystemColor.white);
		pass.setBounds(230, 100, 86, 20);
		contentPane.add(pass);
		imagem.add(pass);

		senha = new JPasswordField(30);
		senha.setFont(new Font("Ubuntu", Font.BOLD, 20));
		senha.setForeground(SystemColor.desktop);
		senha.setBounds(312, 100, 114, 19);
		contentPane.add(senha);
		imagem.add(senha);
		senha.setColumns(10);

		btnLogar = new JButton("Logar");
		btnLimpar = new JButton("Limpar");
		contentPane.add(btnLimpar);
		add(btnLimpar);
		imagem.add(btnLimpar);

		btnLogar.setFont(new Font("Ubuntu", Font.BOLD, 15));
		btnLogar.setForeground(SystemColor.desktop);
		btnLogar.setBounds(230, 150, 100, 20);
		contentPane.add(btnLogar);
		imagem.add(btnLogar);
		btnLogar.addActionListener(this);

		btnLimpar.setFont(new Font("Ubuntu", Font.BOLD, 15));
		btnLimpar.setForeground(SystemColor.desktop);
		btnLimpar.setBounds(360, 150, 100, 20);
		contentPane.add(btnLimpar);
		imagem.add(btnLimpar);
		btnLimpar.addActionListener(this);

	}

	public void limparCampos() {
		usuario.setText("");
		senha.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		UsuarioDAO dao = new UsuarioDAO();
		TelaAviaoView aviao = new TelaAviaoView();
		TelaNovoUsuario novousuario = new TelaNovoUsuario();

		if (e.getSource() == btnLogar) {
			if (usuario.getText().trim().isEmpty() || senha.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Por Favor preencha todos os campos");
			}
			if (dao.checkLogin(usuario.getText(), senha.getText())) {
				JOptionPane.showMessageDialog(null, "Parabéns você foi logado com sucesso");
				int input = JOptionPane.showConfirmDialog(null, "Deseja Cadastrar um novo usuário?");
				System.out.println(input);
				if (input == 0) {
					novousuario.setVisible(true);
				}
				if (input == 1) {
					aviao.setVisible(true);
				}
				if (input == 2) {

				}

			} else {
				JOptionPane.showMessageDialog(null, "Nome e/ou senha invalidos...");
			}
		} else {
			limparCampos();
		}
	}
}
