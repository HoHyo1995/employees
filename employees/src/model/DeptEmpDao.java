package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Departments;

public class DeptEmpDao {
	//생성자 생성
	public DeptEmpDao() {
		
	}
	// 사원별로 해당 부서를 나타내는 테이블의 행의 수 구하는 메소드
				public int selectDeptEmpCount() {
					int count = 0;
					final String sql = "select count(*) from dept_emp";
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
