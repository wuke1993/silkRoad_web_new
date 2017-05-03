package org.silkroad.utility;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author: wuke 
 * @date  : 2016��11��25�� ����8:53:20
 * Title  : MySQLConn
 * Description : 
 */
public class MySQLConn {
	public static void main(String[] args) {
		MySQLConn.getConn();
	}
	
	public static Connection getConn() {
		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/silkroadresource_new?characterEncoding=utf8&useSSL=false";
		String username = "root";
		String password = "1234";
		try {
			/*url = "jdbc:mysql://personalize-mysql:3306/silkroad_personalize?characterEncoding=utf8&useSSL=false";
			username = "personalize";
			password = "P0$sW0rD$Sp";*/
		    
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
