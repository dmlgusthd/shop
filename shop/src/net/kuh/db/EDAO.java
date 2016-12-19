package net.kuh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EDAO {
	private final String driverClassName = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://127.0.0.1:3306/watch?useUnicode=true&characterEncoding=euckr";
    private final String username = "root";
    private final String password = "java0000";
    Connection connection = null;
    PreparedStatement statement = null;


private Connection getConnection() {
    try {
        Class.forName(this.driverClassName);
        connection = DriverManager.getConnection(this.url, this.username, this.password);
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return connection;
	}

}