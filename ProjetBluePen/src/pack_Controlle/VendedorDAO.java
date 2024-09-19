package pack_Controlle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pack_ConnectionBluePen.ConnectionDataBase;
import pack_Model.Vendedor;

public class VendedorDAO {
	
	public void create(Vendedor v )
	{
		Connection conexão = ConnectionDataBase.getConnection();
		PreparedStatement comandoSQL = null;
		
		try {
			comandoSQL = conexão.prepareStatement("INSERT INTO Vendedor VALUES(?,?,?,?,?,?,?,?)");
			comandoSQL.setString(1,v.getNome());
			comandoSQL.setString(2,v.getCPF());
			comandoSQL.setString(3,v.getEmail());
			comandoSQL.setString(4,v.getTelefone());
			comandoSQL.setString(5,v.getDataNasc());
			comandoSQL.setString(6,v.getDataContrat());
			comandoSQL.setString(7,v.getEndereco());
			comandoSQL.setString(8,v.getPassword());
			
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
	public ArrayList<Vendedor> read()
	{
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList <Vendedor> vendedor = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT*FROM Vendedor");
			rs = stmt.executeQuery();
			//percorre a tabela
			while(rs.next())
			{
				Vendedor v = new Vendedor();
				v.setId_vendedor(rs.getString(1));
				v.setNome(rs.getString(2));
				v.setCPF(rs.getString(3));
				v.setEmail(rs.getString(4));
				v.setTelefone(rs.getString(5));
				v.setDataNasc(rs.getString(6));
				v.setDataContrat(rs.getString(7));
				v.setTotal_vend(rs.getString(8));
				v.setEndereco(rs.getString(9));
				//coloca as informações dentro do array cliente
				vendedor.add(v);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionDataBase.closeConnection(con, stmt, rs);
		}
		
		return vendedor;
	}
	public void update(Vendedor v )
	{
		Connection conexão = ConnectionDataBase.getConnection();
		PreparedStatement comandoSQL = null;
		
		try {
			comandoSQL = conexão.prepareStatement("UPDATE Vendedor SET Nome = ?, CPF = ?, Email = ?, Telefone = ?, Data_nascimento = ?,Data_contratacao = ?, Endereco = ? WHERE CPF = ?");
			comandoSQL.setString(1,v.getNome());
			comandoSQL.setString(2,v.getCPF());
			comandoSQL.setString(3,v.getEmail());
			comandoSQL.setString(4,v.getTelefone());
			comandoSQL.setString(5,v.getDataNasc());
			comandoSQL.setString(6,v.getDataContrat());
			comandoSQL.setString(7,v.getEndereco());
			
			comandoSQL.setString(8,v.getCPF());
			
			comandoSQL.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Executado independente que o try catch for acionado ou não
		}finally {
			ConnectionDataBase.closeConnection(conexão, comandoSQL);
		}
	}

	
	public void delete(String cpf)
	{
		Connection conexão = ConnectionDataBase.getConnection();
		PreparedStatement comandoSQL = null;
		
		try {
			comandoSQL = conexão.prepareStatement("DELETE * FROM Vendedor  WHERE CPF = ?");
			comandoSQL.setString(1, cpf);
			comandoSQL.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionDataBase.closeConnection(conexão, comandoSQL);
		}
		
	}
	public Vendedor autenticarUser(String user, String password)
	{
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		Vendedor vendedor = new Vendedor();
		
		try {
			stmt = con.prepareStatement("SELECT*FROM Vendedor WHERE Password = ? AND CPF =?");
			stmt.setString(1, password);
			stmt.setString(2, user);
			rs = stmt.executeQuery();
			//percorre a tabela
			while(rs.next())
			{
				Vendedor v = new Vendedor();
				v.setId_vendedor(rs.getString(1));
				v.setNome(rs.getString(2));
				v.setCPF(rs.getString(3));
				v.setEmail(rs.getString(4));
				v.setTelefone(rs.getString(5));
				v.setDataNasc(rs.getString(6));
				v.setDataContrat(rs.getString(7));
				v.setTotal_vend(rs.getString(8));
				v.setEndereco(rs.getString(9));
				v.setPassword(rs.getString(10));
				//coloca as informações dentro do array cliente
				vendedor = v;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionDataBase.closeConnection(con, stmt, rs);
		}
		
		return vendedor;
	}
	public ArrayList<Vendedor> search(String search)
	{
		search = "%"+search+"%";
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList <Vendedor> vendedor = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT*FROM Vendedor WHERE Nome like ? OR CPF like ? ");
			stmt.setString(1, search);
			stmt.setString(2, search);
			rs = stmt.executeQuery();
			//percorre a tabela
			while(rs.next())
			{
				Vendedor v = new Vendedor();
				v.setId_vendedor(rs.getString(1));
				v.setNome(rs.getString(2));
				v.setCPF(rs.getString(3));
				v.setEmail(rs.getString(4));
				v.setTelefone(rs.getString(5));
				v.setDataNasc(rs.getString(6));
				v.setDataContrat(rs.getString(7));
				v.setTotal_vend(rs.getString(8));
				v.setEndereco(rs.getString(9));
				//coloca as informações dentro do array cliente
				vendedor.add(v);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionDataBase.closeConnection(con, stmt, rs);
		}
		
		return vendedor;
	}
}
