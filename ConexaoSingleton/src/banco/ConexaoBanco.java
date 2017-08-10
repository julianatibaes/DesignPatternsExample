package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
	
	private Connection conexao;
	
	/*
	 * SQL Server
	 * com.microsoft.sqlserver.jdbc.SQLServerDriver
	 */
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	/*
	 * SQL Server
	 * jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]
	 * Exemplo
	 * - jdbc:sqlserver://localhost; databaseName=TestDB; user=UserName;
	 * password=Password;
	 * - jdbc:sqlserver://localhost; databaseName=TestDB; integratedSecurity=true;
	 */
	// caminho do banco de dados até o nome do banco de dados (db_estudo)
	private final String DATABASE_URL = "jdbc:mysql://localhost:3306/db_estudo";
	private final String USERNAME = "root";
	private final String PASSWORD = "admin";
	
	private static ConexaoBanco instancia;

	
	private ConexaoBanco() {
		String msg = "";
		try {
			// qual que é o drive que estamos utilizando
			Class.forName(JDBC_DRIVER);

			// Conecta com o banco de dados
			conexao = DriverManager.getConnection(DATABASE_URL, 	
					USERNAME, PASSWORD);
			/*
			 * Caso a senha já esteja no caminho do banco (exemplo do SQL Server)
			 * conexao = DriverManager.getConnection(DATABASE_URL);
			 */
			conexao.setAutoCommit(false);
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			conexao = null;
			msg = "Driver não carregado";
		}catch(SQLException e) {
			e.printStackTrace();
			conexao = null;
			msg = "Não foi possível conectar com o banco de dados.";
		}finally {
			if (msg != null) {
				System.err.println("\n " + msg);
			}
		}
		
	}
	
	public static synchronized ConexaoBanco getInstance() {
		if(instancia == null)
			instancia = new ConexaoBanco();
		return instancia;
	}
	
	public void conectar() {
		System.out.println("Conectei com o banco! UHU!");
	}
	
	public void desconectar() {
		try {
			conexao.close();
			System.out.println("Desconectei com o banco!\n Até mais!");
		} catch (SQLException e) {
			System.err.println("Conexão aberta, exceção: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
}
