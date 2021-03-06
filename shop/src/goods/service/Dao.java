package goods.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class Dao {
	
static Connection conn;
	
	private static final String driver;
	private static final String url;
	private static final String user;
	private static final String pw;
	static {
			driver = "com.mysql.jdbc.Driver"; 
			url = "jdbc:mysql://127.0.0.1:3306/watch?useUnicode=true&characterEncoding=euckr";
			user = "root";
			pw = "java0000";
			}
	
	public static Connection getConnection() {
		try {	
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pw);
			System.out.println("				db연결");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// PreparedStaatement 객체 1개일경우 종료
	public static void close(ResultSet rs,PreparedStatement pstmt,Connection conn){
		System.out.println("				객체사용 종료");
		if (rs != null) try { rs.close(); } catch(SQLException ex) {}
		if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}
	
	// PreparedStaatement 객체 2개일경우 종료
	public static void close(ResultSet rs,PreparedStatement pstmt1,PreparedStatement pstmt2,Connection conn){
		System.out.println("				객체사용 종료");
		if (rs != null) try { rs.close(); } catch(SQLException ex) {}
		if (pstmt1 != null) try { pstmt1.close(); } catch(SQLException ex) {}
		if (pstmt2 != null) try { pstmt2.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}
	// PreparedStaatement 객체 3개일경우 종료
	public static void close(ResultSet rs,PreparedStatement pstmt1,PreparedStatement pstmt2,PreparedStatement pstmt3,Connection conn){
		System.out.println("				객체사용 종료");
		if (rs != null) try { rs.close(); } catch(SQLException ex) {}
		if (pstmt1 != null) try { pstmt1.close(); } catch(SQLException ex) {}
		if (pstmt2 != null) try { pstmt2.close(); } catch(SQLException ex) {}
		if (pstmt2 != null) try { pstmt3.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}
}