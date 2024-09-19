package pack_ConnectionBluePen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDataBase {
// final para a variavel não mudar
	private final static String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final static String URL = "jdbc:sqlserver://localhost:56594;encrypt=false;databaseName=BluePen";
	private final static String User = "sa";
	private final static String password = "12345678";
	
	public static Connection getConnection()
	{
		try {
			Class.forName(Driver);
			System.out.println("Conexão Estabelecida!!!");
			return DriverManager.getConnection(URL, User, password);
		} catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Algo de ERRADO não está certo!!!", e);
		}
		
	}
	
	public static void closeConnection(Connection con)
	{
		try {
			if(con != null)
			con.close();
			System.out.println("Conexão Fechada!!!");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	//connection conecta com o banco e PreparedStatement transforma os comando do codigo para executar e enviar um comando SQL
	public static void closeConnection(Connection con , PreparedStatement stmt)
	{
		closeConnection(con);
		try {
			if(stmt != null)
			{
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//ResultSet recebe informação que sai do banco( retorno de informação )
	public static void closeConnection(Connection con ,PreparedStatement stmt ,ResultSet rs)
	{
		closeConnection(con,stmt);
		try {
			if(rs != null)
			{
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
















