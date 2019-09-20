package model;
import java.util.*;
import vo.*;
import java.sql.*;
public class departmentsDao {
	// 생성자 생성
	public departmentsDao() {
		
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
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employees", "root", "java1234");
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
			try {
				rs.close();
				stmt.close();
				conn.close();
			}
			catch(Exception e) {
				// 예외발생시 콘솔창에 출력해주는 메소드
				e.printStackTrace();
			}
		}
		
		return list;
	}

}
