package br.com.voeairlines.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaAviaoView extends JFrame {

	public TelaAviaoView() {

		setTitle("VoeArlines");
		setResizable(false);
		setSize(820, 420);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());

		JLabel imagem = new JLabel();
		Icon fundo = new ImageIcon("aviao.jpg");
		imagem.setIcon(fundo);
		add(imagem);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu cadAeronaves = new JMenu("Cadastro de Aeronaves");
		JMenu sobre = new JMenu("Sobre");
		menuBar.add(cadAeronaves);
		menuBar.add(sobre);

		JMenuItem ca = new JMenuItem("Cadastrar Aeronave");
		JMenuItem cadtipo = new JMenuItem("Cadastrar Tipo de Aeronave");
		JMenuItem sistema = new JMenuItem("Sistema");

		cadAeronaves.add(ca);
		cadAeronaves.add(cadtipo);
		sobre.add(sistema);

		ca.addActionListener(new ActionListener() {
			TelaCadastroAvioesView telacadastro = new TelaCadastroAvioesView();

			public void actionPerformed(ActionEvent e) {
				telacadastro.setVisible(true);
			}
		});

		cadtipo.addActionListener(new ActionListener() {
			TipoAeronaveTela tela = new TipoAeronaveTela();

			public void actionPerformed(ActionEvent e) {
				tela.setVisible(true);
			}
		});
	}

}
