package db;
import java.sql.*;
public class DBHelper {
	// 마리아DB 사용을 할때 중복된 부분을 메소드화 함
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "java1234");
		//Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/wewe1418", "wewe1418", "tjqj4580!");
		return conn;
	}
	
	// close메소드
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn ) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
