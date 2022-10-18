package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.voearlines.model.Usuario;

public class UsuarioDAO {

	public boolean checkLogin(String login, String senha) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		boolean check = false;

		try {

			stmt = con.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ?");
			stmt.setString(1, login);
			stmt.setString(2, senha);

			rs = stmt.executeQuery();

			if (rs.next()) {

				check = true;
			}

		} catch (SQLException ex) {
			Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return check;

	}

	public void cadastra(Usuario usuario) {

		Connection con = ConnectionFactory.getConnection();
		String sql = "INSERT INTO usuario(login,senha) VALUES(?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getLogin());
			preparador.setString(2, usuario.getSenha());

			preparador.execute();
			preparador.close();

			System.out.println("Dados salvos com sucesso");

		} catch (SQLException e) {
			System.out.println("Não foi possível salvar os dados" + e.getMessage());

		}

	}

}