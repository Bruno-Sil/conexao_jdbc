package br.com.alura.jdbc.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContaDao {
       
	private Connection cnn;
        private static final String USUARIO = "root"; //Credenciais de conexão
	private static final String SENHA = "";
	private static final String URL = "jdbc:mysql://localhost:3306/alura_jdbc";

        
        public static Connection conectar() throws SQLException { // Método de conexão via paraâmetros
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}
        
	public ContaDao() {
		try {
			this.cnn = DriverManager.getConnection("jdbc:mysql://localhost/alura_jdbc", "root", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
                        
		}
	}

	public void adiciona(Conta conta) { // Query SQL para inserção de dados no Banco
		try {
			String sql = "insert into conta(agencia, numero, titular) values (?,?,?)";
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setLong(1, conta.getAgencia());
			ps.setLong(2, conta.getNumero());
			ps.setString(3, conta.getTitular());
			
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void consultar(Conta conta) { // Query SQL para consulta de dados no Banco
		try {
			String sql = "select * from conta(agencia, numero, titular) values (?, ?, ?)";
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setLong(1, conta.getAgencia());
			ps.setLong(2, conta.getNumero());
			ps.setString(3, conta.getTitular());
			
			ps.execute(); // Execução da query
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
