package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {

	public static String status = "N�o conectado...";

	private static String serverName, database, url, username, password;

	private static Connection con = null;
	private static Statement state;

	//Instanciar a classe
	public ConnectionDB() {
		serverName = "localhost:3306";
		database = "tbl_20";
		url = "jdbc:mysql://" + serverName + "/" + database;
		username = "root";
		password = "1234";
	}

	//Conectar ao BD
	public static Statement getConexao() {

		try {

			con = DriverManager.getConnection(url, username, password);
			state = con.createStatement();

			if (con != null) {

				status = ("STATUS: Conectado com sucesso!");

			} else {

				status = ("STATUS: N�o foi possivel realizar a conex�o!");
				
			}
			
			return state;
		}

		catch (SQLException ex) {
			
			System.out.println("N�o foi possivel conectar ao Banco de Dados");
			
			return null;			
		}

	}
	
	//Mostrar se a Conex�o est� ativa ou n�o
	public static String statusConexao() {
		
		return status;		
	}
	
	//Fechar a conex�o com o BD
	public static boolean fecharConexao() {
		
		try {
		
			con.close();
			
			return true;			
		}
		
		catch (SQLException ex) {
			
			return false;			
		}
		
	}

}
