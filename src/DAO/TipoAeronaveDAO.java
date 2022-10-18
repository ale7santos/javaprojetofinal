package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.voearlines.model.ModeloTipoAeronave;

public class TipoAeronaveDAO {

	public void cadastraTipoAeronave(ModeloTipoAeronave aeronave) {

		Connection con = ConnectionFactory.getConnection();
		String sql = "INSERT INTO tipoaeronave(descricao) VALUES(?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, aeronave.getDescricao());

			preparador.execute();
			preparador.close();

			System.out.println("Aeronave Cadastrada com sucesso");

		} catch (SQLException e) {
			System.out.println("Não foi possível salvar os dados" + e.getMessage());

		}

	}

}
