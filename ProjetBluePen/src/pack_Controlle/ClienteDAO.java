package pack_Controlle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pack_ConnectionBluePen.ConnectionDataBase;
import pack_Model.Cliente;

public class ClienteDAO {
	
	public void create(Cliente c )
	{
		Connection conexão = ConnectionDataBase.getConnection();
		PreparedStatement comandoSQL = null;
		
		try {
			comandoSQL = conexão.prepareStatement("INSERT INTO Cliente VALUES(?,?,?,?,?,?,?,?)");
			comandoSQL.setString(1,c.getNome());
			comandoSQL.setString(2,c.getCPF_CNPJ());
			comandoSQL.setString(3,c.getEmail());
			comandoSQL.setString(4,c.getTelefone());
			comandoSQL.setString(5,c.getDataNasc());
			comandoSQL.setString(6,c.getDataPriCom());
			comandoSQL.setString(7,c.getEndereco());
			comandoSQL.setString(8,c.getTipoJur());
			
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
	public ArrayList<Cliente> read()
	{
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList <Cliente> cliente = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT*FROM Cliente");
			rs = stmt.executeQuery();
			//percorre a tabela
			while(rs.next())
			{
				Cliente c = new Cliente();
				c.setId_cliente(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setCPF_CNPJ(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setTelefone(rs.getString(5));
				c.setDataNasc(rs.getString(6));
				c.setDataPriCom(rs.getString(7));
				c.setEndereco(rs.getString(8));
				c.setTipoJur(rs.getString(9));
				//coloca as informações dentro do array cliente
				cliente.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionDataBase.closeConnection(con, stmt, rs);
		}
		
		return cliente;
	}
	public void update(Cliente c )
	{
		Connection conexão = ConnectionDataBase.getConnection();
		PreparedStatement comandoSQL = null;
		
		try {
			comandoSQL = conexão.prepareStatement("UPDATE Cliente SET Nome = ?, CPF_CNPJ = ?, Email = ?, Telefone = ?, Data_nascimento = ?,Data_primeira_compr = ?, Endereco = ?, Tipo_juridico = ? WHERE CPF_CNPJ = ?");
			comandoSQL.setString(1,c.getNome());
			comandoSQL.setString(2,c.getCPF_CNPJ());
			comandoSQL.setString(3,c.getEmail());
			comandoSQL.setString(4,c.getTelefone());
			comandoSQL.setString(5,c.getDataNasc());
			comandoSQL.setString(6,c.getDataPriCom());
			comandoSQL.setString(7,c.getEndereco());
			comandoSQL.setString(8,c.getTipoJur());
			
			comandoSQL.setString(9,c.getCPF_CNPJ());
			
			comandoSQL.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Executado independente que o try catch for acionado ou não
		}finally {
			ConnectionDataBase.closeConnection(conexão, comandoSQL);
		}
	}
	
	public void delete(String cpf_cnpj)
	{
		Connection conexão = ConnectionDataBase.getConnection();
		PreparedStatement comandoSQL = null;
		
		try {
			comandoSQL = conexão.prepareStatement("DELETE FROM Cliente  WHERE CPF_CNPJ = ?");
			comandoSQL.setString(1, cpf_cnpj);
			comandoSQL.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("ERRO ao apagar! Cliente possui registro de compra!!!",e);
		}finally {
			ConnectionDataBase.closeConnection(conexão, comandoSQL);
		}
		
		
	}
	public ArrayList<Cliente> search(String search)
	{
		search = "%"+search+"%";
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList <Cliente> cliente = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT*FROM Cliente WHERE Nome like ? OR CPF_CNPJ like ?");
			stmt.setString(1, search);
			stmt.setString(2, search);
			rs = stmt.executeQuery();
			//percorre a tabela
			while(rs.next())
			{
				Cliente c = new Cliente();
				c.setId_cliente(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setCPF_CNPJ(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setTelefone(rs.getString(5));
				c.setDataNasc(rs.getString(6));
				c.setDataPriCom(rs.getString(7));
				c.setEndereco(rs.getString(8));
				c.setTipoJur(rs.getString(9));
				//coloca as informações dentro do array cliente
				cliente.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionDataBase.closeConnection(con, stmt, rs);
		}
		
		return cliente;
	}
	
}
