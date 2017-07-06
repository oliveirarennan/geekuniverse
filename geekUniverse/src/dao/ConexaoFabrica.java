package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFabrica {
	
	private static ConexaoFabrica instance = new ConexaoFabrica();
	public static final String URL = "jdbc:mysql://localhost:3306/lojavirtual";
	public static final String USER = "root";
	public static final String PASSWORD = "";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
		
	private ConexaoFabrica(){
		try{
			Class.forName(DRIVER_CLASS);
			} catch(ClassNotFoundException e){
				e.printStackTrace();
			}
	}
	
	private Connection createConnection(){
		Connection connection = null;
		
		try{
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch(SQLException e){
			System.out.println("Sem conexão com o banco de dados");
		}catch (Exception e) {
			e.printStackTrace();
		} 
		
		return connection;
	}
	
	public static Connection getConnection(){
		return instance.createConnection();
	}
}