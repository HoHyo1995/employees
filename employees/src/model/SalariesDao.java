package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SalariesDao {
	//생성자생성
	public SalariesDao() {
		
	}
	//  테이블의 행의 수 구하는 메소드
		public int selectSalariesCount() {
			int count = 0;
			final String sql = "select count(*) from salaries";
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employees", "root", "java1234");
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				if(rs.next()) {
					count = rs.getInt("count(*)");
					
				}
			// Exception 예외의 최상위 클래스
			}catch(Exception e) { // e라는 변수가  2개인 이유는 자바의 변수 생명주기는 {}
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					stmt.close();
					conn.close();
				}catch(Exception e) {
					// 예외가 나면 콘솔창에 출력을 하는 메소드
					e.printStackTrace();
				}
			}
			return count;
		}
}
