package pack_Controlle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pack_ConnectionBluePen.ConnectionDataBase;
import pack_Model.Produto;

public class ProdutoDAO {


	public void create(Produto p )
	{
		Connection conexão = ConnectionDataBase.getConnection();
		PreparedStatement comandoSQL = null;
		
		try {
			comandoSQL = conexão.prepareStatement("INSERT INTO Produto VALUES(?,?,?,?,?,?,?)");
			comandoSQL.setString(1,p.getNome());
			comandoSQL.setString(2,p.getCódigo());
			comandoSQL.setString(3,p.getEstoque());
			comandoSQL.setString(4,p.getPreco());
			comandoSQL.setString(5,p.getTipo_Unit());
			comandoSQL.setString(6,p.getDataFabr());
			comandoSQL.setString(7,p.getDataValid());
			
			comandoSQL.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Executado independente que o try catch for acionado ou não
		}finally {
			ConnectionDataBase.closeConnection(conexão, comandoSQL);
		}
	}
     //ResultSet retorna a informação do Banco de Dados(necessario quando se utiliza um select
	public ArrayList<Produto> read()
	{
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList <Produto> produto = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT*FROM Produto ");
			rs = stmt.executeQuery();
			//percorre a tabela
			while(rs.next())
			{
				Produto p = new Produto();
				p.setId_produto(rs.getString(1));
				p.setNome(rs.getString(2));
				p.setCódigo(rs.getString(3));
				p.setEstoque(rs.getString(4));
				p.setPreco(rs.getString(5));
				p.setTipo_Unit(rs.getString(6));		//coloca as informações dentro do array cliente
				p.setDataFabr(rs.getString(7));
				p.setDataValid(rs.getString(8));
				produto.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionDataBase.closeConnection(con, stmt, rs);
		}
		
		return produto;
	}
	public void update(Produto p )
	{
		Connection conexão = ConnectionDataBase.getConnection();
		PreparedStatement comandoSQL = null;
		
		try {
			comandoSQL = conexão.prepareStatement("UPDATE Produto SET Nome = ?,Codigo = ?, Estoque = ?, Preco = ?, Tipo_unitario = ?, Data_fabr = ?, Data_valid = ? WHERE Codigo = ?");
			comandoSQL.setString(1,p.getNome());
			comandoSQL.setString(2,p.getCódigo());
			comandoSQL.setString(3,p.getEstoque());
			comandoSQL.setString(4,p.getPreco());
			comandoSQL.setString(5,p.getTipo_Unit());
			comandoSQL.setString(6,p.getDataFabr());
			comandoSQL.setString(7,p.getDataValid());
			
			comandoSQL.setString(8,p.getCódigo());
			
			comandoSQL.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Executado independente que o try catch for acionado ou não
		}finally {
			ConnectionDataBase.closeConnection(conexão, comandoSQL);
		}
	}
	
	public void delete(String codigo)
	{
		Connection conexão = ConnectionDataBase.getConnection();
		PreparedStatement comandoSQL = null;
		
		try {
			comandoSQL = conexão.prepareStatement("DELETE FROM Produto  WHERE Codigo = ?");
			comandoSQL.setString(1, codigo);
			comandoSQL.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("ERRO ao apagar! Produto possui registro de compra!!!",e);
		}finally {
			ConnectionDataBase.closeConnection(conexão, comandoSQL);
		}
		
		
	}
	
	public ArrayList<Produto> search(String search)
	{
		search = "%"+search+"%";
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList <Produto> produto = new ArrayList<>();
		
		try {//like significa "se parece com" ?
			stmt = con.prepareStatement("SELECT*FROM Produto WHERE Nome like ? OR Codigo like ? ");
			stmt.setString(1, search);
			stmt.setString(2, search);
			rs = stmt.executeQuery();
			//percorre a tabela
			while(rs.next())
			{
				Produto p = new Produto();
				p.setId_produto(rs.getString(1));
				p.setNome(rs.getString(2));
				p.setCódigo(rs.getString(3));
				p.setEstoque(rs.getString(4));
				p.setPreco(rs.getString(5));
				p.setTipo_Unit(rs.getString(6));		//coloca as informações dentro do array cliente
				p.setDataFabr(rs.getString(7));
				p.setDataValid(rs.getString(8));
				produto.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionDataBase.closeConnection(con, stmt, rs);
		}
		
		return produto;
	}
	
}
