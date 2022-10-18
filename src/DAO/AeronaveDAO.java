package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.voearlines.model.ModeloAeronave;

public class AeronaveDAO {
	public void cadastraTipoAeronave(ModeloAeronave modeloaero) {

		Connection con = ConnectionFactory.getConnection();
		String sql = "INSERT INTO aeronave(id, idTipo, fabricante, modelo, codigo) VALUES(?, ?, ?, ?, ?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, modeloaero.getId());
			preparador.setInt(2, modeloaero.getIdtipo());
			preparador.setString(3, modeloaero.getFabricante());
			preparador.setString(4, modeloaero.getModelo());
			preparador.setString(5, modeloaero.getCodigo());

			preparador.execute();
			preparador.close();

			System.out.println("Aeronave Cadastrada com sucesso");

		} catch (SQLException e) {
			System.out.println("Não foi possível salvar os dados" + e.getMessage());

		}

	}

}
