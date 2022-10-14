package br.com.voeairlines.javaprojetofinal;
import java.sql.SQLException;

import javax.swing.JFrame;

public class Principal {

	public static void main(String[] args) throws SQLException {
		System.out.println("Teste Java");
		Login l = new Login();
		l.setVisible(true);
		l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	

}

