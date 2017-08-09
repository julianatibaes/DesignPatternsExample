package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

	
	private static Connection connection;
	private static ConexaoBanco instancia;

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/db_estudo";
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "admin";

	
	private ConexaoBanco() {
		String msg = null;
	
		try {
			Class.forName(JDBC_DRIVER);

			// Conecta com o banco de dados
			connection = DriverManager.getConnection(DATABASE_URL, 	USERNAME, PASSWORD);
			connection.setAutoCommit(false);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			connection = null;
			msg = "Driver não carregado";
			
		} catch (SQLException e) {
			e.printStackTrace();
			connection = null;
			msg = "Conexão sem sucesso";
			
		} finally {
			if (msg != null) {
				System.err.println("\n " + msg);
			}
		}
	}
	
	public static synchronized ConexaoBanco getInstance(){
		if(instancia == null){
			instancia = new ConexaoBanco();
		}
		return instancia;
	}

	public void conectar(){
		System.out.println("Conectei");
	}

	public void desconectar(){
		try {
			connection.close();
			System.out.println("Desconectei");
		} catch (SQLException e) {
			System.out.println("Conexão aberta, exceção: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
