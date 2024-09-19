package pack_Controlle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pack_ConnectionBluePen.ConnectionDataBase;
import pack_Model.Fornecedor;

public class FornecedorDAO {

	public void create(Fornecedor f )
	{
		Connection conexão = ConnectionDataBase.getConnection();
		PreparedStatement comandoSQL = null;
		
		try {
			comandoSQL = conexão.prepareStatement("INSERT INTO Fornecedor VALUES(?,?,?,?,?)");
			comandoSQL.setString(1,f.getNome());
			comandoSQL.setString(2,f.getCNPJ());
			comandoSQL.setString(3,f.getEmail());
			comandoSQL.setString(4,f.getTelefone());
			comandoSQL.setString(5,f.getEndereco());
			
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
	public ArrayList<Fornecedor> read()
	{
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList <Fornecedor> fornecedor = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT*FROM Fornecedor");
			rs = stmt.executeQuery();
			//percorre a tabela
			while(rs.next())
			{
				Fornecedor f = new Fornecedor();
				f.setId_fornecedor(rs.getString(1));
				f.setNome(rs.getString(2));
				f.setCNPJ(rs.getString(3));
				f.setEmail(rs.getString(4));
				f.setTelefone(rs.getString(5));
				f.setEndereco(rs.getString(6));
				//coloca as informações dentro do array cliente
				fornecedor.add(f);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionDataBase.closeConnection(con, stmt, rs);
		}
		
		return fornecedor;
	}
	public void update(Fornecedor f )
	{
		Connection conexão = ConnectionDataBase.getConnection();
		PreparedStatement comandoSQL = null;
		
		try {
			comandoSQL = conexão.prepareStatement("UPDATE Fornecedor SET Nome = ?, CNPJ = ?, Email = ?, Telefone = ?, Endereco = ? WHERE CNPJ = ?");
			comandoSQL.setString(1,f.getNome());
			comandoSQL.setString(2,f.getCNPJ());
			comandoSQL.setString(3,f.getEmail());
			comandoSQL.setString(4,f.getTelefone());
			comandoSQL.setString(5,f.getEndereco());
			
			comandoSQL.setString(6,f.getCNPJ());
			
			comandoSQL.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Executado independente que o try catch for acionado ou não
		}finally {
			ConnectionDataBase.closeConnection(conexão, comandoSQL);
		}
	}
	
	public void delete(String cnpj)
	{
		Connection conexão = ConnectionDataBase.getConnection();
		PreparedStatement comandoSQL = null;
		
		try {
			comandoSQL = conexão.prepareStatement("DELETE FROM Fornecedor  WHERE CNPJ = ?");
			comandoSQL.setString(1, cnpj);
			comandoSQL.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("ERRO ao apagar! Fornecedor possui registro !!!",e);
		}finally {
			ConnectionDataBase.closeConnection(conexão, comandoSQL);
		}
		
		
	}
	public ArrayList<Fornecedor> search(String search)
	{
		search = "%"+search+"%";
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList <Fornecedor> fornecedor = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT*FROM Fornecedor WHERE Nome like ? OR CNPJ like ?");
			stmt.setString(1, search);
			stmt.setString(2, search);
			rs = stmt.executeQuery();
			//percorre a tabela
			while(rs.next())
			{
				Fornecedor f = new Fornecedor();
				f.setId_fornecedor(rs.getString(1));
				f.setNome(rs.getString(2));
				f.setCNPJ(rs.getString(3));
				f.setEmail(rs.getString(4));
				f.setTelefone(rs.getString(5));
				f.setEndereco(rs.getString(6));
				//coloca as informações dentro do array cliente
				fornecedor.add(f);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionDataBase.closeConnection(con, stmt, rs);
		}
		
		return fornecedor;
	}
	
	public ObservableList<String> readNome()
	{
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ObservableList <String> fornecedor = FXCollections.observableArrayList();
		
		try {
			stmt = con.prepareStatement("SELECT Nome FROM Fornecedor");
			rs = stmt.executeQuery();
			//percorre a tabela
			while(rs.next())
			{
				String f = rs.getString(1);
				fornecedor.add(f);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionDataBase.closeConnection(con, stmt, rs);
		}
		
		return fornecedor;
	}
	
}
