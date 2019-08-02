package com.danyllopenna.factory;
import java.sql.*;

public class conexao {
	
	public static String CAMINHO = "jdbc:postgresql://localhost:5432/acaibob";
	public static String USUARIO = "postgres";
	public static String SENHA = "shevchenko";
	public static Connection conectar = null;
	
	public static Connection conectando() {
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
			conectar = DriverManager.getConnection(CAMINHO, USUARIO, SENHA);
			System.out.println("conectado com sucesso");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conectar;
		
	}

	public static void main(String[] args) {
	//	Connection conecte = conexao.conectando();
	}

}
