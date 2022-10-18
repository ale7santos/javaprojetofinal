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
import javax.swing.JTextField;

import DAO.TipoAeronaveDAO;
import br.com.voearlines.model.ModeloTipoAeronave;

public class TipoAeronaveTela extends JFrame implements ActionListener {

	JButton btnRegistrar;
	JTextField txtdescricao;
	JLabel lblDescricao;
	JPanel contentPane;

	public TipoAeronaveTela() {

		setTitle("Tipos de aeronave");
		setResizable(false);
		setSize(550, 190);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		contentPane = new JPanel();

		JLabel imagem = new JLabel();
		Icon fundo = new ImageIcon("aviao.jpg");
		imagem.setIcon(fundo);
		add(imagem);

		lblDescricao = new JLabel("Descrição");
		lblDescricao.setFont(new Font("Ubuntu", Font.BOLD, 20));
		lblDescricao.setForeground(SystemColor.white);
		lblDescricao.setBounds(155, 51, 150, 20);
		contentPane.add(lblDescricao);
		imagem.add(lblDescricao);

		txtdescricao = new JTextField(100);
		txtdescricao.setFont(new Font("Ubuntu", Font.BOLD, 20));
		txtdescricao.setForeground(SystemColor.desktop);
		txtdescricao.setBounds(312, 52, 180, 22);
		contentPane.add(txtdescricao);
		imagem.add(txtdescricao);
		txtdescricao.setColumns(10);

		// Botão registrar
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(330, 100, 120, 30);
		btnRegistrar.addActionListener(this);
		contentPane.add(btnRegistrar);
		imagem.add(btnRegistrar);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TipoAeronaveDAO dao = new TipoAeronaveDAO();
		ModeloTipoAeronave modelo = new ModeloTipoAeronave();

		if (e.getSource() == btnRegistrar) {
			if (txtdescricao.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "É obrigatório preencher os campos");
			} else {
				System.out.println("Botao clicado");
				modelo.setDescricao(txtdescricao.getText());
				dao.cadastraTipoAeronave(modelo);
				JOptionPane.showMessageDialog(null,
						"A descrição do avião foi cadastrado com sucesso no sistema VoeArlines");
				this.dispose();
			}
		} else {

		}

	}

}
