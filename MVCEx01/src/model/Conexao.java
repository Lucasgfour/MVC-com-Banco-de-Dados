package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
private Connection conexao;
	
	// Abri Conex�o
	public Conexao() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://localhost/mvc";
			conexao = DriverManager.getConnection(url, "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Fecha Conex�o
	public void desconecta() {
		try {
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Obtem a Conex�o
	public Connection getConexao() {
		return this.conexao;
	}
}
