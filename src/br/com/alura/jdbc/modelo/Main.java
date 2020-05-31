
package br.com.alura.jdbc.modelo;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    
    public static void main (String args[]) {
        
        try { // Bloco de captura de erros com try catch e retorno da conexão
		Connection conexao = ContaDao.conectar();
		 System.out.println("A Conexão com o Banco de Dados foi realizada com sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
		System.out.println("Não foi possível realizar a conexão com o Banco de Dados!");
		}
    }
    
}
