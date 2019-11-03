package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;
import vo.Departments;
import vo.DeptEmp;
import vo.Employees;

public class DeptEmpDao {
	//생성자 생성
	public DeptEmpDao() {
		
	}
	// 사원 정보를 나타내는 메소드
	public List<DeptEmp> getDeptEmpList(int currentPage, int rowPerPage){
		// 넘어 온 인수를 확인한다
		System.out.println("현재페이지 : "+currentPage+" 페이지당 행의 수 : "+rowPerPage);
		// 시작값을 정한다
		int startRow = (currentPage-1)*rowPerPage;
		// 리턴받을 값을 변수로 선언한다
		List<DeptEmp> list = new ArrayList<DeptEmp>();
		// 쿼리문을 변수에 저장
		final String sql = "SELECT de.dept_no, d.dept_name, de.emp_no, e.first_name, e.last_name, de.to_date \r\n" + 
				"FROM dept_emp de INNER JOIN employees e INNER JOIN departments d\r\n" + 
				"ON de.emp_no = e.emp_no AND de.dept_no = d.dept_no\r\n" + 
				"LIMIT ?, ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, startRow);
			stmt.setInt(2, rowPerPage);
			rs = stmt.executeQuery();
			while(rs.next()) {
				DeptEmp deptEmp = new DeptEmp();
				deptEmp.setDepartments(new Departments());
				deptEmp.getDepartments().setDeptNo(rs.getString("de.dept_no"));
				deptEmp.getDepartments().setDeptName(rs.getString("d.dept_name"));
				deptEmp.setEmployees(new Employees());
				deptEmp.getEmployees().setEmpNo(rs.getInt("de.emp_no"));
				deptEmp.getEmployees().setFirstName(rs.getString("e.first_name"));
				deptEmp.getEmployees().setLastName("e.last_name");
				deptEmp.setToDate(rs.getString("de.to_date"));
				list.add(deptEmp);
			}
		// Exception 예외의 최상위 클래스
		}catch(Exception e) { // e라는 변수가  2개인 이유는 자바의 변수 생명주기는 {}
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	// 사원별로 해당 부서를 나타내는 테이블의 행의 수 구하는 메소드
				public int selectDeptEmpCount() {
					int count = 0;
					final String sql = "select count(*) from dept_emp";
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
