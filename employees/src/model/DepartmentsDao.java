package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import db.DBHelper;
import vo.Departments;

public class DepartmentsDao {
	//생성자 생성
	public DepartmentsDao() {
	 
 }
	// 부서별 사원수
		public List<Map<String, Object>>selectDepartmentsCountByDeptNo() {
			// 리턴값에 사용될 동적배열 생성
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			// 쿼리문 String타입으로 선언 부서번호,부서이름,재직자 수를 구해야함
			final String sql = "SELECT de.dept_no, d.dept_name, count(de.dept_no) FROM dept_emp de INNER JOIN departments d ON de.dept_no = d.dept_no where de.to_date = '9999-01-01' GROUP BY de.dept_no ORDER BY count(de.dept_no) DESC";
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			try {
				conn = DBHelper.getConnection();
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while(rs.next()) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("deptNo", rs.getString("de.dept_no"));
					map.put("deptName", rs.getString("d.dept_name"));
					map.put("cnt", rs.getInt("count(de.dept_no)"));
					list.add(map);
				}
			// Exception 예외의 최상위 클래스
			}catch(Exception e) { // e라는 변수가  2개인 이유는 자바의 변수 생명주기는 {}
				// 예외가 나면 콘솔창에 출력을 하는 메소드
				e.printStackTrace();
			} finally {
				DBHelper.close(rs, stmt, conn);
			}
			return list;
			
		}
	// index에 사용할 employeesDB의 부서 수를 구하는 메소드
		public int selectDepartmentsCount() {
			int count = 0;
			final String sql = "select count(*) from departments";
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
	
	// 부서들의 이름과 부서번호를 리스트로 출력하는 메소드
	public List<Departments> selectDepartmentsList() {
		// Departments타입을 여러개 받기 위해 List<>배열 생성한다.
		List<Departments> list = new ArrayList<Departments>();
		// 마리아 DB로딩에 필요한 변수들을 선언 및 초기화 시켜준다.
		Connection conn =null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// 부서들을 출력할 쿼리문을 작성한다.
		final String sql = "select dept_no, dept_name from departments";
		//예외처리문을 사용하여 실행시킨다
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Departments departments = new Departments();
				departments.setDeptNo(rs.getString("dept_no"));
				departments.setDeptName(rs.getString("dept_name"));
				list.add(departments);
			}
		} catch(Exception e) {
			// 예외발생시 콘솔창에 출력해주는 메소드
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		
		return list;
	}
}
