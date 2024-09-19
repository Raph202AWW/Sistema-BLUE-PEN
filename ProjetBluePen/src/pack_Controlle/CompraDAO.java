package pack_Controlle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pack_ConnectionBluePen.ConnectionDataBase;
import pack_Model.Compra;

public class CompraDAO {

	public void create(Compra cp) {
		Connection conexão = ConnectionDataBase.getConnection();
		PreparedStatement comandoSQL = null;

		try {
			comandoSQL = conexão.prepareStatement("INSERT INTO Compra VALUES(?,?,?,?,?)");
			comandoSQL.setString(1, cp.getId_cliente());
			comandoSQL.setString(2, cp.getId_vendedor());
			comandoSQL.setString(3, cp.getId_produto());
			comandoSQL.setString(4, cp.getQuantidade());
			comandoSQL.setString(5, cp.getPreco_Total());

			comandoSQL.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// Executado independente que o try catch for acionado ou não
		} finally {
			ConnectionDataBase.closeConnection(conexão, comandoSQL);
		}
	}

	// ResultSet retorna a informação do Banco de Dados(necessario quando se utiliza
	// um select
	public ArrayList<Compra> read() {
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Compra> compra = new ArrayList<>();

		try {
			stmt = con.prepareStatement("select Id_compra,cl.nome, v.Nome ,p.nome,cp.quantidade, cp.preco_total from Compra cp\r\n"
					+ "INNER JOIN Cliente cl ON cl.Id_cliente = cp.Id_cliente\r\n"
					+ "INNER JOIN Produto p ON cp.Id_produto = p.Id_produto\r\n"
					+ "INNER JOIN Vendedor v ON cp.Id_vendedor = v.Id_vendedor");
			
			rs = stmt.executeQuery();
			// percorre a tabela
			while (rs.next()) {
				Compra cp = new Compra();
				cp.setId_compra(rs.getString(1));
				cp.setId_cliente(rs.getString(2));
				cp.setId_vendedor(rs.getString(3));
				cp.setId_produto(rs.getString(4));
				cp.setQuantidade(rs.getString(5));
				cp.setPreco_Total(rs.getString(6));
				// coloca as informações dentro do array cliente
				compra.add(cp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDataBase.closeConnection(con, stmt, rs);
		}

		return compra;
	}

	public void update(Compra cp) {
		Connection conexão = ConnectionDataBase.getConnection();
		PreparedStatement comandoSQL = null;

		try {
			comandoSQL = conexão.prepareStatement(
					"UPDATE Compra SET Id_cliente = ?, Id_vendedor = ?, Id_produto = ?, Quantidade = ?, Preco_Total = ? WHERE Id_compra = ?");
			comandoSQL.setString(1, cp.getId_cliente());
			comandoSQL.setString(2, cp.getId_vendedor());
			comandoSQL.setString(3, cp.getId_produto());
			comandoSQL.setString(4, cp.getQuantidade());
			comandoSQL.setString(5, cp.getPreco_Total());

			comandoSQL.setString(6, cp.getId_compra());

			comandoSQL.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// Executado independente que o try catch for acionado ou não
		} finally {
			ConnectionDataBase.closeConnection(conexão, comandoSQL);
		}
	}

	public void delete(String Idcompra) {
		Connection conexão = ConnectionDataBase.getConnection();
		PreparedStatement comandoSQL = null;

		try {
			comandoSQL = conexão.prepareStatement("DELETE FROM Compra  WHERE Id_compra  = ?");
			comandoSQL.setString(1, Idcompra);
			comandoSQL.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("ERRO! Uma COMPRA NÃO PODE SER APAGADA!!!", e);
		} finally {
			ConnectionDataBase.closeConnection(conexão, comandoSQL);
		}

	}

	public ArrayList<Compra> search(String search) {
		search = "%"+search+"%";
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Compra> compra = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT*FROM  Vw_RelatorioCompra WHERE Id_compra like ? OR Vendedor like ?  OR Cliente like ?  ");
			stmt.setString(1, search);
			stmt.setString(2, search);
			stmt.setString(3, search);
			rs = stmt.executeQuery();
			// percorre a tabela
			while (rs.next()) {
				Compra cp = new Compra();
				cp.setId_compra(rs.getString(1));
				cp.setId_cliente(rs.getString(2));
				cp.setId_vendedor(rs.getString(3));
				cp.setId_produto(rs.getString(4));
				cp.setQuantidade(rs.getString(5));
				cp.setPreco_Total(rs.getString(6));
				// coloca as informações dentro do array cliente
				compra.add(cp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDataBase.closeConnection(con, stmt, rs);
		}

		return compra;
	}
}
