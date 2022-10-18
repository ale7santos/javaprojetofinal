package br.com.voeairlines.view;

import DAO.ConnectionFactory;

public class Principal {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		TelaLoginView tela = new TelaLoginView();
		ConnectionFactory.getConnection();
		System.out.println("DEU CERTO A CONEXÃO MEU AMIGO. DEU CERTO");
		tela.setVisible(true);
	}

}