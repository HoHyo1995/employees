package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import db.DBHelper;
import java.util.*
;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;public class SalariesDao {
	//생성자생성
	public SalariesDao() {
		
	}
	// salaries의 통계를 구하는 메소드
	// Map<>안에는 기본타입이 올 수 없음 그래서 long 대신 Long을 사용
	public Map<String, Long> selectSalariesStatistics() {
		// Map변수 생성
		Map<String, Long> map = new HashMap<String, Long>();
		// mariadb 로딩에 사용할 변수 선언및초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// 쿼리문을 String 타입으로 선언한다.
		final String sql = "select count(salary), sum(salary), avg(salary), max(salary), min(salary), std(salary) from salaries";
		// 마리아DB에 값을 불러와서 Map에 저장한다
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				map.put("count", rs.getLong("count(salary)"));
				map.put("sum", rs.getLong("sum(salary)"));
				map.put("avg", rs.getLong("avg(salary)"));
				map.put("max", rs.getLong("max(salary)"));
				map.put("min", rs.getLong("min(salary)"));
				map.put("std", rs.getLong("std(salary)"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return map;
		
	}
	//  테이블의 행의 수 구하는 메소드
		public int selectSalariesCount() {
			int count = 0;
			final String sql = "select count(*) from salaries";
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			try {
				conn = DBHelper.getConnection();
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				if(rs.next()) {
					count = rs.getInt("count(*)");
					
				}
			// Exception 예외의 최상위 클래스
			}catch(Exception e) { // e라는 변수가  2개인 이유는 자바의 변수 생명주기는 {}
				e.printStackTrace();
			} finally {
				DBHelper.close(rs, stmt, conn);
			}
			return count;
		}
}
