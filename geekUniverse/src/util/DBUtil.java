package util;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
	
	public static void fechar(Connection connection){
		if(connection != null){
			try{
				connection.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
}