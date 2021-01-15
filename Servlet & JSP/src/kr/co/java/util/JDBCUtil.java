package kr.co.java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {

	public static Connection getConnection() {
		
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String pw = "TIGER";
		
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,pw);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("JDBC Driver 확인");
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
		}
		
		return con;
	}
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		
		try {
			
			if(con != null)
				con.close();
			if(ps != null)
				ps.close();
			if(rs != null)
				rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
