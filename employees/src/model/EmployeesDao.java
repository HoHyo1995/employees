package model;
import java.util.*;
import vo.*;
import java.sql.*;

public class EmployeesDao {
	// 생성자생성
	public EmployeesDao(){
		
	}
	// 전체 리스트를 출력하는 메소드인데 오름차순 내림차순이 있음 50개씩 보여주는 메소드
	public List<Employees> selectEmployeesOrderBy(String order) {
		System.out.println("EmployeesDao.java에 selectEMployeesList에 인수로 사용된 order의 값은"+order);
		//Employees타입의 변수를 여러개 받기 위해  배열 생성
		List<Employees> list = new ArrayList<Employees>();
		// 메소드 로딩에 쓸 변수 생성 및 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// 쿼리문이 오름차순이냐 내림차순이냐에 따라 바뀌므로 동적쿼리를 사용하엿따.
		String sql = null;
		if(order.equals("asc")) {
			sql = "select emp_no, birth_date, first_name, last_name, gender, hire_date from employees order by first_name asc limit 50";
		} else if(order.equals("desc")) {
			sql = "select emp_no, birth_date, first_name, last_name, gender, hire_date from employees order by first_name desc limit 50";
		}
		
		// 예외구문을 사용하여 DB에 값을 set메소드를 사용하여 복사
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employees", "root", "java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	// 전체 리스트를 출력하는 메소드
	public List<Employees> selectEmployeesList(int limit) {
		System.out.println("EmployeesDao.java에 selectEMployeesList에 인수로 사용된 limit의 값은"+limit);
		//Employees타입의 변수를 여러개 받기 위해  배열 생성
		List<Employees> list = new ArrayList<Employees>();
		// 메소드 로딩에 쓸 변수 생성 및 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// employees타입들을 전원 출력할 쿼리문 사용 + 너무많아서 몇개씩 출력할껀지 제한하기위해 limit사용
		final String sql = "select emp_no, birth_date, first_name, last_name, gender, hire_date from employees limit ?";
		// 예외구문을 사용하여 DB에 값을 set메소드를 사용하여 복사
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employees", "root", "java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, limit);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// index에 사용할 employeesDB의 사원 수를 구하는 메소드
	public int selectEmployeesCount() {
		int count = 0;
		final String sql = "select count(*) from employees";
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
